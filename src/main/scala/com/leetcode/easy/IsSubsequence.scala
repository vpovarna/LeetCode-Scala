package com.leetcode.easy

object IsSubsequence {
  def isSubsequence(s: String, t: String): Boolean = {
    if (s.isEmpty) true
    else {
      // TODO: tailrec impl
      var idx = 0
      for (one <- t) {
        if (one == s(idx)) idx += 1
        if (idx == s.length) return true
      }
      false
    }
  }

  def main(args: Array[String]): Unit = {
    println(isSubsequence("abc", "ahbgdc"))
  }

}
