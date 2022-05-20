package com.leetcode.easy

import scala.collection.immutable.HashSet

object LongestPalindrome {

  def longestPalindrome(s: String): Int = {
    val (count: Int, charSet: HashSet[Char]) = s.foldLeft((0, HashSet[Char]())) { (tuple, currentChar) =>
      val (count: Int, hashSet: HashSet[Char]) = tuple
      if (hashSet.contains(currentChar)) {
        (count + 2, hashSet - currentChar)
      } else {
        (count, hashSet + currentChar)
      }
    }
    println(charSet)
    count + (if (charSet.nonEmpty) 1 else 0)
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("abccccdd")) //7
    println(longestPalindrome("a")) //1
    println(longestPalindrome("bb"))  //2
    println(longestPalindrome("ccc"))  //3
    println(longestPalindrome("bananas")) //5
  }

}
