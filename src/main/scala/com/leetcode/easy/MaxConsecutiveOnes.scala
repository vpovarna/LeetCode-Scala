package com.leetcode.easy

object MaxConsecutiveOnes {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    nums.scanLeft(0)((acc, i) => if (i == 0) 0 else acc + i).max
  }

  def main(args: Array[String]): Unit = {
    println(findMaxConsecutiveOnes(Array(1, 1, 0, 1, 1, 1)))
    println(findMaxConsecutiveOnes(Array(1, 1, 0, 1, 1, 1)))
  }

}
