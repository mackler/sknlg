package org.mackler.sknlg

import Osoba._
import Čislo._
import Pád._

trait Sloveso {
  val infinitív: String
  val paradigm: (Čislo, Osoba, Boolean) => String
  val podmet: Seq[NounPhrase]
  val príslovka: Option[Príslovka]
  val záporný: Boolean
  val predložka: Option[String] = None

  def addPodmet(p: NounPhrase): Sloveso
  def setPodmet(p: Seq[NounPhrase]): Sloveso
  def setZáporný(z: Boolean): Sloveso

  protected def asTextInfinitive: String =
    infinitív + príslovka.map(_.asText + " ").getOrElse("") + predložka.map(" " + _).getOrElse("")

  def asText: String  = {
    (podmet.length match {
      case 0 => // no subject so generate inifinitive form
        asTextInfinitive
      case _ =>
        val osoba =
          if (podmet.exists(s => s.isInstanceOf[Ja])) Osoba.First
          else if (podmet.exists(s => s.isInstanceOf[Ty])) Osoba.Second
          else Osoba.Third
        val čislo =
          if (podmet.length > 1 ||
            podmet(0).isInstanceOf[Noun] && podmet(0).asInstanceOf[Noun].čislo == Čislo.Množné)
            Čislo.Množné
          else
            Čislo.Jednotné
        podmet.map(_.asText(Nominatív)).mkString(" a ") + " " +
        paradigm(čislo, osoba, záporný) +
        príslovka.map(" " + _.asText).getOrElse("")
    })
  }
}

trait Paradigm {
  val presentStem: String
  val presentThematicMorpheme: String
  val presentThematicMorpheme2: String
  val thirdPersonPluralRelationalMorpheme = "ú"

  lazy val t = if (finalSyllableIsLong(presentStem)) presentThematicMorpheme match {
    case "á" => "a"
    case "í" => "i"
    case o => o
  } else presentThematicMorpheme

  def apply(čislo: Čislo, osoba: Osoba, záporný: Boolean): String = {
    (if (záporný) "ne" else "") +
    presentStem +
    {
      čislo match {
        case Jednotné => osoba match {
          case First =>  t + "m"
          case Second => t + "š"
          case Third =>  t
        }
        case Množné => osoba match {
          case First =>  t + "me"
          case Second => t + "te"
          case Third =>  presentThematicMorpheme2 + thirdPersonPluralRelationalMorpheme
        }
      }
    }

  }
}

object Paradigm {
  class Chytať(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "á"
    val presentThematicMorpheme2 = "aj"
  }
  class Rozumieť(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "ie"
    val presentThematicMorpheme2 = "ej"
  }
  class Niesť(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "ie"
    val presentThematicMorpheme2 = ""
  }
  class Hynúť(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "ie"
    val presentThematicMorpheme2 = ""
  }
  class Trieť(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "ie"
    val presentThematicMorpheme2 = ""
  }
  class Brať(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "ie"
    val presentThematicMorpheme2 = ""
  }
  class Česať(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "e"
    val presentThematicMorpheme2 = ""
  }
  class Žat(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "e"
    val presentThematicMorpheme2 = ""
  }
  class Chudnúť(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "ne"
    val presentThematicMorpheme2 = "n"
  }
  class Žuť(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "je"
    val presentThematicMorpheme2 = "j"
  }
  class Pracovať(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "je"
    val presentThematicMorpheme2 = "j"
  }
  class Robiť(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "í"
    val presentThematicMorpheme2 = ""
    override val thirdPersonPluralRelationalMorpheme = "ia"
  }
  class Vidieť(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "í"
    val presentThematicMorpheme2 = ""
    override val thirdPersonPluralRelationalMorpheme = "ia"
  }
  class Kričať(infinitív: String, val presentStem: String) extends Paradigm {
    val presentThematicMorpheme = "í"
    val presentThematicMorpheme2 = ""
    override val thirdPersonPluralRelationalMorpheme = "ia"
  }
}

