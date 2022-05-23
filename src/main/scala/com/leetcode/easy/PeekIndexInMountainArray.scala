package com.leetcode.easy

object PeekIndexInMountainArray {
  // Complexity: O(N) and space complexity O(1)
  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    var tmpMax = Int.MinValue
    for (i <- arr.indices) {
      val currentValue = arr(i)
      if (currentValue < tmpMax) {
        return i - 1
      } else {
        tmpMax = Math.max(tmpMax, arr(i))
      }
    }
    -1
  }

  // FP style
  def peekIndexInMountainArrayFoldLeft(arr: Array[Int]): Int = {
    arr.indices.foldLeft((Int.MinValue, -1)) {
      case ((maxValue, index), i) =>
        if ((arr(i) < maxValue) && (index == -1)) (maxValue, i - 1)
        else if ((arr(i) < maxValue && (index != -1))) (maxValue, index)
        else (math.max(maxValue, arr(i)), index)
    }._2
  }

  // Binary search to find the index of the max element in the array
  // O(log(N)) and space complexity O(1)
  def peekIndexInMountainArrayBS(arr: Array[Int]): Int = {
    // define the two pointers
    var left = 0
    var right = arr.length - 1

    while (left < right) {
      // used to avoid stack overflow
      val midPoint = left + (right -left) / 2

      if (arr(midPoint) < arr(midPoint +1)) {
        left = midPoint + 1
      } else {
        right = midPoint
      }
    }
    left
  }

  def main(args: Array[String]): Unit = {
    println(peakIndexInMountainArray(Array(0, 1, 0))) // 1
    println(peekIndexInMountainArrayFoldLeft(Array(0, 2, 1, 0))) // 1
    println(peekIndexInMountainArrayBS(Array(0, 2, 1, 0))) // 1
  }
}


