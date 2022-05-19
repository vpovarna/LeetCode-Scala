package com.leetcode.hard

object MinimumSizeSubarraySum {
  def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
    // two pointer problem == both at beginning.
    // the first pointer holds the start of the sub-array and the second pointer holds the end of the array

    var left = 0
    var result = Integer.MAX_VALUE
    var tmpSum = 0

    for (i <- nums.indices) {
      tmpSum += nums(i)

      while(tmpSum >= target) {
        result = Math.min(result, i + 1 - left)
        tmpSum -= nums(left)
        left += 1
      }
    }

    if (result != Integer.MAX_VALUE) result
    else  0
  }


  def main(args: Array[String]): Unit = {
    println(minSubArrayLen(7, Array[Int](2, 3, 1, 2, 4, 3)))
    println(minSubArrayLen(4, Array[Int](1,4,4)))
    println(minSubArrayLen(11, Array[Int](1,1,1,1,1,1,1,1)))
    println(minSubArrayLen(11, Array[Int](1,2,3,4,5)))
  }
}
