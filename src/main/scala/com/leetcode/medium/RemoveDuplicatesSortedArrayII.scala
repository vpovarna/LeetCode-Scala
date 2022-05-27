package com.leetcode.medium

object RemoveDuplicatesSortedArrayII {

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums == null) 0
    else if (nums.length < 3) nums.length
    else {
      var (i, j) = (0, 1)

      while (j < nums.length) {
        if (nums(j) == nums(i)) {
          if (i == 0) {
            i += 1
            j += 1
          } else if (nums(i) == nums(i - 1)) {
            j += 1
          } else {
            i += 1
            nums(i) = nums(j)
            j += 1
          }
        } else {
          i += 1
          nums(i) = nums(j)
          j += 1
        }
      }
      i + 1
    }
  }

  // TODO: Implement this solution with foldLeft in one traverse
  def removeDuplicatesRecursive(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def removeDuplicatesTailRec(i: Int = 0, j: Int = 1): Int = {
      if (j == nums.length) i + 1
      else if (nums(i) == nums(j)) {
        if (i == 0) removeDuplicatesTailRec(i + 1, j + 1)
        else if (nums(i - 1) == nums(i)) removeDuplicatesTailRec(i, j + 1)
        else {
          // We need to shift / update the array first. Move duplicates to the end
          nums(i + 1) = nums(j)
          removeDuplicatesTailRec(i + 1, j + 1)
        }
      } else {
        // We need to shift / update the array first. Move duplicates to the end
        nums(i + 1) = nums(j)
        removeDuplicatesTailRec(i + 1, j + 1)
      }
    }

    if (nums == null) 0
    else if (nums.length < 3) nums.length
    else {
      removeDuplicatesTailRec()
    }
  }

  def main(args: Array[String]): Unit = {
    println(removeDuplicatesRecursive(Array(1, 1, 1, 2, 2, 3)))
  }

}
