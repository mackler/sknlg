package org.mackler.sknlg.slovník

import org.mackler.sknlg._
import Osoba._
import Čislo._

/*
 * Môcť: equivalent to English "can" or "may".
 * Like any other virb except it can have a value member that is a verb indicating the ability.
 */

trait Môcť extends Sloveso {
  val infinitív = "môcť"
  val paradigm = { (čislo: Čislo, osoba: Osoba, záporný: Boolean) =>
    val stem = "môž"
    val negation = if (záporný) "ne" else ""
    val suffix = čislo match {
      case Jednotné => osoba match {
        case First => "em"
        case Second => "eš"
        case Third => "e"
      }
      case Množné => osoba match {
        case First => "eme"
        case Second => "ete"
        case Third => "u"
      }
    }
    negation + stem + suffix
  }

  val podmet = Seq.empty[NounPhrase]
  val záporný: Boolean = false
  val príslovka: Option[Príslovka] = None // no adverbs until we need them
  val auxiliary: Option[Sloveso] = None // what the subject is able to do

  def setAuxiliary(a: Sloveso): Môcť

  /** As an auxiliary verb, the other verb loses its subjects, and this verb assumes them unless it already has any. */
  def setAuxiliary(a: Sloveso, f: (Seq[NounPhrase], Option[Sloveso]) => Môcť): Môcť = {
    val p: Seq[NounPhrase] = if (a.podmet.length > 0) a.podmet else podmet
    f(p, Some(a.setPodmet(Seq.empty[NounPhrase])))
  }

  override val asText: String = {
    super.asText + auxiliary.map(" " + _.asText).getOrElse("")
  }
}

object Môcť extends Môcť {

  def addPodmet(p: NounPhrase): Môcť = apply(podmet = Seq(p))
  def setPodmet(p: Seq[NounPhrase]): Môcť = apply(podmet = p)
  def setZáporný(z: Boolean): Môcť = apply(záporný = z)
  def setAuxiliary(a: Sloveso): Môcť = setAuxiliary(a, apply(_, záporný, _))

  case class MôcťInstance(override val podmet: Seq[NounPhrase] = podmet,
    override val záporný: Boolean = záporný,
    override val auxiliary: Option[Sloveso] = auxiliary
  ) extends Môcť {
    def addPodmet(p: NounPhrase): Sloveso = copy(podmet = p +: podmet)
    def setPodmet(p: Seq[NounPhrase]): Sloveso = copy(podmet = p)
    def setZáporný(z: Boolean): Sloveso = copy(záporný = z)
    def setAuxiliary(a: Sloveso): Môcť = setAuxiliary(a, copy(_, záporný, _))
  }

  def apply(podmet: Seq[NounPhrase] = Seq.empty[NounPhrase], záporný: Boolean = false, auxiliary: Option[Sloveso] = None) = {
    MôcťInstance(podmet, záporný, auxiliary)
  }
}
