package com.leetcode.easy

import scala.annotation.tailrec

/**
 * @author Adobe Systems Incorporated.
 */
object ClimbingStairs extends App {

  def climbStairs(n: Int): Int = {
    if (n == 1) 1
    else if (n == 2) 2
    else {
      calculateResultRecursion(n, 1, 2, 3)
    }
  }

  @tailrec
  def calculateResultRecursion(n: Int, first: Int, second: Int, result: Int): Int = {
    if (n < 3) result
    else {
      val newResult = first + second
      calculateResultRecursion(n - 1, second, newResult, newResult)
    }
  }

  println(climbStairs(2))
  println(climbStairs(4))
  println(climbStairs(5))

}
