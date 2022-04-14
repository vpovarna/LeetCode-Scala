package com.leetcode.medium

import scala.util.Try

object ReverseInteger {

  def reverse(x: Int): Int = {
    if (x < 0) -reverseInt(math.abs(x))
    else reverseInt(x)
  }

  private def reverseInt(x: Int): Int = {
    Try(x.toString.foldLeft("") { (s, d) =>
      if (s.isEmpty && d == 0) s
      else d + s
    }.toInt).getOrElse(0)
  }

  def main(args: Array[String]): Unit = {
    println(reverse(123))
    println(reverse(-123))
    println(reverse(120))
    println(reverse(1534236469))
  }
}
