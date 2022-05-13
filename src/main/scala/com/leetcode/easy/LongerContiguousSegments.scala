package com.leetcode.easy

object LongerContiguousSegments {
  def checkZeroOnes(s: String): Boolean = {
    val zerosCount = countChar(s, '0')
    val onesCount = countChar(s, '1')
    onesCount.max > zerosCount.max
  }

  def countChar(s: String, target: Char): Seq[Int] = {
    s.scanLeft(0) { (acc, c) => if (c != target) 0 else acc + 1 }
  }

  def main(args: Array[String]): Unit = {
    println(checkZeroOnes("110100010")) // false
    println(checkZeroOnes("1101")) // true
    println(checkZeroOnes("111000")) // false
    println(checkZeroOnes("110100010")) // false
  }
}
