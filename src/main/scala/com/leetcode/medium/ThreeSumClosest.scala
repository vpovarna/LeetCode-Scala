package com.leetcode.medium

object ThreeSumClosest {

  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    var result = nums(0) + nums(1) + nums(nums.length - 1)
    val sortedArray = nums.sorted

    for (i <- 0 until sortedArray.length - 2) {
      var pointerA = i + 1
      var pointerB = sortedArray.length - 1

      while (pointerA < pointerB) {
        val currentSum = sortedArray(i) + sortedArray(pointerA) + sortedArray(pointerB)

        if (currentSum > target) {
          pointerB -= 1
        } else {
          pointerA += 1
        }

        if (math.abs(currentSum - target) < math.abs(result -target)) {
          result = currentSum
        }
      }
    }

    result

  }

  def main(args: Array[String]): Unit = {
    println(threeSumClosest(Array(-1, 2, 1, -4), 1))
    println(threeSumClosest(Array(0, 0, 0), 1))
    println(threeSumClosest(Array(1, 1, 1, 0), -100))
  }

}
