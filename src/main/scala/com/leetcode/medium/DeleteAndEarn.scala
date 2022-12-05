package com.leetcode.medium

object DeleteAndEarn {
  def deleteAndEarn(nums: Array[Int]): Int = {
    if (nums.length == 0) 0
    else if (nums.length == 1) nums(0)
    else {
      val (max, points) = countAndMax(nums)

      val dp = new Array[Int](max + 1)
      dp(0) = 0
      dp(1) = points.getOrElse(1, 0)

      (2 until dp.length).foreach{ i=>
        val gain = points.getOrElse(i, 0)
        dp(i) = Math.max(dp(i-1), dp(i-2) + gain)
      }
      dp.last
    }
  }

  private def countAndMax(nums: Array[Int]): (Int, Map[Int, Int]) = {
    nums.foldLeft((Integer.MIN_VALUE, Map.empty[Int, Int])) {
      case ((maxValue, map), num) =>
        val tmpMaxValue = Math.max(maxValue, num)
        val tmpMap = map + (num -> (map.getOrElse(num, 0) + num))
        (tmpMaxValue, tmpMap)
    }
  }

  def main(args: Array[String]): Unit = {
    println(deleteAndEarn(Array(3,4,2)))
    println(deleteAndEarn(Array(2,2,3,3,3,4)))
  }
}
