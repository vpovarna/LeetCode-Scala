package com.leetcode.medium

object MajorityElements {

  def majorityElement(nums: Array[Int]): List[Int] = {
    val map = buildNumsMap(nums)
    map.filter(kv => kv._2 > nums.length / 3).keys.toList
  }

  private def buildNumsMap(nums: Array[Int]): Map[Int, Int] = {
    nums.foldLeft(Map[Int, Int]()) { (map, num) =>
      map + (num -> (map.getOrElse(num, 0) + 1))
    }
  }

  def main(args: Array[String]): Unit = {
    println(majorityElement(Array(3, 2, 3, 2, 2)))
    println(majorityElement(Array(1)))
    println(majorityElement(Array(1, 2)))
    println(majorityElement(Array(2, 2)))
  }

}
