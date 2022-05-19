package com.leetcode.hard


object FirstMissingPositive {

  def firstMissingPositiveRec(nums: Array[Int]): Int = {
    val numsSet: Set[Int] = nums.toSet
    val maxValue = nums.length + 1

    @scala.annotation.tailrec
    def firstMissingPositiveTailRec(currentVal: Int = 1, solution: Int = maxValue): Int = {
      if (currentVal >= maxValue) maxValue
      else if (solution != maxValue) solution
      else {
        if (!numsSet.contains(currentVal)) firstMissingPositiveTailRec(currentVal, currentVal)
        else firstMissingPositiveTailRec(currentVal + 1, solution)
      }
    }

    firstMissingPositiveTailRec()
  }


  def firstMissingPositive(nums: Array[Int]): Int = {
    val numsSet: Set[Int] = nums.toSet

    for (i <- 1 to nums.length + 1) {
      if (!numsSet.contains(i)) {
        return i
      }
    }
    // returning nums.length + 1 because the array can have elements starting from 1
    nums.length + 1
  }

  def main(args: Array[String]): Unit = {
    println(firstMissingPositiveRec(Array(1,2,0)))
    println(firstMissingPositiveRec(Array(3,4,-1,1)))
    println(firstMissingPositiveRec(Array(7,8,9,11,12)))
  }


}
