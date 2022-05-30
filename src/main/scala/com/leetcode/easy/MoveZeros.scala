package com.leetcode.easy

object MoveZeros {
  def moveZeroes(nums: Array[Int]): Unit = {
    var (i, j) = (0, 0)

    while (j < nums.length) {
      if (nums(j) == 0) {
        j += 1
      } else {
        nums(i) = nums(j)
        i += 1
        j += 1
      }
      // println(s"$i - $j")
      // println(nums.mkString("Array(", ", ", ")"))
    }

    while (i < nums.length) {
      nums(i) = 0
      i += 1
    }
  }

  def moveZeroesFp(nums: Array[Int]): Unit = {
    val count = nums.indices.foldLeft(0) {
      case (i, j) =>
        if (nums(j) != 0) {
          nums(i) = nums(j)
          i + 1
        } else i
    }

    (count until nums.length).foreach(i => nums(i) = 0)
  }

  def main(args: Array[String]): Unit = {
    moveZeroesFp(Array(0, 1, 0, 3, 12))
  }

}
