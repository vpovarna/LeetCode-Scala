package com.leetcode.medium

object DetermineIfTwoStringsAreClose {
  def closeStrings(word1: String, word2: String): Boolean = {
    val map1 = getMap(word1)
    val l1 = map1.values.toList.sorted
    val map2 = getMap(word2)
    val l2 = map2.values.toList.sorted

    val s1 = map1.keys.toList.sorted
    val s2 = map2.keys.toList.sorted

    l1 == l2 && s1 == s2
  }

  def getMap(word: String): Map[Char,Int] ={
    word.foldLeft(Map.empty[Char,Int]) { (map,c) =>
      map + (c -> (map.getOrElse(c,0) +1))
    }
  }
}
