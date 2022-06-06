package com.leetcode.easy

import scala.collection.mutable.ArrayBuffer

object SquaresSortedArray {
  def sortedSquares(nums: Array[Int]): Array[Int] = {
    var (i, j) = (0, nums.length - 1)
    val dp = ArrayBuffer.empty[Int]
    while (i <= j) {
      if (math.abs(nums(i)) < math.abs(nums(j))) {
        dp.append(nums(j) * nums(j))
        j -= 1
      } else {
        dp.append(nums(i) * nums(i))
        i += 1
      }
    }
    dp.reverse.toArray
  }

  // tail recursive solution
  def sortedSquaresRec(nums: Array[Int]): Array[Int] = {
    @scala.annotation.tailrec
    def sortTailRec(i: Int = 0, j: Int = nums.length - 1, dp: List[Int] = List()): List[Int] = {
      if (i > j) dp
      else {
        if (math.abs(nums(i)) < math.abs(nums(j))) sortTailRec(i, j - 1, (nums(j) * nums(j)) +: dp)
        else sortTailRec(i + 1, j, (nums(i) * nums(i)) +: dp)
      }
    }

    sortTailRec().toArray
  }


  def main(args: Array[String]): Unit = {
    println(sortedSquaresRec(Array(-4, -1, 0, 3, 10)).mkString("Array(", ", ", ")"))
  }
}
