package com.leetcode.easy

object MostFrequentEvenElement {

  def mostFrequentEven(nums: Array[Int]): Int = {
    val numsOccurrence: Map[Int, Int] = generateNumsOccurrence(nums)

    val someValue = numsOccurrence.toSeq
      .sortBy(a => (-a._2, a._1))
      .headOption

    someValue match {
      case None             => -1
      case Some((value, _)) => value
    }

  }

  def generateNumsOccurrence(nums: Array[Int]): Map[Int, Int] =
    nums
      .filter(_ % 2 == 0)
      .groupBy(identity)
      .view
      .mapValues(_.length)
      .toMap

  def main(args: Array[String]): Unit = {
    println(mostFrequentEven(Array(0, 1, 2, 2, 4, 4, 1))) // should return 2
    println(mostFrequentEven(Array(4, 4, 4, 9, 2, 4))) // should return 4
    println(
      mostFrequentEven(Array(29, 47, 21, 41, 13, 37, 25, 7))
    ) // should return -1

  }
}
