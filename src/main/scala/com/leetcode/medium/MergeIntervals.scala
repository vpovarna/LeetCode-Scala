package com.leetcode.medium

object MergeIntervals {

  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    val sortedArray = intervals.sortBy(_.head)
    if (sortedArray.length == 1) sortedArray
    else {
      sortedArray.tail.foldLeft(Array[Array[Int]](sortedArray(0))) { (acc, el) =>
        val lastArray: Array[Int] = acc.last
        if (el(0) <= lastArray(1)) {
          val newArray = Array(lastArray(0), math.max(lastArray(1), el(1)))
          acc.dropRight(1) :+ newArray
        } else {
          acc :+ el
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val inputArrayV1 = Array(Array(1, 3), Array(8, 10), Array(15, 18), Array(2, 6))
    val inputArrayV2 = Array(Array(1, 4), Array(4, 5))
    val inputArrayV3 = Array(Array(1, 4), Array(5, 8))
    val inputArrayV4 = Array(Array(1, 4), Array(0, 2), Array(3, 5))

    merge(inputArrayV4).foreach(x => println(x.mkString("Array(", ", ", ")")))
  }
}