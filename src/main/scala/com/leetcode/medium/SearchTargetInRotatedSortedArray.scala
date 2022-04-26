package com.leetcode.medium

object SearchTargetInRotatedSortedArray {

  def searchRange(nums: Array[Int], target: Int): Int = {

    var l = 0
    var r = nums.length - 1
    var result = -1

    while (l <= r) {
      val m = (l + r) / 2

      if (nums(m) == target) result = m
      // left array
      if (nums(l) <= nums(m)) {
        if (target > nums(m) || target < nums(l)) {
          l = m + 1
        } else {
          r = m - 1
        }
        // right array
      } else {
        if (target < nums(m) || target > nums(r)) {
          r = m - 1
        } else {
          l = m + 1
        }
      }
    }

    result
  }

  def main(args: Array[String]): Unit = {
    println(searchRange(Array(4, 5, 6, 7, 0, 1, 2), 0))
  }

}
