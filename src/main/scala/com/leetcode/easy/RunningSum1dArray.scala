package com.leetcode.easy

object RunningSum1dArray {

  def runningSum(nums: Array[Int]): Array[Int] = {
    nums.scanLeft(0)(_ + _).tail
  }

  def main(args: Array[String]): Unit = {
    println(runningSum(Array(1, 2, 3, 4)).mkString("Array(", ", ", ")"))
    println(runningSum(Array(1, 1, 1, 1, 1)).mkString("Array(", ", ", ")"))
  }

}
