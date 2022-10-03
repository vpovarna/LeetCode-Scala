package com.leetcode.easy

object ReplaceElementsWithGreatestElementOnRightSide {

  def returnMaxElement(inputArr: Array[Int]): Int = {
    if (inputArr.length <= 1) -1
    else inputArr.splitAt(1)._2.max
  }

  def replaceElements(arr: Array[Int]): Array[Int] = {
    val inputArrayLength = arr.length
    (0 until inputArrayLength).foldLeft(Array.empty[Int]) { (acc, x) =>
      val sliceArray = arr.slice(x, inputArrayLength)
      val maxElement = returnMaxElement(sliceArray)
      acc :+ maxElement
    }
  }

  def main(args: Array[String]): Unit = {
    val inputArr_v1 = Array[Int](17, 18, 5, 4, 6, 1)
    val inputArr_v2 = Array[Int](400)

    println(replaceElements(inputArr_v1).mkString(","))
    println(replaceElements(inputArr_v2).mkString(","))
  }
}
