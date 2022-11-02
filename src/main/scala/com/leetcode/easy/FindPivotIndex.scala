package com.leetcode.easy

object FindPivotIndex {
  def pivotIndex(nums: Array[Int]): Int = {
    val sumArray = nums.sum

    var tmpSum = 0

    nums.indices.foreach { i =>
      if (tmpSum == sumArray - nums(i) - tmpSum) {
        return i
      } else {
        tmpSum += nums(i)
      }
    }
    -1
  }

  def pivotIndex_v2(nums:Array[Int]): Int = {

    @scala.annotation.tailrec
    def pivotIndexTailRec(i: Int, leftSum:Int, rightSum: Int): Int = {
        if (i == nums.length) -1
        else if (leftSum == rightSum - nums(i)) i
        else pivotIndexTailRec(i +1, leftSum + nums(i), rightSum - nums(i))
    }

    pivotIndexTailRec(0, 0, nums.sum)

  }

  def main(args: Array[String]): Unit = {
    println(pivotIndex_v2(Array(1, 7, 3, 6, 5, 6))) // 3
    println(pivotIndex_v2(Array(1, 2, 3))) // -1
    println(pivotIndex_v2(Array(2, 1, -1))) // 0
  }

}
