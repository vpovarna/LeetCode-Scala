package com.leetcode.medium

object FindPeakElement {
  // Solution1 -> Binary Search
  def findPeakElement(arr: Array[Int]): Int = {

    var (left, right) = (0, arr.length - 1)

    while (left < right) {
      val midPoint = left + (right - left) / 2

      if (arr(midPoint) < arr(midPoint + 1)) {
        left = midPoint + 1
      } else {
        right = midPoint
      }
    }

    left
  }

  def main(args: Array[String]): Unit = {
    println(findPeakElement(Array(1, 2, 3, 1)))
  }


}
