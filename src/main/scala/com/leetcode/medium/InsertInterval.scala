package com.leetcode.medium

object InsertInterval {
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    val (acc, last) = intervals.foldLeft((Array.empty[Array[Int]], newInterval)) {
      case ((rest, newInterval), head) =>
        if (newInterval.last < head.head) {
          (rest :+ newInterval, head)
        } else if (newInterval.head > head.last) {
          (rest :+ head, newInterval)
        } else {
          (rest, Array(Math.min(head.head, newInterval.head), Math.max(head.last, newInterval.last)))
        }
    }
    acc :+ last
  }


  def main(args: Array[String]): Unit = {
    InsertInterval.insert(Array(Array(2, 3), Array(6, 9)), Array(0, 1)).foreach(x => println(x.mkString("Array(", ", ", ")")))
    InsertInterval.insert(Array(Array(1, 3), Array(6, 9)), Array(2, 5)).foreach(x => println(x.mkString("Array(", ", ", ")")))
    InsertInterval.insert(Array(Array(1, 5)), Array(2, 7)).foreach(x => println(x.mkString("Array(", ", ", ")")))
  }

}
