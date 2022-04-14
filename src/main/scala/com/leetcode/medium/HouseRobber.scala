package com.leetcode.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

object HouseRobber {

  def solution(nums: Array[Int]): Int = {
    nums.foldLeft(0, 0) { (r, n) =>
      val newMax = (r._1 + n) max r._2
      (r._2, newMax)
    }._2
  }

}

class HouseRobberSpec extends AnyFlatSpec with Matchers {

  "House Robber" should
    "return the max sum he can get from non consecutive houses" in {
    HouseRobber.solution(Array(1, 2, 3, 1)) should equal(4)
    HouseRobber.solution(Array(2, 7, 9, 3, 1)) should equal(12)
    HouseRobber.solution(Array(2, 1, 1, 2)) should equal(4) // Not works
  }
}
