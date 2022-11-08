package com.leetcode.easy

import scala.annotation.tailrec
import scala.collection.mutable

object MakeTheStringGreat {
  def makeGood(s: String): String = {
    s.foldLeft(mutable.ArrayDeque.empty[Char]) { (d, c) =>
      d.append(c)
      removeChars(d)
    }.mkString("")
  }

  @tailrec
  def removeChars(
      deque: mutable.ArrayDeque[Char]
  ): mutable.ArrayDeque[Char] = {
    if (
      deque.length >= 2 &&
       (deque(deque.length - 2) != deque(deque.length - 1)) &&
        (deque(deque.length - 2).toLower == deque(deque.length - 1).toLower)
    ) {
      deque.removeLast()
      deque.removeLast()
      removeChars(deque)
    } else {
      deque
    }
  }

  def main(args: Array[String]): Unit = {
    println(makeGood("leEeetcode")) // "leetcode"
    println(makeGood("abBAcC")) // ""
    println(makeGood("s")) // "s"
  }
}
