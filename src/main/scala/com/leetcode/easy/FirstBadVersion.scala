package com.leetcode.easy

object FirstBadVersion {
  def firstBadVersion(n: Int): Int = {

    @scala.annotation.tailrec
    def bstFindFalse(from: Int, to: Int): Int = {
      if (from >= to) from
      else {
        val mid = from + (to - from) / 2
        if (isBadVersion(mid)) {
          bstFindFalse(from, mid)
        } else
          bstFindFalse(mid + 1, to)
      }
    }

    bstFindFalse(1, n)
  }

  def isBadVersion(version: Int): Boolean = {
    val state = Map(1 -> true, 2 -> true, 3 -> true, 4 -> false, 5 -> false)
    state(version)
  }

  def main(args: Array[String]): Unit = { println(firstBadVersion(5)) }

}
