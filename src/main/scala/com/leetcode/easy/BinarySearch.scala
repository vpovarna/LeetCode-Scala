package com.leetcode.easy

object BinarySearch {

  def search(nums: Array[Int], target: Int): Int = {
    var (i, j) = (0, nums.length - 1)

    while (i <= j) {
      val m = i + (j - i) / 2
      if (nums(m) == target) return m
      if (nums(m) < target) {
        i = m + 1
      } else {
        j = m - 1
      }
    }
    -1
  }
}
