package com.leetcode.medium

object CombinationSum {

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val result = collection.mutable.ListBuffer[List[Int]]()

    def combinationRec(start: Int, remain: Int, combination: List[Int]): Unit = {
      if (remain == 0) result += combination
      else if (remain > 0) {
        for (i <- start until candidates.length) {
          combinationRec(i, remain - candidates(i), candidates(i) :: combination)
        }
      }
    }

    combinationRec(0, target, List())
    result.toList
  }

  def main(args: Array[String]): Unit = {
    println(combinationSum(Array(2, 3, 6, 7), 7))
  }
}
