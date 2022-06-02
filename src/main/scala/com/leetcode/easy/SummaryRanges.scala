package com.leetcode.easy

import scala.collection.mutable.ArrayBuffer

object SummaryRanges {

  // TODO: replace with foldLeft
  def summaryRanges(nums: Array[Int]): List[String] = {
    if (nums.isEmpty) List[String]()
    else {
      var pointerA = nums.head
      var pointerB = nums.head

      val dp: ArrayBuffer[(Int, Int)] = ArrayBuffer.empty[(Int, Int)]

      for (i <- 1 until nums.length) {
        if (nums(i) > pointerB + 1) {
          dp.addOne((pointerA, pointerB))
          pointerA = nums(i)
          pointerB = nums(i)
        } else {
          pointerB = nums(i)
        }
      }
      dp.addOne((pointerA, pointerB))

      dp.foldRight(List[String]())((t, list) =>
        if (t._1 == t._2) t._1.toString +: list
        else s"${t._1}->${t._2}" +: list
      )
    }
  }

  def main(args: Array[String]): Unit = {
    println(summaryRanges(Array(0, 1, 2, 4, 5, 7)))
    println(summaryRanges(Array(0, 2, 3, 4, 6, 8, 9)))
  }

}
