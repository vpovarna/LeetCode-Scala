package com.leetcode.easy


/*
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 */
object PalindromeProblem extends App {

  def isPalindrome(x: Int): Boolean = {
    if (x < 0) false
    else x.toString == x.toString.reverse
  }

  println(isPalindrome(122))
  println(isPalindrome(121))
  println(isPalindrome(-121))
  println(isPalindrome(10))
}
