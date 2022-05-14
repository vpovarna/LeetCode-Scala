package com.leetcode.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

object HouseRobber {
  // Dynamic programming
  def solution(nums: Array[Int]): Int = {
    if (nums.isEmpty) 0
    else {
      val dp: Array[Int] = new Array[Int](nums.length + 1)
      dp.update(0, 0)
      dp.update(1, nums(0))

      (1 until nums.length).foreach { i =>
        dp.update(i + 1, Math.max(dp(i), dp(i - 1) + nums(i)))
      }
      dp.last
    }
  }
}

class HouseRobberSpec extends AnyFlatSpec with Matchers {

  "House Robber" should
    "return the max sum he can get from non consecutive houses" in {
    HouseRobber.solution(Array(1, 2, 3, 1)) should equal(4)
    HouseRobber.solution(Array(2, 7, 9, 3, 1)) should equal(12)
    HouseRobber.solution(Array(2, 1, 1, 2)) should equal(4)
  }
}
