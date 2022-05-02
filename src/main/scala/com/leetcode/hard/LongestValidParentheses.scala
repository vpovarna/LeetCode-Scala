package com.leetcode.hard

object LongestValidParentheses {

  def longestValidParentheses(s: String): Int = {
    val stack = scala.collection.mutable.Stack[Int](-1)
    var solution = 0

    for (i <- s.indices) {
      if (s(i) == '(') {
        stack.push(i)
      } else {
        stack.pop()
        if (stack.isEmpty) {
          stack.push(i)
        } else {
          solution = math.max(solution, i - stack.top)
        }
      }
    }
    solution
  }


  def main(args: Array[String]): Unit = {
    println(longestValidParentheses("(())"))
    println(longestValidParentheses("()((()"))
    println(longestValidParentheses("(()"))
    println(longestValidParentheses(")()())"))
    println(longestValidParentheses(""))
    println(longestValidParentheses("()(())"))
  }

}
