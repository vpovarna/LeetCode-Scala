package com.leetcode.easy

object UglyNumber {

  def isUgly(n: Int): Boolean = {
    @scala.annotation.tailrec
    def isUglyTailRec(n: Int): Boolean = {
      if (n % 2 == 0) isUglyTailRec(n / 2)
      else if (n % 3 == 0) isUglyTailRec(n / 3)
      else if (n % 5 == 0) isUglyTailRec(n / 5)
      else if (n == 1) true
      else false
    }

    if (n == 0) false
    else {
      isUglyTailRec(n)
    }
  }

  def main(args: Array[String]): Unit = {
    println(isUgly(1))
    println(isUgly(2))
    println(isUgly(3))
    println(isUgly(5))
    println(isUgly(6))
    print(isUgly(14))
  }
}