object Sloveso {
  def apply(infinitív: String, thirdPerSing: String) = {
    import Paradigm._
    val paradigm =
      if (thirdPerSing.endsWith("e") &&
        (infinitív.endsWith("čať") || infinitív.endsWith("jať") || infinitív.endsWith("päť") || infinitív.endsWith("žať"))) {
        val presentStem = thirdPerSing.replaceFirst("e$", "")
        new Žat(infinitív, presentStem)
      } else if (infinitív endsWith "ať") {
        if (thirdPerSing.endsWith("á") || thirdPerSing.endsWith("a")) {
          val presentStem = thirdPerSing.replaceFirst("[aá]$", "")
          new Chytať(infinitív, presentStem)
        } else if (thirdPerSing endsWith "ie") {
          val presentStem = thirdPerSing.replaceFirst("ie$", "")
          new Brať(infinitív, presentStem)
        } else if (thirdPerSing endsWith "í") {
          val presentStem = thirdPerSing.replaceFirst("í$", "")
          new Kričať(infinitív, presentStem)
        } else if (thirdPerSing endsWith "uje") {
          val presentStem = thirdPerSing.replaceFirst("je$", "")
          new Pracovať(infinitív, presentStem)
        } else if (thirdPerSing endsWith "e") {
          val presentStem = thirdPerSing.replaceFirst("e$", "")
          new Česať(infinitív, presentStem)
        } else throw new Exception(s"invalid verb form $infinitív/$thirdPerSing")
      } else if (infinitív endsWith "ieť") {
        if (thirdPerSing endsWith "ie") {
          val presentStem = thirdPerSing.replaceFirst("ie$", "")
          new Rozumieť(infinitív, presentStem)
        } else if (thirdPerSing endsWith "í") {
          val presentStem = thirdPerSing.replaceFirst("í$", "")
          new Vidieť(infinitív, presentStem)
        } else  throw new Exception(s"invalid verb form $infinitív/$thirdPerSing")
      } else if (infinitív endsWith "úť") {
        if (thirdPerSing endsWith "ie") {
          val presentStem = thirdPerSing.replaceFirst("ie$", "")
          new Hynúť(infinitív, presentStem)
        } else if (thirdPerSing endsWith "e") {
          val presentStem = thirdPerSing.replaceFirst("ne$", "")
          new Chudnúť(infinitív, presentStem)
        } else throw new Exception(s"invalid verb form $infinitív/$thirdPerSing")
      } else if (infinitív endsWith "iť") {
        val presentStem = thirdPerSing.replaceFirst("í$", "")
        new Robiť(infinitív, presentStem)
      } else if (thirdPerSing endsWith "ie") {
        if (infinitív.endsWith("riesť") || infinitív == "mlieť" || infinitív == "smieť") {
          val presentStem = thirdPerSing.replaceFirst("ie$", "")
          new Trieť(infinitív, presentStem)
        } else {
          val presentStem = thirdPerSing.replaceFirst("ie$", "")
          new Niesť(infinitív, presentStem)
        }
      } else if (thirdPerSing endsWith "je") {
        val presentStem = thirdPerSing.replaceFirst("je$", "")
        new Žuť(infinitív, presentStem)
      } else
          throw new Exception(s"invalid verb form $infinitív/$thirdPerSing")

    SlovesoFactory(infinitív, paradigm.apply(_,_,_))
  }

}

trait RegularSloveso extends Sloveso {
  val directPredmet: Option[PodstatnéMeno]
  def setPredmet(o: PodstatnéMeno): Sloveso
  override def asText: String  = {
    super.asText + directPredmet.map(" " + _.asText(Akusatív)).getOrElse("")
  }
}

object SlovesoFactory {
  def apply(infinitív: String, paradigm: (Čislo, Osoba, Boolean) => String) = {
    val _infinitív = infinitív
    val _paradigm = paradigm
    case class SlovesoInstance(
      podmet        : Seq[NounPhrase]       = Seq.empty[Noun],
      directPredmet : Option[PodstatnéMeno] = None,
      príslovka     : Option[Príslovka]        = None,
      záporný       : Boolean               = false
    ) extends RegularSloveso {
      val infinitív = _infinitív
      val paradigm = _paradigm
      def addPodmet(p: NounPhrase)= this.copy(podmet = podmet :+ p)
      def setPodmet(s: Seq[NounPhrase])= this.copy(podmet = s)
      def setPredmet(o: PodstatnéMeno) = this.copy(directPredmet = Some(o))
      def setPríslovka(p: Príslovka) = this.copy(príslovka = Some(p))
      def toggleZáporný() = this.copy(záporný = !záporný)
      def setZáporný(z: Boolean) = this.copy(záporný = z)

      override def equals(other: Any): Boolean = other match {
        case that: RegularSloveso => this.infinitív == that.infinitív
        case _ => false
      }

      override def hashCode = infinitív.##

    }
    SlovesoInstance()
  }
}
