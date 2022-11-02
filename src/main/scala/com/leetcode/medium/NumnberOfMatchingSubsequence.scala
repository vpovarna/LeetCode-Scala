package com.leetcode.medium

object NumberOfMatchingSubsequence {

  def numMatchingSubseq(s: String, words: Array[String]): Int = {
    words.count(word => matchSubseq(s, word))
  }

  def matchSubseq(str: String, subStr: String): Boolean = {
    if (subStr.isEmpty) true
    else {
      var i = 0
      for (c <- str) {
        if (c == subStr(i)) i += 1
        if (i == subStr.length) return true
      }
      false
    }
  }

  def main(args: Array[String]): Unit = {
    println(matchSubseq("abcde", "acd")) // true
    println(matchSubseq("abcde", "a")) // true
    println(matchSubseq("abcde", "bb")) // false
    println(numMatchingSubseq("abcde", Array("a","bb","acd","ace"))) // 3
    println(numMatchingSubseq("dsahjpjauf", Array("ahjpjau","ja","ahbwzgqnuk","tnmlanowax"))) // 2
  }

}
