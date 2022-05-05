package com.leetcode.medium

import scala.collection.mutable

object LongestConsecutiveSequence {
  def longestConsecutive(nums: Array[Int]): Int = {
    val hashSet: mutable.Set[Int] = nums.foldLeft(mutable.HashSet[Int]()) { (set, num) =>
      set.addOne(num)
    }

    var longestLength = 0

    for (num <- nums) {
      if (!hashSet.contains(num - 1)) {
        var currentNum = num
        var currentLength = 1

        while (hashSet.contains(currentNum + 1)) {
          currentLength += 1
          currentNum += 1
        }

        longestLength = Math.max(longestLength, currentLength)
      }
    }

    longestLength
  }

  def main(args: Array[String]): Unit = {
    println(longestConsecutive(Array(100, 4, 200, 1, 3, 2)))
    println(longestConsecutive(Array(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
  }
}
