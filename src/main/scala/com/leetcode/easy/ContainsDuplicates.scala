package com.leetcode.easy

object ContainsDuplicates {

  def containsDuplicate(nums: Array[Int]): Boolean = {
    var isPresent = false
    nums.foldLeft(Set[Int]())((tmpSet, num) =>
      if (tmpSet.contains(num)) {
        isPresent = true
        tmpSet
      } else {
        tmpSet + num
      })
    isPresent
  }

  def main(args: Array[String]): Unit = {
    println(containsDuplicate(Array(1, 2, 3, 1)))
    println(containsDuplicate(Array(1, 2, 3, 4)))
    println(containsDuplicate(Array(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
    println(containsDuplicate(Array(0, 4, 5, 0, 3, 6)))
  }

}
