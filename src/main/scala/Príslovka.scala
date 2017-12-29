package org.mackler.sknlg

trait Príslovka extends NounPhrase {
  def asText: String
  override def asText(pád: Pád.Value): String = asText
  def reflexivisePossessive(podmet: Seq[NounPhrase]): Príslovka
}

object Príslovka {
  def apply(s: String) = new Príslovka {
    def asText = s
    def reflexivisePossessive(podmet: Seq[NounPhrase]) = this
  }
}
