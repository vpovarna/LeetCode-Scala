package com.leetcode.easy

object ConsecutiveCharacters {

  def maxPower(s: String): Int = {
    s.scanLeft((0, '\u000C')) { (acc, c) =>
      acc match {
        case (tmpSum, prevChar) =>
          if (prevChar != c) (0, c)
          else (tmpSum + 1, c)
      }
    }
      .map(_._1)
      .max + 1
  }


  def main(args: Array[String]): Unit = {
    println(maxPower("leetcode"))
    println(maxPower("abbcccddddeeeeedcba"))
  }

}
