package com.leetcode.easy

object ClimbingStairs {

  // TopDown
  def climbStairs(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else {
      val t = (n - 2 to 0 by -1).foldLeft(1, 1) { case ((a, b), _) =>
        (a + b, a)
      }
      t._1
    }
  }

  // BottomUp
  def climbingStairsBottomUp(n: Int): Int ={
    if (n <= 0) 0
    else {
      (1 to n).foldLeft(0, 1) { case((a, b), _) =>
        (b, a+b)
      }._2
    }
  }

  def main(args: Array[String]): Unit = {
    println(climbingStairsBottomUp(1)) //1
    println(climbingStairsBottomUp(2)) //2
    println(climbingStairsBottomUp(3)) //3
    println(climbingStairsBottomUp(5)) //8
  }
}
