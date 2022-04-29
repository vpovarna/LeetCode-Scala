package com.leetcode.medium

object Permutations {
  def permute(nums: Array[Int]): List[List[Int]] = {
    if (nums.isEmpty) List(List())
    else {
      for {
        x <- nums.toList
        perm <- permute(nums.filter(_ != x))
      } yield x :: perm
    }
  }

  def main(args: Array[String]): Unit = {
    println(permute(Array(1, 2, 3)))
    println(permute(Array(0, 1)))
  }
}
