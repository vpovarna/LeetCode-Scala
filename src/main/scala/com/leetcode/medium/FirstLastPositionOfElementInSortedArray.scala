package com.leetcode.medium

object FirstLastPositionOfElementInSortedArray {

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val i = getTargetIndex(nums, target)
    if (i == -1) Array(-1, -1)
    else {
      var pointerA = i
      var pointerB = i
      var t = (i, i)

      while ((pointerA >= 0 && nums(pointerA) == target) || ( pointerB <= nums.length - 1 && nums(pointerB) == target)) {
        if (pointerA >= 0 && nums(pointerA) == target) {
          t = (pointerA, t._2)
          pointerA -= 1
        }
        if (pointerB <= nums.length - 1 && nums(pointerB) == target) {
          t = (t._1, pointerB)
          pointerB += 1
        }
      }
      Array(t._1, t._2)
    }
  }

  def getTargetIndex(nums: Array[Int], target: Int): Int = {
    var l = 0
    var r = nums.length - 1
    var result = -1

      while (l <= r) {
        val m = (l + r) / 2
        if (target == nums(m)) {
          result = m
        }

        if (target < nums(m)) r = m - 1 else l = m + 1
      }
    result
  }

  def main(args: Array[String]): Unit = {
    println(searchRange(Array(5, 7, 7, 8, 8, 10), 8).mkString("Array(", ", ", ")"))
    println(searchRange(Array(5, 7, 7, 8, 8, 10), 6).mkString("Array(", ", ", ")"))
    println(searchRange(Array(1,2,3,3,3,3,4,5,9), 3).mkString("Array(", ", ", ")"))
    println(searchRange(Array(1), 1).mkString("Array(", ", ", ")"))
    println(searchRange(Array(2, 2), 2).mkString("Array(", ", ", ")"))
  }

}
