package com.leetcode.easy

object RemoveDuplicates extends App {

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.size <= 1) return nums.size

    val l = nums.indices.tail.foldLeft(0) {
      case (i, j) =>
        if (nums(i) != nums(j)) {
          nums(i + 1) = nums(j)
          i + 1
        } else i
    }

    l + 1
  }

  println(RemoveDuplicates.removeDuplicates(Array(1, 1, 2)))
  println(RemoveDuplicates.removeDuplicates(Array(0,0,1,1,1,2,2,3,3,4)))
}
