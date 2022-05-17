package com.leetcode.medium

import org.scalatest.wordspec.AnyWordSpec

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 */
class MaximumProductSubarray {

  def maxProduct(nums: Array[Int]): Int = {
    val len = nums.length
    val maxDp = Array.fill[Int](len)(0)
    val minDp = Array.fill[Int](len)(0)

    maxDp(0) = nums(0)
    minDp(0) = nums(0)

    for (i <- 1 until len) {
      val fromMaxDp = maxDp(i - 1) * nums(i)
      val fromMinDp = minDp(i - 1) * nums(i)
      maxDp(i) = nums(i) max fromMaxDp max fromMinDp
      minDp(i) = nums(i) min fromMaxDp min fromMinDp
    }

    maxDp.max
  }


  def maxProductV1(nums: Array[Int]): Int = {
    if (nums.length == 0) 0
    else {
      var maxEnding = nums(0)
      var minEnding = nums(0)
      var maxSoFar = nums(0)

      for (i <- 1 until nums.length) {
        val tmp = maxEnding
        maxEnding = Math.max(nums(i), Math.max(nums(i) * maxEnding, nums(i) * minEnding))
        minEnding = Math.min(nums(i), Math.min(nums(i) * tmp, nums(i) * minEnding))
        maxSoFar = Math.max(maxSoFar, maxEnding)
      }
      maxSoFar
    }
  }
}

object MaximumProductSubarray {
  def main(args: Array[String]): Unit = {
    val productSubarray = new MaximumProductSubarray()
    println(productSubarray.maxProduct(Array(2, 3, -2, 4))) // 6
    println(productSubarray.maxProduct(Array[Int](0, 2))) // 2
    println(productSubarray.maxProduct(Array[Int](-2, 0, -1))) // 0

  }
}

class MaximumProductSubarraySuite extends AnyWordSpec {
  val maximumProductSubarray = new MaximumProductSubarray()

  "Max Product Subarray class" should {

    "return the max by calculating the product of every N consecutive elements" in {
      assert(maximumProductSubarray.maxProduct(Array[Int](0, 2)) == 2)
      assert(maximumProductSubarray.maxProduct(Array[Int](2, 3, -2, 4)) == 6)
      assert(maximumProductSubarray.maxProduct(Array[Int](-2, 0, -1)) == 0)
      assert(maximumProductSubarray.maxProduct(Array[Int](-2)) == -2)
    }
  }
}
