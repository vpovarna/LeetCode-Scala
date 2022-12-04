package com.leetcode.medium

object MinimumAverageDifference {
  def minimumAverageDifference(nums: Array[Int]): Int = {
    val sums = Array.ofDim[Long](nums.length)
    sums(0) = nums.head

    for (i <- 1 until nums.length) {
      sums(i) = sums(i - 1) + nums(i)
    }

    var result: Long = 0
    var minValue: Long = Integer.MAX_VALUE;

    for (i <- nums.indices) {

      val first = i + 1
      val last = nums.length - i - 1

      val firstAverage = sums(i) / first
      val lastAverage = (sums.last - sums(i)) / (if (last == 0) 1 else last)

      if (Math.abs(firstAverage - lastAverage) < minValue) {
        minValue = Math.abs(firstAverage - lastAverage)

        result = i
      }
    }

    result.toInt
  }

  def minimumAverageDifferenceFP(nums: Array[Int]): Int = {
    val prefixSum = nums.scanLeft(0L)(_ + _).tail
    val suffixSum = nums.scanRight(0L)(_ + _).tail

    nums.indices.minBy { i =>
      val prefixAvg = prefixSum(i) / (i + 1)
      val suffixAvg = if (i == nums.length - 1) 0 else suffixSum(i) / (nums.length - 1 - i)
      Math.abs(prefixAvg - suffixAvg)
    }
  }

  def main(args: Array[String]): Unit = {
    println(minimumAverageDifference(Array(2, 5, 3, 9, 5, 3)))
    println(minimumAverageDifference(Array(0)))
  }

}
