package com.leetcode.medium

import scala.annotation.tailrec


object LongestPalindromicSubstring {

  def longestPalindrome(s: String): String = {
    if (s == null) null
    else if (s.isEmpty) s
    else getMaxPalindrome(s)
  }

  def getMaxPalindrome(s: String): String = {
    val sLen = s.length

    @tailrec
    def palindromeTailRec(start: Int, end: Int, pointers: (Int, Int) = (0, 0)): (Int, Int) = {
      if (start < 0 || end >= sLen || s(start) != s(end)) pointers
      else {
        val newLen = end - start + 1
        val (startIdx, maxLen) = pointers
        if (newLen > maxLen) palindromeTailRec(start - 1, end + 1, (start, newLen))
        else palindromeTailRec(start - 1, end + 1, (startIdx, maxLen))
      }
    }

    val t = (0 until sLen).foldLeft((0, 0)) { (t, i) =>
      val t1 = palindromeTailRec(i, i)
      val t2 = palindromeTailRec(i, i + 1)
      val t3 = if (t1._2 > t2._2) t1 else t2

      if (t._2 > t3._2) t else t3
    }

    s.substring(t._1, t._1 + t._2)

  }


  def main(args: Array[String]): Unit = {
//    println(longestPalindrome("ebadabe"))
//    println(longestPalindrome("ecbbce"))
//    println(longestPalindrome("babad"))
//    println(longestPalindrome("ac"))
//    println(longestPalindrome("abb"))
    println(longestPalindrome("a"))
  }

}
