package com.leetcode.easy

object ReplaceElementsWithGreatestElementOnRightSide {

  def returnMaxElement(inputArr: Array[Int]): Int = {
    if (inputArr.length <= 1) -1
    else inputArr.splitAt(1)._2.max
  }

  // O(N2) time complexity
  def replaceElements_v3(arr: Array[Int]): Array[Int] = {
    val inputArrayLength = arr.length
    (0 until inputArrayLength).foldLeft(Array.empty[Int]) { (acc, x) =>
      val sliceArray = arr.slice(x, inputArrayLength)
      val maxElement = returnMaxElement(sliceArray)
      acc :+ maxElement
    }
  }

  // Using for loop
  def replaceElements_v2(arr: Array[Int]): Array[Int] = {
    val resultArr = Array.fill[Int](arr.length)(0)
    // initialize the last element of the array with -1
    resultArr(arr.length - 1) = -1

    for (i <- arr.length - 1 to 1 by -1) {
      resultArr(i - 1) = Math.max(resultArr(i), arr(i))
    }
    resultArr
  }

  // Using fold left
  def replaceElements_v1(arr: Array[Int]): Array[Int] = {
    val resultArr = Array.fill[Int](arr.length)(0)
    resultArr(arr.length - 1) = -1

    (arr.length - 1 to 1 by -1).foldLeft(resultArr) { (resultArr, i) =>
      resultArr(i - 1) = Math.max(resultArr(i), arr(i))
      resultArr
    }
  }

  // Using scanLeft
  def replaceElements_v4(arr: Array[Int]): Array[Int] = {
    (arr.length - 1 to 1 by -1).scanLeft(-1) { (a, i) =>
      Math.max(a, arr(i))
    }.reverse.toArray
  }

  // Using scanRight -> fastest solution
  def replaceElements(arr: Array[Int]): Array[Int] = {
    arr.tail.scanRight(-1)((i, a) => Math.max(a, i))
  }


  def main(args: Array[String]): Unit = {
    val inputArr_v1 = Array[Int](17, 18, 5, 4, 6, 1)
    val inputArr_v2 = Array[Int](400)

    println(replaceElements(inputArr_v1).mkString(","))
    println(replaceElements(inputArr_v2).mkString(","))

    println(replaceElements_v1(inputArr_v1).mkString(","))
    println(replaceElements_v1(inputArr_v2).mkString(","))

    println(replaceElements_v2(inputArr_v1).mkString(","))
    println(replaceElements_v2(inputArr_v2).mkString(","))

    println(replaceElements_v3(inputArr_v1).mkString(","))
    println(replaceElements_v3(inputArr_v2).mkString(","))

    println(replaceElements_v4(inputArr_v1).mkString(","))
    println(replaceElements_v4(inputArr_v2).mkString(","))

  }
}
