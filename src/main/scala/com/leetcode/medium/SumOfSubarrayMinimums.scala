package com.leetcode.medium

import scala.collection.mutable

object SumOfSubarrayMinimums {

  // brute force
  def sumSubarrayMins(arr: Array[Int]): Int = {
    val result = (1 to arr.length).flatMap(i => arr.sliding(i)).map(_.min)
    (result.sum % 1_000_000_007)
  }

  // DP
  def sumSubarrayMinsV2(arr: Array[Int]): Int = {
    val nums   = 0 +: arr
    val result = Array.fill(nums.length)(0L)
    val stack  = mutable.Stack(0)

    nums.indices.foreach { i =>
      stack.popWhile(j => nums(j) > nums(i))
      val j = stack.head
      result(i) = result(j) + (i - j) * nums(i)
      stack.push(i)
    }

    (result.sum % 1_000_000_007).toInt
  }


    def main(args: Array[String]): Unit = {
    println(sumSubarrayMins(Array(3,1,2,4)))
    println(sumSubarrayMins(Array(11,81,94,43,3)))
  }
}
