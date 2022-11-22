package com.leetcode.medium

import scala.util.control.Breaks.{break, breakable}

object PerfectSquares {

  // Dynamic programming
  def numSquares(n: Int): Int = {
    val dp = Array.fill(n + 1)(Integer.MAX_VALUE)
    dp(0) = 0

    for (target <- 1 to n) {
      breakable {
        for (s <- 1 to target) {
          val square = s * s
          if (target - square < 0) {
            break
          }
          dp(target) = math.min(dp(target), 1 + dp(target - square))
        }
      }
    }
    dp.last
  }

  def numSquaresV2(n: Int): Int = {
    // determine all sqrt until n
    val squares: Seq[Int] = for {
      i <- 1 to n
      sq = math.sqrt(i).toInt
      if (sq * sq == i)
    } yield i


    val dp = Array.fill[Int](n + 1)(n + 1)
    dp(0) = 0

    (1 until dp.length).foreach { i =>
      squares.indices.foreach { j =>
        val c = squares(j)
        if (c <= i) {
          dp(i) = math.min(dp(i), 1 + dp(i - c))
        }
      }
    }

    if (dp(n) <= n) dp(n) else -1
  }

  def main(args: Array[String]): Unit = {
    println(numSquares(12))
    println(numSquaresV2(12))
  }

}
