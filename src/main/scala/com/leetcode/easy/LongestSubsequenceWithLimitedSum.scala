package com.leetcode.easy

import scala.collection.Searching.{Found, InsertionPoint}

object LongestSubsequenceWithLimitedSum {
  def answerQueries(nums: Array[Int], queries: Array[Int]): Array[Int] = {
    val prefixSum = nums.sorted.scanLeft(0)(_ + _)
    queries.map(q => prefixSum.tail.search(q) match {
      case Found(i) => i + 1
      case InsertionPoint(i) => i
    })
  }

  def main(args: Array[String]): Unit = {
    println(answerQueries(Array(4, 5, 2, 1), Array(3, 10, 21)).mkString("Array(", ", ", ")"))
  }
}
