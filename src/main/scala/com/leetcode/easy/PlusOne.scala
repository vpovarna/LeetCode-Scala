package com.leetcode.easy

import scala.collection.mutable.ArrayBuffer

object PlusOne {
  def plusOne(digits: Array[Int]): Array[Int] = {
    (BigInt(digits.mkString) + 1).toString.map(_.asDigit).toArray
  }

  def main(args: Array[String]): Unit = {
    println(plusOne(Array(9,8,7,6,5,4,3,2,1,0)).mkString("Array(", ", ", ")"))
    println(plusOne(Array(7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6)).mkString("Array(", ", ", ")"))
    println(plusOne(Array(1, 2, 3)).mkString("Array(", ", ", ")"))
    println(plusOne(Array(9)).mkString("Array(", ", ", ")"))
    println(plusOne(Array(9, 9)).mkString("Array(", ", ", ")"))
  }
}
