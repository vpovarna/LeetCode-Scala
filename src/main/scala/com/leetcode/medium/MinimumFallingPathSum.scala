package com.leetcode.medium

object MinimumFallingPathSum {
  def minFallingPathSum(matrix: Array[Array[Int]]): Int = {
    val (n, maxValue) = (matrix.size, Int.MaxValue)
    matrix
      .foldRight(Array.fill(n)(0)) { case (row, dp) =>
        (maxValue +: dp :+ maxValue)
          .sliding(3)
          .zip(row)
          .map(x => x._1.min + x._2)
          .toArray
      }
      .min
  }

  def minFallingPathSum2(matrix: Array[Array[Int]]): Int = {
    val r = matrix.length
    val c = matrix(0).length
    val cache = Array.fill(r*c+1)(-1)
    var result = Int.MaxValue

    def getMin(i:Int,j:Int): Int = {
      if(i == r) 0
      else if(j < 0 || j == c) Int.MaxValue
      else if(cache(i*c+j) != -1) cache(i*c+j)
      else {
        val leftBelow = getMin(i+1,j-1)
        val below = getMin(i+1,j)
        val rightBelow = getMin(i+1,j+1)
        val min = leftBelow.min(below).min(rightBelow)
        cache(i*c+j) = min + matrix(i)(j)
        cache(i*c+j)
      }
    }

    for(j <- matrix(0).indices){
      result = result.min(getMin(0,j))
    }
    result

  }

}
