package com.numbers

import org.scalatest.wordspec.AnyWordSpec

import scala.annotation.tailrec

class NumberProblems {

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(currentDivisor: Int): Boolean = {
      if (currentDivisor > Math.sqrt(Math.abs(n))) true
      else (n % currentDivisor != 0) && isPrimeTailRec(currentDivisor + 1)
    }

    if (n == 0 || n == 1 || n == -1) false
    else isPrimeTailRec(2)
  }

  def decompose(n: Int): List[Int] = {
    assert(n > 0)

    @tailrec
    def decomposeTailRec(remaining: Int, currentDivisor: Int, accumulator: List[Int]): List[Int] = {
      if (currentDivisor > Math.sqrt(n)) remaining :: accumulator
      else if (remaining % currentDivisor == 0) decomposeTailRec(remaining / currentDivisor, currentDivisor, currentDivisor :: accumulator)
      else decomposeTailRec(remaining, currentDivisor + 1, accumulator)
    }

    decomposeTailRec(n, 2, List.empty)
  }
}

object NumberProblems extends App {
  val numberProblems = new NumberProblems

  println(numberProblems.isPrime(11))
  println(numberProblems.decompose(11))
  println(numberProblems.decompose(15))
  println(numberProblems.decompose(8))
}

class NumberProblemsSpec extends AnyWordSpec {

  val numberProblems = new NumberProblems()

  "isPrime method" should {
    "return check if the number is prime" in {
      assert(numberProblems.isPrime(11))
      assert(!numberProblems.isPrime(4))
    }
  }
}
