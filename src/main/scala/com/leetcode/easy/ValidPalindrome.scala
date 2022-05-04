package com.leetcode.easy

object ValidPalindrome {

  def isPalindrome(s: String): Boolean = {
    val filteredString = s.map(_.toLower).filter(c => ('a' <= c && c <= 'z') || ('0' <= c && c <= '9'))
    // In one line filteredString == filteredString.reverse

    var (i, j) = (0, filteredString.length - 1)
    var result: Boolean = true

    while (i < j) {
      if (filteredString(i) != filteredString(j)) {
        result = false
      }
      i += 1
      j -= 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("0P"))
    println(isPalindrome("race a car"))
  }
}
