package com.leetcode.medium

object LongestPalindromeConcatenatingTwoLetterWords {

  def longestPalindrome(words: Array[String]): Int = {
    val wordsCountMap = getWordCountMap(words)

    // TODO: Add tailrec impl
    var answer = 0
    var isCenter = false

    for (entry <- wordsCountMap) {
      val (word, occurrence) = entry
      // check if the word has the same chars
      if (word(0) == word(1)) {
        if (occurrence % 2 == 0) {
          answer += occurrence
        } else {
          answer += occurrence - 1
          isCenter = true
        }
      } else if (word(0) < word(1)) {
        val reverseWord = s"${word(1)}${word(0)}"
        if (wordsCountMap.contains(reverseWord)) {
          answer += 2 * Math.min(occurrence, wordsCountMap(reverseWord))
        }
      }
    }

    if (isCenter) answer += 1
    2 * answer
  }

  private def getWordCountMap(words: Array[String]): Map[String, Int] = {
    words.foldLeft(Map.empty[String, Int]) { (map, word) =>
      map + (word -> (map.getOrElse(word, 0) + 1))
    }
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome(Array("lc", "cl", "gg"))) // 6
    println(longestPalindrome(Array("ab", "ty", "yt", "lc", "cl", "ab"))) // 8
    println(longestPalindrome(Array("cc", "ll", "xx"))) // 2
    println(
      longestPalindrome(
        Array(
          "dd",
          "aa",
          "bb",
          "dd",
          "aa",
          "dd",
          "bb",
          "dd",
          "aa",
          "cc",
          "bb",
          "cc",
          "dd",
          "cc"
        )
      )
    ) // 22
  }
}
