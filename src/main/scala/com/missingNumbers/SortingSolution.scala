package com.missingNumbers

import scala.util.control.Breaks._

object SortingSolution extends App {

  val inputArray = Array[Int](3, 0, 1)
  val sortedArray = inputArray.sorted

  // Ugly solution
  breakable {
    for (i <- 1 to sortedArray.length) {
      if (sortedArray(i) != i) {
        println(i)
        break
      }
    }
  }

  // scala solution
  val result = inputArray.sorted.zipWithIndex.filter(pair => pair._1 != pair._2)(0)._2
  println(result)




}
