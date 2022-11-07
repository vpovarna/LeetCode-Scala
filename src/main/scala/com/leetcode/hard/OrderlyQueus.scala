package com.leetcode.hard

import scala.util.chaining.scalaUtilChainingOps

object OrderlyQueus {
  def orderlyQueue(s: String, k: Int): String = {
    def rotate(i: Int): String = {
      val substrings = s.splitAt(i)
      s"${substrings._2}${substrings._1}"
    }

    if (k>=2)
      s.sorted
    else s.indices.map(i => rotate(i)).min
  }

  def main(args: Array[String]): Unit = {
    val s = "cba"
    println(orderlyQueue("cba", 1)) // acb
    println(orderlyQueue("baaca", 3)) // aaabc
  }

}
