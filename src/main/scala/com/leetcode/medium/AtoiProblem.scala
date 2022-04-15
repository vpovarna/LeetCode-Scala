package com.leetcode.medium

object AtoiProblem {
  def myAtoi(s: String): Int = {

    val trimmed = s.trim
    if (trimmed == "") 0
    else {
      val (sign, trimmed2) =
        if (trimmed.head == '-') ("-", trimmed.tail)
        else if (trimmed.head == '+') ("", trimmed.tail)
        else ("", trimmed)

      val digits = trimmed2.takeWhile(c => c >= '0' && c <= '9')
      if (digits == "") 0
      else {
        val res = BigInt(s"$sign$digits")
        if (res > Int.MaxValue) Int.MaxValue
        else if (res < Int.MinValue) Int.MinValue
        else res.toInt
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(myAtoi("-42"))
    println(myAtoi("42"))
    println(myAtoi("0042"))
    println(myAtoi("4193 with words"))
    println(myAtoi("   -42"))
    println(myAtoi("words and 987"))
  }
}
