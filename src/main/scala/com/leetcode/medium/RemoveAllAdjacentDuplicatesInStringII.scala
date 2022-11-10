package com.leetcode.medium

import scala.collection.mutable

object RemoveAllAdjacentDuplicatesInStringII {
  def removeDuplicates(s: String, k: Int): String = {
    if (s.isEmpty) ""
    else {
      val queue = mutable.Stack.empty[(Char, Int)]
      queue.append((s.head, 1))
      (1 until s.length).foldLeft(queue) { (queue, i) =>
        if (queue.isEmpty || queue.last._1 != s(i)) {
          queue.append((s(i), 1))
        } else {
          val (char, occurrence) = queue.last
          if (char == s(i) && occurrence + 1 < k) {
            queue.removeLast()
            queue.append((char, occurrence + 1))
          } else {
            queue.removeLast()
            queue
          }
        }
      }
      queue.toArray
        .map { case (c, j) => s"$c" * j}
        .mkString("")
    }
  }

  def main(args: Array[String]): Unit = {
    println(removeDuplicates("abcd", 2))
    println(removeDuplicates("deeedbbcccbdaa", 3))
  }
}
