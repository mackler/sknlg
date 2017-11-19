package org.mackler.sknlg

import Rod._
import Osoba._
import Čislo._
import Pád._

/*
 * Hard consonants: g, h, ch, k, d, n, t
 * Soft consonants: c, dz, j, all consonants with the mäkčeň
 * Neutral consonants: b, f, l, m, p, r, s, v, z  
 */

object Slovník {

  /*
   * PodstatnéMeno
   */

  // Masculine Animate
  // not ending in -a, e.g., "chlap", "muž"
  object Býk extends PodstatnéMenoFactory(entry = "býk", rod = MužskýŽivotný)
  object Muž extends PodstatnéMenoFactory(entry = "muž", rod = MužskýŽivotný)
  object Chlapec extends PodstatnéMenoFactory(entry = "chlapec", rod = MužskýŽivotný)
  object Kocúr extends PodstatnéMenoFactory(entry = "kocúr", rod = MužskýŽivotný)
  object Kôň extends PodstatnéMenoFactory(entry = "kôň", rod = MužskýŽivotný)
  object Pán extends PodstatnéMenoFactory(entry = "pán", rod = MužskýŽivotný)
  object Učiteľ extends PodstatnéMenoFactory(entry = "učiteľ", rod = MužskýŽivotný)
  // ending in -a, e.g., "hrdina", "kolega""

  // Masculine Inanimate
  // ending in hard or neutral consonant, e.g., "dub", "plán"
  object Breh extends PodstatnéMenoFactory(entry = "breh", rod = MužskýNeživotný)
  object Deň extends PodstatnéMenoFactory(entry = "deň", rod = MužskýNeživotný)
  object Dom extends PodstatnéMenoFactory(entry = "dom", rod = MužskýNeživotný)
  object Dvor extends PodstatnéMenoFactory(entry = "dvor", rod = MužskýNeživotný)
  object Hrad extends PodstatnéMenoFactory(entry = "hrad", rod = MužskýNeživotný)
  object Kufor extends PodstatnéMenoFactory(entry = "kufor", rod = MužskýNeživotný)
  object Kvet extends PodstatnéMenoFactory(entry = "kvet", rod = MužskýNeživotný)
  object Les extends PodstatnéMenoFactory(entry = "les", rod = MužskýNeživotný)
  object Obchod extends PodstatnéMenoFactory(entry = "obchod", rod = MužskýNeživotný)
  object Obraz extends PodstatnéMenoFactory(entry = "obraz", rod = MužskýNeživotný)
  object Plot extends PodstatnéMenoFactory(entry = "plot", rod = MužskýNeživotný)
  object Prst extends PodstatnéMenoFactory(entry = "prst", rod = MužskýNeživotný)
  object Strom extends PodstatnéMenoFactory(entry = "strom", rod = MužskýNeživotný)
  object Večer extends PodstatnéMenoFactory(entry = "večer", rod = MužskýNeživotný)
  object Voz extends PodstatnéMenoFactory(entry = "voz", rod = MužskýNeživotný)
  // ending in soft consonant, e.g., "počitač"
  object Dunaj extends PodstatnéMenoFactory(entry = "Dunaj", rod = MužskýNeživotný)

