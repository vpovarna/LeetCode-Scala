package com.leetcode.medium

object SubsetII {

  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    nums.foldLeft(List(List[Int]())) { (acc, num) =>
      val tmpList: List[List[Int]] = acc.map(_ :+ num).map(_.sorted)
      val filteredTmpList = tmpList.filter(lst => !acc.contains(lst))
      acc ++ filteredTmpList
    }
  }

  def main(args: Array[String]): Unit = {
    println(subsetsWithDup(Array(1,2,2)))
  }

}
