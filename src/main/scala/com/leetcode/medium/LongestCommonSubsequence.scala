package com.leetcode.medium

object LongestCommonSubsequence {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    val m = text1.length
    val n = text2.length

    val dp = Array.fill(m + 1)(Array.fill(n + 1)(0))
    (1 to m).foreach { i =>
      (1 to n).foreach { j =>
        dp(i)(j) =
          if (text1(i - 1) == text2(j - 1)) dp(i - 1)(j - 1) + 1
          else Math.max(dp(i)(j - 1), dp(i - 1)(j))
      }
    }
    dp(m)(n)
  }

  def main(args: Array[String]): Unit = {
    println(longestCommonSubsequence("abcde", "ace"))
  }

}
