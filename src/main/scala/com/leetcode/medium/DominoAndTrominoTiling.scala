package com.leetcode.medium

object DominoAndTrominoTiling {
  def numTilings(n: Int): Int = {
    if (n <= 2) n
    else {
      val mod = 1_000_000_007
      val fullTilling = new Array[Long](n + 1)
      val partTilling = new Array[Long](n + 1)

      fullTilling(1) = 1
      fullTilling(2) = 2

      partTilling(1) = 0
      partTilling(2) = 1

      (3 to n).foreach{ i =>
        fullTilling(i) = (fullTilling(i -1) + fullTilling(i-2) + 2 * partTilling(i -1)) % mod
        partTilling(i) = (partTilling(i -1) + fullTilling(i-2)) % mod
      }

      fullTilling(n).toInt
    }

  }

  def main(args: Array[String]): Unit = {
    println(numTilings(3))
  }
}
