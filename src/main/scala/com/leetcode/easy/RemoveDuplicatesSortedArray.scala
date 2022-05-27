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

  // TODO: Implement with fold Left
  def removeDuplicatesRecursive(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def removeDuplicatesTailRec(i: Int = 0, j: Int = 0): Int = {
      if (j == nums.length) i + 1
      else {
        if (nums(i) != nums(j)) {
          nums(i + 1) = nums(j)
          removeDuplicatesTailRec(i + 1, j + 1)
        } else removeDuplicatesTailRec(i, j + 1)
      }
    }

    removeDuplicatesTailRec()
  }

  def main(args: Array[String]): Unit = {
    println(removeDuplicatesRecursive(Array(1, 1, 2)))
    println(removeDuplicatesRecursive(Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
  }

}
