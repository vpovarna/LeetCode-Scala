package com.leetcode.easy

object CheckIfTwoStringArraysAreEquivalent {
  def arrayStringsAreEqual(word1: Array[String], word2: Array[String]): Boolean = {
    val w1 = word1.flatten.mkString("")
    val w2 = word2.flatten.mkString("")
    w1 == w2
  }
}
