package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._

trait Demonym extends NounPhrase {
  val mužský: PodstatnéMenoFactory
  val ženskský: PodstatnéMenoFactory
  override def asText(pád: Pád)= asText(MužskýŽivotný, Jednotné, pád)
  def asText(rod: Rod.Value, čislo: Čislo.Value, pád: Pád.Value): String =
    (rod match {
      case MužskýŽivotný => mužský(čislo = čislo)
      case Ženský => ženskský(čislo = čislo)
    }) asText pád
}

trait PlaceName extends PodstatnéMeno {
  val demonymMužský: Option[String]
  val demonymŽenský: Option[String]
  val adjectival: PrídavnéMeno
  val demonstrative = false
  def demonym: Option[Demonym] = demonymMužský map { m =>
    new Demonym {
      object mužský extends PodstatnéMenoFactory(entry = m, rod = MužskýŽivotný)
      object ženskský extends PodstatnéMenoFactory(entry = demonymŽenský.getOrElse(m.replaceFirst("(ec)?$", "ka")), rod = Ženský)
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
    val _entry = entry
    val _demonymMužský = if (demonymMužský.length > 0) Some(demonymMužský) else None
    val _demonymŽenský = if (demonymŽenský.length > 0) Some(demonymŽenský) else None
    val _adjectival = adjectival
    val _rod = rod
    case class PlaceNameInstance(
      čislo: Čislo = Jednotné,
      override val prídavnéMeno: Option[PrídavnéMeno] = None
    ) extends PlaceName {
      val entry = _entry
      val rod = _rod
      val demonymMužský = _demonymMužský
      val demonymŽenský = _demonymŽenský
      val adjectival = PrídavnéMeno(_adjectival)
      def setČislo(c: Čislo) = copy(čislo = c)
    }

    PlaceNameInstance()

  }

}
