package com.leetcode.medium

object JumpGame {

  // greedy solution
  def canJumpGreedy(nums: Array[Int]): Boolean = {
    var goalPosition = nums.length - 1
    var solution: Boolean = false

    for (i <- nums.length - 1 to 0 by -1) {
      if (nums(i) + i >= goalPosition) {
        goalPosition = i
        solution = true
      } else {
        solution = false
      }
    }
    solution
  }


  def canJump(nums: Array[Int]): Boolean = {
    nums.zipWithIndex.reverse.foldLeft(nums.length - 1) {
      case (lastGoodIndex, (jumps, index)) =>
        println(s"lastGoodIndex = $lastGoodIndex ; jumps = $jumps ; index = $index")
        if (jumps + index >= lastGoodIndex) index else lastGoodIndex
    } == 0
  }

  def main(args: Array[String]): Unit = {
    println(JumpGame.canJumpGreedy(Array(3, 2, 1, 0, 4)))
    println(JumpGame.canJumpGreedy(Array(2, 3, 1, 1, 4)))
    println(JumpGame.canJumpGreedy(Array(0)))
  }

}
