package com.leetcode.easy

object IntersectionOfMultipleArrays {
  def intersection(nums: Array[Array[Int]]): List[Int] = {
    val fistArray = nums.head
    val remainingArrays = nums.tail

    fistArray.indices.foldLeft(List.empty[Int]) { (acc, i) =>
      if (remainingArrays.forall(_.contains(fistArray(i)))) acc :+ fistArray(i)
      else acc
    }.sorted
  }

  // scala solution using reduce and intersect
  def intersection_v2(nums: Array[Array[Int]]): List[Int] =
    nums.reduce(_ intersect _).sorted.toList

  def main(args: Array[String]): Unit = {
    println(intersection(Array(Array(3, 1, 2, 4, 5), Array(1, 2, 3, 4), Array(3, 4, 5, 6))))
    println(intersection(Array(Array(7, 34, 45, 10, 12, 27, 13), Array(27, 21, 45, 10, 12, 13))))
  }

}
