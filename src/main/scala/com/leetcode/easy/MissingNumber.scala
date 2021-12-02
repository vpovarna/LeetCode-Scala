package com.leetcode.easy

// Problem description: https://leetcode.com/problems/missing-number/
object MissingNumber extends App {

  def missingNumber(nums: Array[Int]): Int = {
    (0 to nums.length).filter(x => !nums.contains(x))(0)
  }

  println(missingNumber(Array[Int](0)))
  println(missingNumber(Array[Int](0, 1)))
  println(missingNumber(Array[Int](3, 0, 1)))
  println(missingNumber(Array[Int](9, 6, 4, 2, 3, 5, 7, 0, 1)))
}
