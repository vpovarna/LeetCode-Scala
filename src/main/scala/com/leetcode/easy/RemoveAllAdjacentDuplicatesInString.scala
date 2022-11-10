package com.leetcode.easy
import scala.collection.mutable

object RemoveAllAdjacentDuplicatesInString {

  def removeDuplicates(s: String): String = {
    if (s.isEmpty) ""
    else {
      val queue = mutable.ArrayDeque.empty[Char]
      queue.append(s.head)
      (1 until s.length).foldLeft(queue) { (queue, i) =>
        if (queue.isEmpty || queue.last != s(i)) queue.append(s(i))
        else {
          queue.removeLast()
          queue
        }
      }
      queue.mkString("")
    }
  }

  def main(args: Array[String]): Unit = {
    println(removeDuplicates("abbaca")) // ca
    println(removeDuplicates("azxxzy")) // ay
  }

}
