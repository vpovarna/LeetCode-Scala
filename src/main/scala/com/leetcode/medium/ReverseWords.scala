package com.leetcode.medium

object ReverseWords {

  def reverseWords(s: String): String = {
    s.split(" ").map(_.trim).filter(_.nonEmpty).reverse.mkString(" ").trim
  }

  def reverseWords2(s: String): String = {
    val words = s.split(" ")
    (words.length - 1 to 0 by -1).foldRight("") { (i, sb) =>
      if (words(i).nonEmpty) words(i).trim + " " + sb
      else sb
    }.trim
  }

  def main(args: Array[String]): Unit = {
    println(reverseWords2("  hello world  "))
    println(reverseWords2("a good   example"))
    println(reverseWords2("the sky is blue"))
  }
}
