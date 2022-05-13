package com.leetcode.easy

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object IntersectionTwoArraysII {

  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    var nums1Map: Map[Int, Int] = buildHashMap(nums1)
    val result = ArrayBuffer.empty[Int]

    nums2.foreach { num =>
      if (nums1Map.contains(num) && nums1Map(num) != 0) {
        result.addOne(num)
        nums1Map = nums1Map.updated(num, nums1Map(num) - 1)
      }
    }
    result.toArray
  }


  // Tail Rec
  def intersectRec(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val nums1Map: Map[Int, Int] = buildHashMap(nums1)
    intersectTailRec(nums2, nums1Map)
  }

  @tailrec
  def intersectTailRec(nums: Array[Int], nums1Map: Map[Int, Int], result: Array[Int] = Array.empty[Int]): Array[Int] = {
    if (nums.isEmpty) result
    else {
      val head = nums.head
      if (nums1Map.contains(head) && nums1Map(head) != 0) intersectTailRec(nums.tail, nums1Map.updated(head, nums1Map(head) - 1), head +: result)
      else intersectTailRec(nums.tail, nums1Map - head, result)
    }
  }

  def buildHashMap(nums: Array[Int]): Map[Int, Int] = {
    nums.groupBy(identity).view.mapValues(_.length).toMap
  }

  def main(args: Array[String]): Unit = {
    println(intersectRec(Array(1, 2, 2, 1), Array(2, 2)).mkString("Array(", ", ", ")"))
    println(intersectRec(Array(4, 9, 5), Array(9, 4, 9, 8, 4)).mkString("Array(", ", ", ")"))
    println(intersectRec(Array(1, 2, 2, 1), Array(2)).mkString("Array(", ", ", ")"))
  }

}
