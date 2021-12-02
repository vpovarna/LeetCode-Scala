package com.leetcode.medium

import org.scalatest.wordspec.AnyWordSpec

import scala.annotation.tailrec

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 */
class MaximumProductSubarray {

  def maxProduct(nums: Array[Int]): Int = {
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
