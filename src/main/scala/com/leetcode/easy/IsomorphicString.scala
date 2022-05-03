package com.leetcode.easy

object IsomorphicString {

  def isIsomorphic(s: String, t: String): Boolean = {

    val sCharacterMap: Map[Char, Vector[Int]] = buildWordCharMap(s)
    val tCharacterMap: Map[Char, Vector[Int]] = buildWordCharMap(t)

    sCharacterMap.values.toSet == tCharacterMap.values.toSet
  }

  def buildWordCharMap(s: String): Map[Char, Vector[Int]] = {
    s.indices.foldLeft(Map[Char, Vector[Int]]()) { (map, i) =>
      val indexes: Vector[Int] = map.getOrElse(s(i), Vector[Int]())
      map + (s(i) -> ( i +: indexes))
    }
  }



  def main(args: Array[String]): Unit = {
    println(isIsomorphic("egg", "add"))
    println(isIsomorphic("foo", "bar"))
    println(isIsomorphic("paper", "title"))
  }

}
