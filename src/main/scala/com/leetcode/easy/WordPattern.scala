package com.leetcode.easy


object WordPattern {

  def wordPattern(pattern: String, s: String): Boolean = {
    val words = s.split(" ")
    val patternPositionMap = buildWordPositionMap(pattern.toArray.map(_.toString))
    val wordsPositionMap = buildWordPositionMap(words)
    val vectorPostions = patternPositionMap.values.toSet
    val wordsPosition = wordsPositionMap.values.toSet
    vectorPostions == wordsPosition
  }

  private def buildWordPositionMap(pattern: Array[String]): Map[String, Vector[Int]] = {
    pattern.indices.foldLeft(Map[String, Vector[Int]]()) { (map: Map[String, Vector[Int]], i: Int) =>
      val currentChar: String = pattern(i)
      val positions: Vector[Int] = map.getOrElse(currentChar, Vector[Int]())
      map + (currentChar -> (positions :+ i))
    }
  }

  def main(args: Array[String]): Unit = {
    println(wordPattern("abba", "dog cat cat dog"))
    println(wordPattern("abba", "dog cat cat fish"))
    println(wordPattern("aaaa", "dog cat cat dog"))
    println(wordPattern("abcdefghijklmnnmlkjihgfedcba", "aa bb cc dd ee ff gg hh ii jj kk ll mm nn nn mm ll kk jj ii hh gg ff ee dd cc bb aa"))
  }

}
