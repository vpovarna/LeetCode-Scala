package com.leetcode.medium

object MaximumBagsWithFullCapacityOfRocks {
  def maximumBags(capacity: Array[Int], rocks: Array[Int], additionalRocks: Int): Int = {
    capacity
      .indices
      .sortBy(i => capacity(i) - rocks(i))
      .iterator
      .scanLeft(additionalRocks) { case (additionalRocks, i) => additionalRocks - (capacity(i) - rocks(i)) }
      .drop(1)
      .takeWhile(_ >= 0)
      .size
  }

  def main(args: Array[String]): Unit = {
    println(maximumBags(Array(2, 3, 4, 5), Array(1, 2, 4, 4), 2))
  }

}
