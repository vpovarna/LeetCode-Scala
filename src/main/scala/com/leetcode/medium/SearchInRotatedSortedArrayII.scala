package com.leetcode.medium


object SearchInRotatedSortedArrayII {
  // linear search
  def search(nums: Array[Int], target: Int): Boolean = {
    for (num <- nums) {
      if (num == target) {
        return true
      }
    }
    false
  }

  // binary search implementation

  def bs(nums: Array[Int], target: Int): Boolean = {
    var (leftPointer, rightPointer) = (0, nums.length - 1)

    while (leftPointer <= rightPointer) {
      // calculate middle
      val middle = leftPointer + (rightPointer - leftPointer) / 2

      if (nums(middle) == target || nums(leftPointer) == target || nums(rightPointer) == target) {
        return true
      }

      if (nums(middle) < nums(rightPointer)) {
        if (nums(middle) < target && nums(rightPointer) > target) {
          leftPointer = middle + 1
        } else {
          rightPointer = middle - 1
        }
      } else if (nums(middle) > nums(rightPointer)) {
        if (nums(leftPointer) < target && nums(middle) > target) {
          rightPointer = middle - 1
        } else {
          leftPointer = leftPointer + 1
        }
      } else {
        rightPointer = rightPointer - 1
      }
    }

    false
  }


  def main(args: Array[String]): Unit = {
    println(bs(Array(2,5,6,0,0,1,2), 0))
  }

}
