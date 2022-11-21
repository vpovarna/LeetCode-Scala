package com.leetcode.hard

object BasicCalculator {
  def calculate(s: String): Int = {
    var i = 0
    var sum = 0
    var sign = 1

    // This stack will hold the tmp sum calculated until that point and the sign of the operation
    val stack = scala.collection.mutable.Stack.empty[Int]

    while (i < s.length) {
      val c: Char = s.charAt(i)
      if (c.isDigit) {
        var v = 0
        while (i < s.length && s(i).isDigit) {
          v =
            v * 10 + (s.charAt(
              i
            ) - 48) /* in scala 0 char is represented as 48 */
          i += 1
        }
        i -= 1
        sum += v * sign
        sign = 1
      } else if (c == '-') /* negative operation */ {
        sign = sign * (-1)
      } else if (c == '(') {
        stack.append(sum)
        stack.append(sign)
        // reset the sum; the value is on the stack
        sum = 0
        sign = 1
      } else if (c == ')') {
        sum *= stack.removeLast()
        sum += stack.removeLast()
      }
      i += 1
    }

    sum
  }

  def main(args: Array[String]): Unit = {
    println(calculate("1+10+8")) // 19
    println(calculate("1+10-8")) // 3
    println(calculate("5+(1+10-8)")) // 8

  }

}
