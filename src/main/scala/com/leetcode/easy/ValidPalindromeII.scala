package com.leetcode.easy

import scala.util.control.Breaks.{break, breakable}

object ValidPalindromeII {
  def validPalindrome(s: String): Boolean = {
    var (i, j) = (0, s.length - 1)
    var res = true

    breakable {
      while (i < j) {
        if (s(i) != s(j)) {
          res = checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j)
          break()
        }

        i += 1
        j -= 1
      }
    }
    res
  }

  def checkPalindrome(s: String, i: Int, j: Int): Boolean = {
    var result = true
    var (p, q) = (i, j)
    while (p < q) {
      if (s(p) != s(q)) {
        result = false
      }
      p += 1
      q -= 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(checkPalindrome("aba", 0, 2))

  }
}
