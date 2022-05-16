package com.leetcode.medium

import scala.collection.mutable.ArrayBuffer

object HouseRobberII {
  def rob(nums: Array[Int]): Int = {
    if (nums.isEmpty) 0
    else if (nums.length == 1) nums.head
    else {
      val array1 = nums.drop(1)
      val array2 = nums.dropRight(1)
      Math.max(houseRobber(array1), houseRobber(array2))
    }
  }

  private def houseRobber(nums: Array[Int]): Int = {
    val dp: ArrayBuffer[Int] = ArrayBuffer.empty[Int]
    dp.addOne(0)
    dp.addOne(nums(0))

    (1 until nums.length).foldLeft(dp)((dp, i) =>
      dp.addOne(Math.max(dp(i), dp(i - 1) + nums(i)))
    )
    dp.last
  }

  def main(args: Array[String]): Unit = {
    println(rob(Array(1))) // 1
    println(rob(Array(2, 3, 2))) // 3
    println(rob(Array(1, 2, 3, 1))) // 4
    println(rob(Array(1, 2, 3))) // 3
  }
}
