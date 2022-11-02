package com.leetcode.easy

import scala.collection.mutable.ArrayBuffer

object CountingBits {
  def countBits(n: Int): Array[Int] = {
    val dp = Array.fill(n + 1)(0)
    var offset = 1

    for (i <- (1 to n)) {
      if (offset * 2 == i) {
        offset = i
      }
      dp.update(i, 1 + dp(i - offset))
    }
    dp

  }

  def main(args: Array[String]): Unit = {
    println(countBits(2).mkString(","))
  }
}
