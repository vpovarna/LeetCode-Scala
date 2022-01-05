package com.leetcode.easy

/**
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 */
object LengthOfLastWord {

  def lengthOfLastWord(s: String): Int = {
    val words: Array[String] = s.split(" ")
      .map(_.trim)
      .filter(_ != "")

    words(words.length - 1).length
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLastWord("Hello World"))
    println(lengthOfLastWord("   fly me   to   the moon  "))
    println(lengthOfLastWord("luffy is still joyboy"))
  }


}
