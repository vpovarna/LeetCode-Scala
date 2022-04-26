package com.leetcode.medium

object ZigzagConversion {
  def convert(s: String, numRows: Int): String = {
    if (numRows == 1) s
    else {
      var res = ""
      for (r <- 0 until numRows) {
        val increment = 2 * (numRows - 1)
        for (i <- r until s.length by increment) {
          res = s"$res${s(i)}"
          if (r > 0 & r < numRows - 1 & i + increment - 2 * r < s.length) {
            res = s"$res${s(i + increment - 2 * r)}"
          }
        }
      }
      res
    }
  }

  def main(args: Array[String]): Unit = {
    println(convert("PAYPALISHIRING", 4))
  }

}
