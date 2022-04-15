package com.leetcode.easy

object RomanInteger {

  def romanSymbols: Map[String, Int] = Map[String, Int]("I" -> 1, "V" -> 5, "X" -> 10, "L" -> 50, "C" -> 100, "D" -> 500, "M" -> 1000, "IV" -> 4, "IX" -> 9, "XL" -> 40,
    "XC" -> 90, "CD" -> 400, "CM" -> 900)

  def romanToInt(s: String): Int = {
    @annotation.tailrec
    def romanToIntTailRec(remainingString: String, result: Int = 0): Int = {
      if (remainingString.isEmpty) result
      else {
        if (remainingString.length >= 2) {
          val firstChars = remainingString.substring(0, 2)
          if (romanSymbols.contains(firstChars)) romanToIntTailRec(remainingString.drop(2), result + romanSymbols(firstChars))
          else romanToIntTailRec(remainingString.tail, result + romanSymbols(remainingString.head.toString))
        } else
          romanToIntTailRec(remainingString.tail, result + romanSymbols(remainingString.head.toString))
      }
    }

    romanToIntTailRec(s)
  }

  def main(args: Array[String]): Unit = {
    println(romanToInt("III"))
    println(romanToInt("LVIII"))
    println(romanToInt("MCMXCIV"))
  }

}