  // Feminine
  // ending in -a preceded by a hard or neutral consonant, e.g., "žena"
  object Cena extends PodstatnéMenoFactory(entry = "cena", rod = Ženský)
  object Dedina extends PodstatnéMenoFactory(entry = "dedina", rod = Ženský)
  object Hlava extends PodstatnéMenoFactory(entry = "hlava", rod = Ženský)
  object Kniha extends PodstatnéMenoFactory(entry = "kniha", rod = Ženský)
  object Krava extends PodstatnéMenoFactory(entry = "krava", rod = Ženský)
  object Lúka extends PodstatnéMenoFactory(entry = "lúka", rod = Ženský)
  object Mačka extends PodstatnéMenoFactory(entry = "mačka", rod = Ženský)
  object Minúta extends PodstatnéMenoFactory(entry = "minúta", rod = Ženský)
  object Noha extends PodstatnéMenoFactory(entry = "noha", rod = Ženský)
  object Otázka extends PodstatnéMenoFactory(entry = "otázka", rod = Ženský)
  object Rada extends PodstatnéMenoFactory(entry = "rada", rod = Ženský)
  object Rieka extends PodstatnéMenoFactory(entry = "rieka", rod = Ženský)
  object Ruka extends PodstatnéMenoFactory(entry = "ruka", rod = Ženský)
  object Stavba extends PodstatnéMenoFactory(entry = "stavba", rod = Ženský)
  object Stena extends PodstatnéMenoFactory(entry = "stena", rod = Ženský)
  object Škola extends PodstatnéMenoFactory(entry = "škola", rod = Ženský)
  object Trieda extends PodstatnéMenoFactory(entry = "trieda", rod = Ženský)
  object Učiteľka extends PodstatnéMenoFactory(entry = "učiteľka", rod = Ženský)
  object Voda extends PodstatnéMenoFactory(entry = "voda", rod = Ženský)
  object Žena extends PodstatnéMenoFactory(entry = "žena", rod = Ženský)
  object Záhrada extends PodstatnéMenoFactory(entry = "záhrada", rod = Ženský)
  // ending in -a preceding by a soft consonant, e.g., "ulica", "stanica"
  object Stanica extends PodstatnéMenoFactory(entry = "stanica", rod = Ženský)
  object Ulica extends PodstatnéMenoFactory(entry = "ulica", rod = Ženský)
  // following "dlaň", "loď"
  object Dlaň extends PodstatnéMenoFactory(entry = "dlaň", rod = Ženský)
  object Kaviareň extends PodstatnéMenoFactory(entry = "kaviareň", rod = Ženský)
  object Radosť extends PodstatnéMenoFactory(entry = "radosť", rod = Ženský)
  // ending in consonant in nominative singular, -i in genitive singular, e.g., "kosť", "miestnosť"
  object Pomoc extends PodstatnéMenoFactory(entry = "pomoc", rod = Ženský)
  object Vec extends PodstatnéMenoFactory(entry = "vec", rod = Ženský)
  // uncategorized Feminine
  object Tvár extends PodstatnéMenoFactory(entry = "tvár", rod = Ženský)
  object Pani extends PodstatnéMenoFactory(entry = "pani", rod = Ženský)


  // Neuter
  // ending in -o, e.g., "mesto"
  object Auto extends PodstatnéMenoFactory(entry = "auto", rod = Stredný)
  object Čelo extends PodstatnéMenoFactory(entry = "čelo", rod = Stredný)
  object Mesto extends PodstatnéMenoFactory(entry = "mesto", rod = Stredný)
  object Mlieko extends PodstatnéMenoFactory(entry = "mlieko", rod = Stredný)
  object Oko extends PodstatnéMenoFactory(entry = "oko", rod = Stredný)
  object Rameno extends PodstatnéMenoFactory(entry = "rameno", rod = Stredný)
  object Ráno extends PodstatnéMenoFactory(entry = "ráno", rod = Stredný)
  object Sklo extends PodstatnéMenoFactory(entry = "sklo", rod = Stredný)
  // ending -e, e.g., "more"
  object Srdce extends PodstatnéMenoFactory(entry = "srdce", rod = Stredný)
  // ending -ie, e.g., "poschodie""
  object Namestie extends PodstatnéMenoFactory(entry = "namestie", rod = Stredný)
  // ending -a or -ä, e.g., "dievča"
  object Dieťa extends PodstatnéMenoFactory(entry = "dieťa", rod = Stredný)
  object Dievča extends PodstatnéMenoFactory(entry = "dievča", rod = Stredný)
  object Mača extends PodstatnéMenoFactory(entry = "mača", rod = Stredný)
  object Teľa extends PodstatnéMenoFactory(entry = "teľa", rod = Stredný)

  /*
   * PrídavnéMeno
   */

  val Čistý = new PrídavnéMeno("čistý")
  val Dobrý = new PrídavnéMeno("dobrý")
  val Ešte = new PrídavnéMeno("hnedý")
 val Hnedý = new PrídavnéMeno("hnedý")
  val Hlavný = new PrídavnéMeno("hlavny")
  val Hospodársky = new PrídavnéMeno("hospodársky")
  // TODO jeden, jedna, jedno
  val Jednoduchý = new PrídavnéMeno("jednoduchý")
  val Krázny = new PrídavnéMeno("krázný")
  // TODO this is actually not an adjective but an interrogative pronoun
  val Ktorý = new PrídavnéMeno("ktorý")
  val Malý = new PrídavnéMeno("malý")
  val Mladý = new PrídavnéMeno("mladý")
  val Modrý = new PrídavnéMeno("modrý")
  // TODO this is not actually an adjective but an indefinite pronoun
  val Nejaký = new PrídavnéMeno("nejaký")
  val Nízky = new PrídavnéMeno("nízky")
  val Nový = new PrídavnéMeno("nový")
  val Pekný = new PrídavnéMeno("pekný")
  val Posledný = new PrídavnéMeno("posledný")
  val Pravý = new PrídavnéMeno("pravý")
  val Široký = new PrídavnéMeno("široký")
  val Škaredý = new PrídavnéMeno("škaredý")
  val Špinavý = new PrídavnéMeno("špinavý")
  val Starý = new PrídavnéMeno("starý")
  // This is not actually an adjective but a demonstrative pronoun
  val Taký = new PrídavnéMeno("taký")
  val Veľký = new PrídavnéMeno("veľký")
  val Vysoký = new PrídavnéMeno("vysoký")
  val Zelený = new PrídavnéMeno("zelený")
  val Zlý = new PrídavnéMeno("zlý")

