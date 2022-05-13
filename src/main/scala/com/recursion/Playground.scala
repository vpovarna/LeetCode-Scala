package com.recursion

object Playground {

  // Factorial
  def factorialRecursive(n: Int): Int = {
    if (n == 1) 1
    else n * factorialRecursive(n - 1)
  }

  // Fibonacci
  def fibonacci(n: Int): Int = {
    if (n < 2) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  // Reverse word
  def reverseStr(s: String): String = {
    if (s.isEmpty) ""
    else reverseStr(s.tail) + s.head
  }

  // Fibonacci with Memoization
  def fibMemo(n: Int): Int = {
    var cache: Map[Int, Int] = Map.empty[Int, Int]

    def fibonacci(n: Int): Int = {
      if (cache.contains(n)) {
        cache(n)
      } else {
        if (n < 2) n
        else {
          cache = cache.updated(n, fibonacci(n - 1) + fibonacci(n - 2))
          cache(n)
        }
      }
    }

    fibonacci(n)
  }


  def main(args: Array[String]): Unit = {
    println(factorialRecursive(5))
    println(fibonacci(8))
    println(fibMemo(8))
    println(reverseStr("training"))
  }

}
