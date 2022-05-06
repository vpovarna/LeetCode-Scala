package com.leetcode.easy

import scala.collection.immutable.ListMap

object FirstUniqueChar {
  def firstUniqChar(s: String): Int = {
    s.foldLeft(ListMap.empty[Char, Int]) { (map, c) =>
      map + (c -> (map.getOrElse(c, 0) + 1))
    }
      .find(_._2 == 1) match {
      case Some((c, _)) => s.indexOf(c)
      case None => -1
    }
  }

  def main(args: Array[String]): Unit = {
    println(firstUniqChar("leetcode")) // 0
    println(firstUniqChar("loveleetcode")) // 2
    println(firstUniqChar("aabb")) // -1
  }
}
