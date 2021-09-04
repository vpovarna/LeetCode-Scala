package com.leetcode.top100LikedQuestions

import scala.annotation.tailrec

/**
 * @author Adobe Systems Incorporated.
 */
object MaximumSubarray extends App {

  // Imperative solution
  def maxSubArray(nums: Array[Int]): Int = {
    var sum = 0
    var max = Int.MinValue

    for (n <- nums) {
      sum += n
      if (sum > max) {
        max = sum
      }
      if (sum < 0) sum = 0
    }
    max
  }


  // Using tail recursion
  def newMaxSubArray(nums: Array[Int]): Int = {
    maximumSubArrayRec(nums, 0, Int.MinValue)
  }

  @tailrec
  def maximumSubArrayRec(nums: Array[Int], sum: Int, max: Int): Int = {
    if (nums.isEmpty) max
    else {
      val newSum = sum + nums.head
      val newMax = if (newSum > max) newSum else max
      if (newSum < 0) maximumSubArrayRec(nums.tail, 0, newMax)
      else maximumSubArrayRec(nums.tail, newSum, newMax)
    }
  }

  println(maxSubArray(Array(1)))
  println(maxSubArray(Array(5, 4, -1, 7, 8)))
  println(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
  println(maxSubArray(Array(-1)))


  println(newMaxSubArray(Array(1)))
  println(newMaxSubArray(Array(5, 4, -1, 7, 8)))
  println(newMaxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
  println(newMaxSubArray(Array(-1)))

}
