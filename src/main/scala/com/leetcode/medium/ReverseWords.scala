package com.leetcode.medium

object ReverseWords {

  def reverseWords(s: String): String = {
    s.split(" ").map(_.trim).filter(_.nonEmpty).reverse.mkString(" ").trim
  }

  def main(args: Array[String]): Unit = {
    val inputStr = "  hello world  "
    println(reverseWords(inputStr))
    println(reverseWords("a good   example"))
    println(reverseWords("the sky is blue"))
  }
}
