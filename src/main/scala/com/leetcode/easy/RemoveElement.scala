package com.leetcode.easy

object RemoveElement {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var pointerA = 0
    var pointerB = nums.length

    while (pointerA < pointerB) {
      if (nums(pointerA) == `val`) {
        nums(pointerA) = nums(pointerB - 1)
        pointerB -= 1
      } else pointerA += 1
    }
    pointerB
  }

  def main(args: Array[String]): Unit = {
    println(removeElement(Array(3, 2, 2, 3), 3))
    println(removeElement(Array(0, 1, 2, 2, 3, 0, 4, 2), 2))
    println(removeElement(Array(1), 1))
    println(removeElement(Array(3, 3), 3))
  }
}
