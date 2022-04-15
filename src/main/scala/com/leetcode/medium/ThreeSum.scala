package com.leetcode.medium

import scala.collection.Searching.Found

object ThreeSum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    // helps to remove duplicated values
    val s = nums.sorted

    val result: Seq[List[Int]] = for {
      i <- 0 to s.length - 3 if (i == 0 || s(i - 1) != s(i))
      j <- i + 1 to s.length - 2 if (j == i + 1 || s(j - 1) != s(j))
      k <- findK(s, i, j)
    } yield List(s(i), s(j), s(k))

    result.toList
  }

  def findK(s: Array[Int], i: Int, j: Int): Option[Int] = {
    val sum2: Int = s(i) + s(j)
    s.search(-sum2, j + 1, s.length) match {
      case Found(k) => Some(k)
      case _ => None
    }
  }

  def main(args: Array[String]): Unit = {
    val input = Array(-1, 0, 1, 2, -1, -4)
    println(threeSum(input))
  }

}
