package com.leetcode.easy

import scala.annotation.tailrec
import scala.util.control.Breaks.{break, breakable}

object TwoSum extends App {

  /**
   * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
   * You may assume that each input would have exactly one solution, and you may not use the same element twice.
   * Input: nums = [2,7,11,15], target = 9
   * Output: [0,1]
   */

  val array = Array[Int](3, 2, 4)
  val target: Int = 6

  val secondArray = Array[Int](-1, -2, -3, -4, -5)
  val secondTarget = -8

  println(twoSumSecondImpl(array, target).mkString("[", ", ", "]"))

  // First Solution
  def twoSumFirstImpl(nums: Array[Int], target: Int): Array[Int] = {
    var response = Array.emptyIntArray
    val valueIndexMap: Map[Int, Int] = nums.zipWithIndex.toMap

    breakable {
      for (i <- nums) {
        val searchVal = target - i
        val possibleIndex: Option[Int] = valueIndexMap.get(searchVal)
        possibleIndex match {
          case Some(value) =>
            val iIndex = nums.indexOf(i)
            if (iIndex != value) {
              response = Array[Int](iIndex, value)
              break
            }
          case None => println("the value is not in the map")
        }
      }
    }
    response
  }


  //  Second solution using TailRec
  def twoSumSecondImpl(nums: Array[Int], target: Int): Array[Int] =
    recursiveTwoSum(nums.zipWithIndex, target)

  @tailrec
  def recursiveTwoSum(numsIndex: Array[(Int, Int)], target: Int): Array[Int] = {
    val expected = target - numsIndex.head._1
    val valueIndexMap: Map[Int, Int] = numsIndex.tail.toMap

    val response = valueIndexMap.get(expected) match {
      case Some(value) => Array(numsIndex.head._2, value)
      case None => Array.emptyIntArray
    }

    if (response.length > 0) response
    else recursiveTwoSum(numsIndex.tail, target)
  }

  // Third solution
  def twoSumThirdImpl(nums: Array[Int], target: Int): Array[Int] = {
    recursiveTwoSum(nums, target, 0)
  }

  @tailrec
  def recursiveTwoSum(numsIndex: Array[Int], target: Int, index: Int): Array[Int] = {
    val expected = target - numsIndex.head
    val valueIndexMap: Map[Int, Int] = numsIndex.tail.zipWithIndex.toMap

    val response = valueIndexMap.get(expected) match {
      case Some(value) => Array(index, value + index + 1)
      case None => Array.emptyIntArray
    }

    if (response.length > 0) response
    else recursiveTwoSum(numsIndex.tail, target, index + 1)
  }
}
