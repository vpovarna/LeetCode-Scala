package com.recursion

object Playground {

  // Factorial
  def factorialRecursive(n: Int): Int = {
    if (n == 1) 1
    else n * factorialRecursive(n - 1)
  }

  // Fibonacci
  def fibonacci(n: Int):Int = {
    if (n < 2) n
    else fibonacci(n -1) + fibonacci(n-2)
  }

  // reverse word
  def reverseStr(s: String): String = {
    if (s.isEmpty) ""
    else reverseStr(s.tail) + s.head
  }

  def main(args: Array[String]): Unit = {
    println(factorialRecursive(5))
    println(fibonacci(8))
    println(reverseStr("training"))
  }

}