  /*
   * Sloveso
   */

  // Irregular verbs: to be, to go

  case class Byť(
    podmet: Seq[NounPhrase] = Seq.empty[PodstatnéMeno],
    príslovka: Option[String] = None,
    záporný: Boolean = false,
    complement: Option[NounPhrase] = None
  ) extends Sloveso(podmet, None, príslovka, záporný) {
    // can't use require here because of erasure
    complement match {
      case None => // ok
      case Some(_:PodstatnéMeno) => // ok
      case Some(_:PrídavnéMeno) => // ok
      case Some(_:Príslovka) => // ok
      case _ => throw new Exception(s"predicate must be a noun, adjective or adverb")
    }

    override val infinitív = "byť"
    def toggleZáporný() = this.copy(záporný = !záporný)
    def setZáporný(z: Boolean) = this.copy(záporný = z)
    def setComplement(p: NounPhrase) = copy(complement = Some(p))
    def addPodmet(p: NounPhrase) = copy(podmet = podmet :+ p)

    val časovanie = Array(
      Array("som", "si", "je"),   // singular
      Array("sme", "ste", "sú")   // plural
    )
    override def inflect(čislo: Čislo, person: Osoba, negate: Boolean): String =
      (if (negate) "nie " else "") + časovanie(čislo.id)(person.id)

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
        inflect(podmetČislo, osoba, záporný) + " " +
        // (3) finally the complement
        (dComplement match {
          case p: Pomenovanie => p.asText(Nominatív)
          case p: PodstatnéMeno => p setČislo podmetČislo asText Nominatív
          case p: PrídavnéMeno =>
            p.asText(complementRod, podmetČislo, Nominatív)
          case p: Príslovka => p.asText
        })
      }
    }

  }

  case class Ísť(
    podmet: Seq[Noun] = Seq.empty[PodstatnéMeno],
    príslovka: Option[String] = None,
    záporný: Boolean = false,
//    complement: Option[PrídavnéMeno] = None,
    directPredmet: Option[PodstatnéMeno] = None // TODO probably not really a direct object
  ) extends Sloveso(podmet, None, príslovka, záporný) with TransitiveVerb {
    override val infinitív = "ísť"
    def addPodmet(p: Noun) = this.copy(podmet = podmet :+ p)
    def setPredmet(o: PodstatnéMeno): Sloveso = this.copy(directPredmet = Some(o))
    def toggleZáporný() = this.copy(záporný = !záporný)
    def setZáporný(z: Boolean) = this.copy(záporný = z)

    val časovanie = Array(
      Array("idem", "ideš", "ide"),   // singular
      Array("ideme", "idete", "idú")   // plural
    )
    override def inflect(čislo: Čislo, person: Osoba, negate: Boolean): String =
      (if (negate) "nie " else "") + časovanie(čislo.id)(person.id)

  }


  // Type1 Verbs follow "chytať" - "chytám"
  object Mať extends Type1Factory("mať")
  object Bývať extends Type1Factory("bývať")
  object Čakať extends Type1Factory("čakať")
  object Hľadať extends Type1Factory("hľadať")
  object Poznať extends Type1Factory("poznať")

  // Type 11 verbs follow "pracuvať"
  val Potrebovať = new SlovesoType11Factory("potrebovať")

  // Type 12 verbs follow "robiť"
  // TOTO WARNING I ONLY GUESSED THIS VERB's TYPE!!!!
  val Obrátiť = new SlovesoType12Factory("obrátiť")
  val Robiť = new SlovesoType12Factory("robiť")

  // Type 13 verbs follow "vidieť" - "vidím"
  val Vidieť = new SlovesoType13Factory("vidieť")

}
