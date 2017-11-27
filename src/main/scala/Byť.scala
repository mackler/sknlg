package org.mackler.sknlg.slovník

import org.mackler.sknlg._
import Pád._
import Rod._
import Osoba._
import Čislo._

case class Byť(
  podmet: Seq[NounPhrase] = Seq.empty[PodstatnéMeno],
  príslovka: Option[Príslovka] = None,
  záporný: Boolean = false,
  complement: Option[NounPhrase] = None
) extends Sloveso {
  // can't use require here because of erasure
  complement match {
    case None => // ok
    case Some(_:PodstatnéMeno) => // ok
    case Some(_:PrídavnéMeno) => // ok
    case Some(_:Príslovka) => // ok
    case Some(_:Demonym) => // ok
    case _ => throw new Exception(s"predicate must be a noun, adjective, demonym or adverb")
  }

  val infinitív = "byť"
  def toggleZáporný() = this.copy(záporný = !záporný)
  def setZáporný(z: Boolean) = this.copy(záporný = z)
  def setComplement(p: NounPhrase) = copy(complement = Some(p))
  def addPodmet(p: NounPhrase) = copy(podmet = podmet :+ p)
  def setPodmet(p: Seq[NounPhrase]) = copy(podmet = p)

  val časovanie = Array(
    Array("som", "si", "je"),   // singular
    Array("sme", "ste", "sú")   // plural
  )
  override val paradigm = { (čislo: Čislo, person: Osoba, negate: Boolean) =>
    (if (negate) "nie " else "") + časovanie(čislo.id)(person.id)
  }

  override def asText = {
    // There may or may not be a subject, may or may not be a complement
    // If there are both, the case must match; and we try to match gender and number
    val haveSubject = podmet.length > 0
    val haveComplement = complement.isDefined
    if (!haveSubject)
      // No subject: use the infinitive, possibly with a "complement"
      infinitív +
    complement.map { c =>
      " " + (c match {
        case s: Príslovka => s.asText
        case p: PodstatnéMeno => p.asText(Nominatív)
        case p: PrídavnéMeno => p.asText(Stredný, Jednotné, Nominatív)
      })
    }.getOrElse("")
    else if (!haveComplement)
      // No complement: we can treat it like any other verb and use the inherited `asText()` emthod
      super.asText
    else {
      // we have both a subject and a complement, so we try to match gender & number
      // if only one is a common noun, use its gender for the other
      val dComplement = complement.get

      val podmetRod: Option[Rod] =
        if (podmet.exists(p => p.isInstanceOf[Noun] && p.asInstanceOf[Noun].rod == MužskýŽivotný))
          Some(MužskýŽivotný)
        else if (podmet.exists(p => p.isInstanceOf[Noun] && p.asInstanceOf[Noun].rod == MužskýNeživotný))
          Some(MužskýNeživotný)
        else if (podmet.exists(p => p.isInstanceOf[Noun] && p.asInstanceOf[Noun].rod == Ženský))
          Some(Ženský)
        else if (!podmet.exists(p => p.isInstanceOf[Noun]) && dComplement.isInstanceOf[Noun])
          Some(dComplement.asInstanceOf[Noun].rod)
        else if (podmet.exists(p => p.isInstanceOf[Noun] && p.asInstanceOf[Noun].rod == Stredný))
          Some(Stredný)
        else None;

      val complementRod: Rod = dComplement match {
        case p: PodstatnéMeno => p.rod
        case _ => podmetRod.getOrElse(Stredný)
      }

      val podmetČislo =
        if (podmet.length > 1)
          Množné
        else if (podmet(0).isInstanceOf[PodstatnéMeno])
          podmet(0).asInstanceOf[PodstatnéMeno].čislo
        else if (!podmet(0).isInstanceOf[PodstatnéMeno] && dComplement.isInstanceOf[Noun])
          dComplement.asInstanceOf[Noun].čislo
        else if (podmet(0).isInstanceOf[Noun])
          podmet(0).asInstanceOf[Noun].čislo
        else
          Jednotné

      val osoba = if (podmet.exists(_.isInstanceOf[Ja])) First
      else if  (podmet.exists(_.isInstanceOf[Ty])) Second
      else Third

      // Now we've calculated the gender & number; here is the return value:
      // (1) first the subject
      podmet.map { p =>
        if (p == Ten) {
          Ten.asText(podmetRod.getOrElse(Stredný), podmetČislo, Nominatív)
        }
        else if (p.isInstanceOf[On]) p.asInstanceOf[On] setČislo podmetČislo asText(Nominatív)
        else if (p.isInstanceOf[Ty] && podmet.length == 1) p.asInstanceOf[Ty] setČislo podmetČislo asText(Nominatív)
        else if (p.isInstanceOf[Ja] && podmet.length == 1) p.asInstanceOf[Ja] setČislo podmetČislo asText(Nominatív)
        else p.asText(Nominatív)
      }.mkString(" a ") + " " +
      // (2) next the verb
      paradigm(podmetČislo, osoba, záporný) + " " +
      // (3) finally the complement
      (dComplement match {
        case p: Pomenovanie => p.asText(Nominatív)
        case p: PodstatnéMeno => p setČislo podmetČislo asText Nominatív
        case p: PrídavnéMeno => p.asText(complementRod, podmetČislo, Nominatív)
        case p: Demonym => p.asText(complementRod, podmetČislo, Nominatív)
        case p: Príslovka => p.asText
      })
    }
  }

}
