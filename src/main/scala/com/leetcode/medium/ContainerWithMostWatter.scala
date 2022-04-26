package com.leetcode.medium

object ContainerWithMostWatter {

  // BruteForce Solution
  def maxAreaBF(height: Array[Int]): Int = {
    var solution = 0

    for (i <- height.indices) {
      for (j <- i + 1 until height.length) {
        val tmpSolution = Math.min(height(i), height(j)) * (j - i)
        solution = Math.max(solution, tmpSolution)
      }
    }

    solution
  }

  def maxArea(height: Array[Int]): Int = {
    var pointerA = 0
    var pointerB = height.length - 1
    var result = 0

    while (pointerA < pointerB) {
      if (height(pointerA) < height(pointerB)) {
        val tmpResult = height(pointerA) * (pointerB - pointerA)
        result = scala.math.max(result, tmpResult)
        pointerA += 1
      } else {
        val tmpResult = height(pointerB) * (pointerB - pointerA)
        result = scala.math.max(result, tmpResult)
        pointerB -= 1
      }
    }
    result
  }

  def maxAreaV2(height: Array[Int]): Int = {
    @scala.annotation.tailrec
    def maxAreaTailRec(pointerA: Int, pointerB: Int, result: Int): Int = {
      if (pointerA >= pointerB) result
      else {
        if (height(pointerA) < height(pointerB)) {
          val tmpResult = height(pointerA) * (pointerB - pointerA)
          maxAreaTailRec(pointerA + 1, pointerB, scala.math.max(result, tmpResult))
        } else {
          val tmpResult = height(pointerB) * (pointerB - pointerA)
          maxAreaTailRec(pointerA, pointerB - 1, scala.math.max(result, tmpResult))
        }
      }
    }

    maxAreaTailRec(0, height.length -1, 0)
  }


  def main(args: Array[String]): Unit = {
    println(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxArea(Array(1, 1)))
    println(maxAreaV2(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxAreaV2(Array(1, 1)))
  }

}
