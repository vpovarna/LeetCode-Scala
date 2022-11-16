package com.leetcode.easy

import scala.annotation.tailrec

object GuessNumberHigherOrLower {

  def guess(i: Int): Int = 0

  def guessNumber(n: Int): Int = {
    var (i, j) = (1, n)

    while (i < j) {
      val mid = i + (j - i) / 2
      val v = guess(mid)

      if (v == 0) {
        return mid
      } else if (v > 0) {
        i = mid + 1
      } else {
        j = mid - 1
      }
    }
    i
  }

  def guessNumberV2(n: Int): Int = {

    @tailrec
    def guessNumberTailRec(i: Int, j: Int, v: Int): Int = {
      if (i >= j) i
      else if (v == 0) i + (j - i) / 2
      else {
        val mid = i + (j - i) / 2
        val v = guess(mid)
        if (v == 0) guessNumberTailRec(i, j, 0)
        else if (v > 0) guessNumberTailRec(mid + 1, j, Int.MaxValue)
        else guessNumberTailRec(i, mid - 1, Int.MaxValue)
      }
    }

    guessNumberTailRec(1, n, Int.MinValue)
  }

  def main(args: Array[String]): Unit = {}
}
