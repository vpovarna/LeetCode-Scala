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
}

object NumberProblems extends App {
  val numberProblems = new NumberProblems
  println(numberProblems.isPrime(11))
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
