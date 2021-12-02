package com.strings

import org.scalatest.wordspec.AnyWordSpec

import scala.annotation.tailrec

class CompareVersionNumbersProblem {

  def compareVersionNumbers(versionA: String, versionB: String): Int = {
    val digitsVersionA = versionA.split("\\.").map(_.toInt)
    val digitsVersionB = versionB.split("\\.").map(_.toInt)

    // Complexity: O(max(L1, L2))
    @tailrec
    def compareVersionNumbersTailRec(a: Array[Int], b: Array[Int]): Int = {
      if (a.isEmpty && b.isEmpty) 0 // same revision
      else if (a.isEmpty) {
        if (b.exists((_ != 0))) -1
        else 0
      }
      else if (b.isEmpty) {
        if (a.exists(_ != 0)) 1
        else 0
      } else {
        val v1 = a.head
        val v2 = b.head
        if (v1 < v2) -1
        else if (v1 > v2) 1
        else compareVersionNumbersTailRec(a.tail, b.tail)
      }
    }

    compareVersionNumbersTailRec(digitsVersionA, digitsVersionB)

  }

}

class CompareVersionNumbersProblemSpec extends AnyWordSpec {

  val problem = new CompareVersionNumbersProblem

  "compareVersionNumbers method" should {
    "return -1 if versionA is lower then versionB" in {
      assert(problem.compareVersionNumbers("0.9", "1.0.3.4") == -1)
      assert(problem.compareVersionNumbers("1.0.3.4", "1.1.0") == -1)
      assert(problem.compareVersionNumbers("1.1.0", "2.0") == -1)
    }

    "return 0 if version A is equal with version B" in {
      assert(problem.compareVersionNumbers("2.1", "2.01") == 0)
      assert(problem.compareVersionNumbers("1.0", "1.0.0.0") == 0)
    }

    "return 1 if version A is greater then version B" in {
      assert(problem.compareVersionNumbers("1.0.3.4", "0.9") == 1)
    }
  }
}
