package com.leetcode.easy

object RemoveDuplicatesSortedArray {
  def removeDuplicates(nums: Array[Int]): Int = {
    var i = 0
    var j = 0

    while (j < nums.length) {
      if (nums(i) != nums(j)) {
        i += 1
        nums(i) = nums(j)
      }
      j += 1
    }
    i + 1
  }

  def main(args: Array[String]): Unit = {
    println(removeDuplicates(Array(1,1,2)))
    println(removeDuplicates(Array(0,0,1,1,1,2,2,3,3,4)))
  }

}
