package com.leetcode.easy

object RotateArray {
  def rotate(nums: Array[Int], k: Int): Unit = {
    val kk = k % nums.length
    rotateArray(nums, 0, nums.length -1)
    rotateArray(nums, 0, kk -1)
    rotateArray(nums, kk, nums.length -1)
  }

  def rotateArray(nums: Array[Int], l: Int, r:Int): Unit = {
    var (left, right) = (l,r)
    while (left < right) {
      val tmp = nums(left)
      nums(left) = nums(right)
      nums(right) = tmp
      left = left + 1
      right = right - 1
    }
  }
}
