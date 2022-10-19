package com.leetcode.medium

object TopKFrequentElements {

  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {

    nums.groupBy(identity)
      .view
      .mapValues(_.length)
      .toSeq
      .sortBy(a => -a._2)
      .take(k)
      .map(_._1)
      .toArray

  }

  def main(args: Array[String]): Unit = {
    println(topKFrequent(Array(1, 1, 1, 2, 2, 3), 2).mkString("Array(", ", ", ")"))
    println(topKFrequent(Array(1), 1).mkString("Array(", ", ", ")"))
  }
}
