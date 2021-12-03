package com.numbers

object LargestNumber {

  def main(args: Array[String]): Unit = {
    val list = List[Int](3, 30, 5, 9, 34)
    println(largestNumber(list))
    println(largestNumber(List(10, 2)))
    println(largestNumber(List(1)))
    println(largestNumber(List()))
    println(largestNumber(List(0, 0, 0)))

  }

  /*
     Given a list of non-negative integers, arrange them such that they form the largest number.
     The result might be a huge solution.
   */
  def largestNumber(numbers: List[Int]): String = {
    implicit val newOrdering: Ordering[Int] = Ordering.fromLessThan((a, b) => {

      def concatenate(a: Int, b: Int): Boolean = {
        if (s"$a$b".toInt > s"$b$a".toInt) true
        else false
      }

      concatenate(a, b)
    })

    val largest = numbers.sorted.mkString("")

    if (numbers.isEmpty || largest.charAt(0) == '0') "0"
    else largest
  }
}

