package com.leetcode.medium

object IntegerToRoman {
  def intToRoman(num: Int): String = {
    val romanTens = Array("I", "X", "C", "M")
    val romanFives = Array("V", "L", "D")
    val mCount = num / 1000
    val numRest = num % 1000

    val str = numRest.toString
    "M" * mCount + str.zip(str.indices.reverse).foldLeft("") { case (acc, (digit, powerOfTen)) =>
      if (digit == '9') {
        acc + romanTens(powerOfTen) + romanTens(powerOfTen + 1)
      }
      else if ((digit >= '5') && (digit < '9')) {
        acc + romanFives(powerOfTen) + romanTens(powerOfTen) * (digit - '5')
      }
      else if (digit == '4') {
        acc + romanTens(powerOfTen) + romanFives(powerOfTen)
      }
      else acc + romanTens(powerOfTen) * (digit - '0')
    }
  }


  def main(args: Array[String]): Unit = {
    println(intToRoman(1994))
  }

}
