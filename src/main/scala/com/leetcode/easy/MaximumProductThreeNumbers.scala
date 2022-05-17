package com.leetcode.easy

object MaximumProductThreeNumbers {
  def maximumProduct(nums: Array[Int]): Int = {
    nums.sortInPlace()
    Math.max(nums(0) * nums(1) * nums(nums.length - 1), nums(nums.length - 1) * nums(nums.length - 2) * nums(nums.length - 3))
  }

  def main(args: Array[String]): Unit = {
    println(maximumProduct(Array(1,2,3)))
  }
}
