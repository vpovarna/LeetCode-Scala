package com.leetcode.easy

object TransposeMatrix {

  def transpose(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val (m, n) = (matrix.length, matrix.head.length)
    Array.tabulate(n)(r => Array.tabulate(m)(c => matrix(c)(r)))
  }


  def main(args: Array[String]): Unit = {
    val matrix: Array[Array[Int]] = Array(Array(2, 4, -1), Array(-10,5, 11), Array(18, -7, 6))
    Array.tabulate(2)(r => Array.tabulate(2)(c => matrix(c)(r))).foreach(x => println(x.mkString("Array(", ", ", ")")))
  }
}
