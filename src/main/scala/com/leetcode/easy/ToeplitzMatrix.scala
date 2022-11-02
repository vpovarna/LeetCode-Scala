package com.leetcode.easy

object ToeplitzMatrix {

  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    matrix.indices.tail.forall{r =>
      matrix(r).indices.tail.forall { c =>
        matrix(r)(c) == matrix(r-1)(c-1)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val inputArray = Array(Array(1,2,3,4), Array(5,1,2,3), Array(9,5,1,2))
    println(inputArray.map(_.toList).toList)
    println(isToeplitzMatrix(inputArray))
  }

}
