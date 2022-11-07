package com.leetcode.easy

object Maximum69Number {
  def maximum69Number(num: Int): Int = {
    val numStr = num.toString
    numStr.indices.foldLeft(num) { (best, i) =>
      {
        if (numStr.charAt(i) == '6') {
          val tmpStrNumber = numStr.toCharArray.updated(i, '9')
          math.max(best, tmpStrNumber.mkString("").toInt)
        } else best
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(maximum69Number(9669)) // 9969
    println(maximum69Number(9996)) // 9999
    println(maximum69Number(9999)) // 9999
  }
}
