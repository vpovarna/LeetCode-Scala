package com.leetcode.easy

object MostOneSegmentOfOnes {
  def checkOnesSegment(s: String): Boolean = {
    s.sliding(2).foldLeft(true) {(condition, segment) =>
      if (segment == "01") false
      else condition
    }
  }

  def checkOnesSegmentScanLeft(s: String): Boolean = {
    val list = s.sliding(2).scanLeft(true) { (_, segment) =>
      if (segment == "01") false
      else true
    }

    list.find(x => !x) match {
      case Some(_) => false
      case None => true
    }
  }

  def main(args: Array[String]): Unit = {
    println(checkOnesSegment("1")) // true
    println(checkOnesSegment("1001")) // false
    println(checkOnesSegment("110")) // true
  }
}
