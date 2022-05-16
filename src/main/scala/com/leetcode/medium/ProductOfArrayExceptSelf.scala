package com.leetcode.medium


object ProductOfArrayExceptSelf {

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val dp1: Array[Int] = Array.fill[Int](nums.length)(1)
    for (i <- 1 to nums.length - 1) {
      dp1.update(i, dp1(i - 1) * nums(i - 1))
    }
//    println(dp1.mkString("Array(", ", ", ")"))

    val dp2: Array[Int] = Array.fill[Int](nums.length)(1)
    for (i <- nums.length - 2 to 0 by -1) {
      dp2.update(i, dp2(i + 1) * nums(i + 1))
    }
//    println(dp2.mkString("Array(", ", ", ")"))

    val result: Array[Int] = Array.fill[Int](dp1.length)(0)
    for (j <- dp1.indices) {
      result.update(j, dp1(j) * dp2(j))
    }
    result
  }

  def productExceptSelfV2(nums: Array[Int]): Array[Int] = {
    val outputArray: Array[Int] = Array.fill[Int](nums.length)(1)

    for (i <- 1 to nums.length - 1) {
      outputArray.update(i, outputArray(i - 1) * nums(i - 1))
    }
    //    println(dp1.mkString("Array(", ", ", ")"))

    var r: Int = 1;
    for (i <- nums.length - 1 to 0 by -1) {
      outputArray.update(i, outputArray(i) * r)
      r = r * nums(i)
    }
    //    println(dp2.mkString("Array(", ", ", ")"))

    outputArray
  }

  def productExceptSelfFp(nums: Array[Int]): Array[Int] = {
     val dp1 = (1 until nums.length).scanLeft(1) { (prevValue, i) =>
        prevValue * nums(i - 1)
      }

     val dp2 = (nums.length - 2 to 0 by -1).scanLeft(1) { (prevValue, i) =>
        prevValue * nums(i + 1)
      }.reverse

    dp1.indices.map(i => dp1(i) * dp2(i)).toArray

  }

  def main(args: Array[String]): Unit = {
    println(productExceptSelf(Array(4, 5, 1, 8, 2)).mkString("Array(", ", ", ")"))
    println(productExceptSelf(Array(1, 2, 3, 4)).mkString("Array(", ", ", ")"))

    println(productExceptSelfFp(Array(4, 5, 1, 8, 2)).mkString("Array(", ", ", ")"))
    println(productExceptSelfFp(Array(1, 2, 3, 4)).mkString("Array(", ", ", ")"))

    println(productExceptSelfV2(Array(4, 5, 1, 8, 2)).mkString("Array(", ", ", ")"))
    println(productExceptSelfV2(Array(1, 2, 3, 4)).mkString("Array(", ", ", ")"))
  }

}
