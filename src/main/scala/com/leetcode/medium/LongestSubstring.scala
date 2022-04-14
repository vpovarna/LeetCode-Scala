package com.leetcode.medium

import scala.collection.mutable

object LongestSubstring {

  def lengthOfLongestSubstring(s: String): Int = {
    var windowStart = 0
    var maxLength = 0
    val charIndices = mutable.Map.empty[Char, Int]

    s.indices.foreach { idx =>
      charIndices.get(s(idx)) match {
        case None =>
          maxLength = math.max(maxLength, charIndices.size + 1)
        case Some(i) =>
          val skipChars = s.substring(windowStart, i + 1)
          windowStart = i + 1
          skipChars.foreach(charIndices.remove)
      }
      charIndices.update(s(idx), idx)
    }
    maxLength
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("abcabcbb"))
  }
}
