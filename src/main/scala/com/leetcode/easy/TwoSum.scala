package com.leetcode.easy

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.annotation.tailrec

object TwoSum {

  /**
   * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
   * You may assume that each input would have exactly one solution, and you may not use the same element twice.
   * Input: nums = [2,7,11,15], target = 9
   * Output: [0,1]
   */

  def getTargetIndexes(nums: Array[Int], target: Int): Array[Int] = {
    // using contains => which add search
    @tailrec
    def twoSumTailRec(remainingNums: Array[Int], indexes: Array[Int], currentIndex: Int = 1): Array[Int] = {
      if (remainingNums.isEmpty) indexes
      else {
        val currentNum = remainingNums.head
        val newTarget = target - currentNum
        val tail = remainingNums.tail
        if (tail.contains(newTarget)) {
          // The index pair will be created from the index of the current value calculated from the initial array
          // and the index of target value from the remaining array + current index
          twoSumTailRec(tail, Array(nums.indexOf(currentNum), currentIndex + tail.indexOf(newTarget)))
        } else twoSumTailRec(tail, indexes, currentIndex + 1)
      }
    }

    twoSumTailRec(nums, Array.empty[Int])
  }

}

class TwoSumSpec extends AnyFlatSpec with Matchers {
  "TwoSum should " should
    "return indexes for which the sum of the numbers is equal with the targetValue" in {
    TwoSum.getTargetIndexes(Array(2, 7, 11, 15), 9) should equal(Array(0, 1))
    TwoSum.getTargetIndexes(Array(3, 2, 4), 6) should equal(Array(1, 2))
    TwoSum.getTargetIndexes(Array(3, 3), 6) should equal(Array(0, 1))
  }
}