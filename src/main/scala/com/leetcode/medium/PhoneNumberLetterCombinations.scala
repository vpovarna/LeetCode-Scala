package com.leetcode.medium

import scala.collection.MapView

object PhoneNumberLetterCombinations {

  val phoneNumbers: MapView[Char, List[Char]] = Map(('2' -> "abc"), ('3' -> "def"), ('4' -> "ghi"), ('5' -> "jkl"), ('6' -> "mno"), ('7' -> "pqrs"), ('8' -> "tuv"), ('9' -> "wxyz")).mapValues(_.toList)

  def letterCombinations(digits: String): List[String] = {
    @annotation.tailrec
    def dfs(digits: String, acc: List[String]): List[String] = {
      if (digits.isEmpty) acc
      else {
        val head = digits.head
        dfs(digits.tail, acc.flatMap(x => {
          phoneNumbers(head).map(y =>
            s"$x$y"
          )
        }))
      }
    }

    if (digits.isEmpty) List("")
    else dfs(digits, List(""))
  }

  def main(args: Array[String]): Unit = {
    println(letterCombinations("23"))
    println(letterCombinations(""))
    println(letterCombinations("2"))
  }

}
