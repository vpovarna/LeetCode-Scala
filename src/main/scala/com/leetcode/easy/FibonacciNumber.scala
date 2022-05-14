package com.leetcode.easy

object FibonacciNumber {
  def fib(n: Int): Int = {
    if (n == 0) 0
    else if (n == 1) 1
    else {
      (2 to n).foldLeft(0, 1) {
        case ((a, b), _) => (b, a + b)
      }._2
    }
  }

  def main(args: Array[String]): Unit = {
    println(fib(2)) // 1
    println(fib(3)) // 2
    println(fib(4)) // 3
  }
}
