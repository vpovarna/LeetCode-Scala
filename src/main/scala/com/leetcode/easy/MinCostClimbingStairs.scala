package com.leetcode.easy

object MinCostClimbingStairs {

  def minCostClimbingStairs(cost: Array[Int]): Int = {
    cost.sliding(2).foldLeft((0, 0)) {
      case ((a0, a1), Array(b0, b1)) =>
        val tmpA1 = Math.min(a1, a0 + b0)
        val tmpA2 = Math.min(a0 + b0, a1 + b1)
        (tmpA1, tmpA2)
    }._2
  }

  def main(args: Array[String]): Unit = {
    println(minCostClimbingStairs(Array(10,15,20)))
    println(minCostClimbingStairs(Array(1,100,1,1,1,100,1,1,100,1)))
  }
}
