package com.leetcode.medium

import scala.annotation.tailrec

object FindAllAnagramsInAString {

  def findAnagrams(s: String, p: String): List[Int] = {
    val sSize = s.length
    val pSize = p.length
    val pSorted = p.sorted

    @tailrec
    def findAnagramsTailRec(index: Int, acc: List[Int]): List[Int] = {
      if (index + pSize > sSize) acc
      else {
        val isAnagram = s.slice(index, index + pSize).sorted == pSorted
        if (isAnagram) findAnagramsTailRec(index + 1, index :: acc)
        else findAnagramsTailRec(index + 1, acc)
      }
    }

    findAnagramsTailRec(0, Nil)
  }

  def main(args: Array[String]): Unit = {
    println(FindAllAnagramsInAString.findAnagrams("cbaebabacd", "abc"))
  }

}
