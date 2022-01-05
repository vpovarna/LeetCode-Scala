package com.leetcode.easy

import scala.annotation.tailrec

// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
object StringStr {
  def strStr(haystack: String, needle: String): Int = {
    @tailrec
    def recursiveStrStr(haystack: String, idx: Int): Int = {
      if (haystack.length >= needle.length) {
        if ((haystack.head == needle.head) && (haystack.slice(0, needle.length).equals(needle))) idx
        else recursiveStrStr(haystack.tail, idx + 1)
      } else -1
    }

    if (needle.isEmpty) 0
    else recursiveStrStr(haystack, 0)

  }

  def main(args: Array[String]): Unit = {

    println(strStr("hello", "ll"))
    println(strStr("aaaaa", "bba"))
    println(strStr("", ""))
    println(strStr("a", "a"))
  }

}
