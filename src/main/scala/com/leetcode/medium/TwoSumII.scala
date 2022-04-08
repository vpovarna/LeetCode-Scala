package com.leetcode.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.annotation.tailrec

object TwoSumII {

  def solution(numbers: Array[Int], target: Int): Array[Int] = {
    @tailrec
    def twoSumTailRec(remainingNums: Array[Int], indexes: Array[Int], currentIndex: Int = 1, seed: Int = 0): Array[Int] = {
      if (remainingNums.isEmpty) indexes
      else {
        val currentNum = remainingNums.head
        val newTarget = target - currentNum
        val tail = remainingNums.tail
        if (tail.contains(newTarget)) {
          // The index pair will be created from the index of the current value calculated from the initial array
          // and the index of target value from the remaining array + current index
          val index1 = numbers.indexOf(currentNum)
          val index2 = tail.indexOf(newTarget)
          twoSumTailRec(tail, Array(index1 + seed, currentIndex + index2 + seed))
        } else twoSumTailRec(tail, indexes, currentIndex + 1, seed)
      }
    }

    twoSumTailRec(numbers, Array.empty[Int], 1, 1)
  }

}

class TwoSumIISpec extends AnyFlatSpec with Matchers {

  "Two sum II class" should
    "return the indexes of the first two elements for which the sum is equal to the target" in {
    TwoSumII.solution(Array(2, 7, 11, 15), 9) should equal(Array(1, 2))
    TwoSumII.solution(Array(2, 3, 4), 6) should equal(Array(1, 3))
    TwoSumII.solution(Array(-1, 0), -1) should equal(Array(1, 2))
    TwoSumII.solution(Array(0, 0, 3, 4), 0) should equal(Array(1, 2))
    TwoSumII.solution(Array(5,25,75), 100) should equal(Array(2, 3))
  }
}
