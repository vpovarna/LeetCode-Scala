package com.leetcode.easy

object KBeautyNumber {

  def divisorSubstrings(num: Int, k: Int): Int = {
    num.toString.sliding(k).map(_.toInt)
      .filter(_ != 0)
      .count(n => num % n == 0)
  }

  def main(args: Array[String]): Unit = {
//    println(divisorSubstrings(240, 2))
    println(divisorSubstrings(430043, 2))
  }

}
