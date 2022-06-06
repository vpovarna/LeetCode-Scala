package com.leetcode.easy

object MergeSortedArray {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var i = m - 1
    var j = n - 1
    var k = nums1.length - 1
    while (j >= 0 && k >= 0) {
      if (i >= 0 && nums1(i) > nums2(j)) {
        nums1(k) = nums1(i)
        i -= 1
      } else {
        nums1(k) = nums2(j)
        j -= 1
      }
      k -= 1
    }
  }

  def main(args: Array[String]): Unit = {
    merge(Array(1, 2, 3, 0, 0, 0), 3, Array(2, 5, 6), 3)
    merge(Array(1), 1, Array(), 0)
  }

}
