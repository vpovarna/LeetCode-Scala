package com.leetcode.easy

object IntersectionTwoArrays {

  // using hashSet
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    if (nums1.length < nums2.length) getCommonElements(nums1, nums2)
    else getCommonElements(nums2, nums1)
  }

  def getCommonElements(numsA: Array[Int], numsB: Array[Int]): Array[Int] = {
    numsA.foldLeft(collection.mutable.HashSet.empty[Int]) { (set, num) =>
      if (numsB.contains(num)) set.addOne(num)
      else set
    }.toArray
  }

  // scala way
  def intersectV1(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    nums1 intersect nums2
  }

  def main(args: Array[String]): Unit = {
    println(intersection(Array(1, 2, 2, 1), Array(2, 2)).mkString("Array(", ", ", ")"))
    println(intersection(Array(4,9,5), Array(9,4,9,8,4)).mkString("Array(", ", ", ")"))
    println(intersection(Array(2,6,2,9,1), Array(1,7)).mkString("Array(", ", ", ")"))
  }
}
