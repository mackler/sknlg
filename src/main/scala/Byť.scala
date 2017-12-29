package org.mackler.sknlg.slovník

import org.mackler.sknlg._
import Pád._
import Rod._
import Osoba._
import Čislo._

trait Byť extends Sloveso {
  val infinitív = "byť"

  override val paradigm = { (čislo: Čislo, person: Osoba, negate: Boolean) =>
    (if (negate) "nie " else "") + časovanie(čislo.id)(person.id)
  }
  val časovanie = Array(
    Array("som", "si", "je"),   // singular
    Array("sme", "ste", "sú")   // plural
  )
}

object Byť extends Byť {
  def apply = ByťInstance()
  val podmet= Seq.empty[PodstatnéMeno]
  def setPodmet(p: Seq[NounPhrase]) = ByťInstance(podmet = p)
  def addPodmet(p: NounPhrase) = ByťInstance(podmet = Seq(p))
  val príslovka: Option[Príslovka] = None
  val záporný = false
  def setZáporný(z: Boolean) = ByťInstance(záporný = z)
}

case class ByťInstance(
  override val podmet: Seq[NounPhrase] = Seq.empty[PodstatnéMeno],
  override val príslovka: Option[Príslovka] = None,
  záporný: Boolean = false,
  complement: Option[NounPhrase] = None
) extends Byť {
  // can't use require here because of erasure
  complement match {
    case None => // ok
    case Some(_:PodstatnéMeno) => // ok
    case Some(_:PrídavnéMeno) => // ok
    case Some(_:Príslovka) => // ok
    case Some(_:Demonym) => // ok
    case _ => throw new Exception(s"predicate must be a noun, adjective, demonym or adverb")
  }

  def toggleZáporný() = copy(záporný = !záporný)
  def setZáporný(z: Boolean) = copy(záporný = z)
  def setComplement(p: NounPhrase) = copy(complement = Some(p))
  def addPodmet(p: NounPhrase) = copy(podmet = podmet :+ p)
  def setPodmet(p: Seq[NounPhrase]) = copy(podmet = p)
  def setPríslovka(p: Príslovka) = copy(príslovka = Some(p))

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

      // update the subjects with the calculated grammatical-number as necessary
      val updatedPodmet = podmet map { p =>
        if (p.isInstanceOf[On]) p.asInstanceOf[On] setČislo podmetČislo
        else if (p.isInstanceOf[Ja] && podmet.length == 1) p.asInstanceOf[Ja] setČislo podmetČislo
        else if (p.isInstanceOf[Ty] && podmet.length == 1) p.asInstanceOf[Ty] setČislo podmetČislo
        else p
      }

      // Now we've calculated the gender & number; here is the return value:
      // (1) first the subject
      updatedPodmet.map { p =>
        if (p == Ten) {
          Ten.asText(podmetRod.getOrElse(Stredný), podmetČislo, Nominatív)
        }
        else p.asText(Nominatív)
      }.mkString(" a ") + " " +
      // (2) next the verb
      paradigm(podmetČislo, osoba, záporný) + " " +
      // (3) finally the complement
      (dComplement match {
        case p: Pomenovanie => p.asText(Nominatív)
        case p: PodstatnéMeno => reflexivisePossessive(podmet, p) setČislo podmetČislo asText Nominatív
        case p: PrídavnéMeno => p.asText(complementRod, podmetČislo, Nominatív)
        case p: Demonym => p.asText(complementRod, podmetČislo, Nominatív)
        case p: Príslovka => p.reflexivisePossessive(podmet).asText
      })
    }
  }

}
