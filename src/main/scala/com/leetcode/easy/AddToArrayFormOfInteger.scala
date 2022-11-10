package com.leetcode.easy


object AddToArrayFormOfInteger {
  def addToArrayForm(num: Array[Int], k: Int): List[Int] = {
    (BigInt(num.toList.mkString("")) + k).toString.map(_.asDigit).toList
  }

  def main(args: Array[String]): Unit = {
    println(addToArrayForm(Array(1, 2, 0, 0), 34))
  }
}
