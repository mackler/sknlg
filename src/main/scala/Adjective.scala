package org.mackler.sknlg

import Gender._

trait Adjective {
  def asText(gender: Gender): String
}

