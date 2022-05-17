package com.leetcode.medium

object Subset {

  def subsets(nums: Array[Int]): List[List[Int]] = {
      nums.foldLeft(List(List[Int]())) { (acc: List[List[Int]], num: Int) =>
        val tmpList: List[List[Int]] = acc.map(_ :+ num)
        acc ++ tmpList
      }
  }

  def main(args: Array[String]): Unit = {
    println(subsets(Array(1, 2, 3)))
  }

}
