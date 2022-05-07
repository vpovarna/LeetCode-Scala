package com.leetcode.easy

object FindDifference {

  def findTheDifference(s: String, t: String): Char = {
    t.diff(s).head
  }

  def main(args: Array[String]): Unit = {
    println(findTheDifference("abcd", "abcde"))
    println(findTheDifference("", "t"))
    println(findTheDifference("a", "aa"))
  }

}
