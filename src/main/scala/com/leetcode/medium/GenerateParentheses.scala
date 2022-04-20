package com.leetcode.medium

object GenerateParentheses {

  def generateParenthesis(n: Int): List[String] = {
    n match {
      case 0 => List("")
      case n =>
        for {
          m <- (0 until n).toList
          x <- generateParenthesis(m)
          y <- generateParenthesis(n - 1 - m)
        } yield s"($x)$y"
    }
  }
  
  def main(args: Array[String]): Unit = {
    println(generateParenthesis(3))
  }

}
