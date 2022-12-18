package com.leetcode.medium

object DailyTemperatures {

  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
    val m = temperatures.length
    val ans = Array.fill(m)(0)

    val stack = scala.collection.mutable.Stack.empty[Int]

    for (i <- 0 until  m) {
      while (stack.nonEmpty && temperatures(stack.top) < temperatures(i)) {
        ans(stack.top) = i - stack.pop()
      }
      stack.push(i)
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    println(dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73)).mkString("Array(", ", ", ")"))
  }

}
