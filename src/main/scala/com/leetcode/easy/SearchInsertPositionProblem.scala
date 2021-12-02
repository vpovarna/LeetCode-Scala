package com.leetcode.easy

import org.scalatest.wordspec.AnyWordSpec

import scala.annotation.tailrec

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */
class SearchInsertPositionProblem {

  def searchInsert(nums: Array[Int], target: Int): Int = {

    @tailrec
    def searchInsertTailRec(remainingNums: Array[Int], currentIndex: Int, index: Int): Int = {
      if (remainingNums.isEmpty) index
      else if (remainingNums.head == target) index
      else if (remainingNums.head > target) currentIndex
      else if (remainingNums.head < target && remainingNums.tail.isEmpty) currentIndex + 1
      else searchInsertTailRec(remainingNums.tail, currentIndex + 1, index + 1)
    }

    searchInsertTailRec(nums, 0, 0)
  }

}

class SearchInsertPositionProblemSpec extends AnyWordSpec {
  val problem = new SearchInsertPositionProblem

  "SearchInsert method" should {
    "return the index of an array element" in {
      assert(problem.searchInsert(Array[Int](1), 0) == 0)
      assert(problem.searchInsert(Array[Int](1, 3, 5, 6), 2) == 1)
      assert(problem.searchInsert(Array[Int](1, 3, 5, 6), 7) == 4)
      assert(problem.searchInsert(Array[Int](1, 3, 5, 6), 0) == 0)
      assert(problem.searchInsert(Array[Int](1, 3, 5, 6), 5) == 2)
    }
  }
}
