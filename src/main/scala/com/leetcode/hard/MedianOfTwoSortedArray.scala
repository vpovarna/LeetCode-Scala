package com.leetcode.hard

object MedianOfTwoSortedArray {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val result = (nums1 ++ nums2).sorted
    val median = result.length / 2
    if (result.length % 2 == 0) (result(median) + result(median - 1)).toDouble / 2.toDouble
    else result(median)
  }

  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays(Array(1, 3), Array(2)))
    println(findMedianSortedArrays(Array(1, 2), Array(3, 4)))
  }
}
