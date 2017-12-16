package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._

trait Demonym extends NounPhrase {
  val mužský: PodstatnéMeno
  val ženskský: PodstatnéMeno
  override def asText(pád: Pád)= asText(MužskýŽivotný, Jednotné, pád)
  def asText(rod: Rod.Value, čislo: Čislo.Value, pád: Pád.Value): String =
    (rod match {
      case MužskýŽivotný => mužský setČislo čislo
      case Ženský => ženskský setČislo čislo
    }) asText pád
}

trait PlaceName extends PodstatnéMeno {
  val demonymMužský: Option[String]
  val demonymŽenský: Option[String]
  val adjectival: PrídavnéMeno
  val demonstrative = false
  def demonym: Option[Demonym] = demonymMužský map { m =>
    new Demonym {
      val mužský = PodstatnéMeno(m, MužskýŽivotný)
      val ženskský = PodstatnéMeno(demonymŽenský getOrElse m.replaceFirst("(ec)?$", "ka"), Ženský)
    }
  }
  def asPrídavnéMeno: PrídavnéMeno = adjectival
  def asPríslovka: Príslovka = Príslovka("po " + asPrídavnéMeno.asText(Stredný).replaceFirst(".$", "y"))
  def asOrigin: Príslovka = {
    val p = super.asText(Genitív)
    Príslovka("z" + (if (p.matches("^[szSZ].*")) "o" else "") + " " + p)
  }

}

object PlaceName {
  def apply(
    entry: String, rod: Rod, demonymMužský: String = "", demonymŽenský: String = "", adjectival: String
  ): PlaceName = {
    val parts: Array[String] = entry.split("\\s+")
    require(parts.length <= 2)
    val _entry = parts(parts.length-1)
    val _prídavnéMeno = if (parts.length == 2) Some(PrídavnéMeno(parts(0))) else None
    val _demonymMužský = if (demonymMužský.length > 0) Some(demonymMužský) else None
    val _demonymŽenský = if (demonymŽenský.length > 0) Some(demonymŽenský) else None
    val _adjectival = adjectival
    val _rod = rod
    case class PlaceNameInstance(
      override val čislo: Čislo = Jednotné,
      predložka: String = ""
    ) extends PlaceName {
      val entry = _entry
      override protected val genitiveSingular = "" // until I see a place name that needs this
      val rod = _rod
      override val prídavnéMeno = _prídavnéMeno
      def setPrídavnéMeno(p: PrídavnéMeno): PodstatnéMeno = throw new Exception(s"not implemented")
      val demonymMužský = _demonymMužský
      val demonymŽenský = _demonymŽenský
      val adjectival = PrídavnéMeno(_adjectival)
      def setČislo(c: Čislo) = copy(čislo = c)
    }

    PlaceNameInstance()
  }

}
