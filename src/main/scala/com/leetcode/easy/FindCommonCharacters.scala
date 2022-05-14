package com.leetcode.easy

import scala.collection.mutable.ArrayBuffer

object FindCommonCharacters {
  def commonChars(words: Array[String]): List[String] = {
    if (words.length == 0) List()
    else if (words.length == 1) words(0).split("").toList
    else {
      val intersectHashMap = words.foldLeft(getStringMap(words(0))) { (map, str) =>
        val strMap = getStringMap(str)
        map.keySet.intersect(strMap.keySet).map(k => k -> Math.min(map(k), strMap(k))).toMap
      }
      val result: ArrayBuffer[String] = ArrayBuffer.empty[String]
      intersectHashMap.foreach {
        case (key, value) =>
          (0 until value).foreach(_ => result.addOne(key.toString))
      }
      result.toList
    }
  }

  def getStringMap(word: String): Map[Char, Int] = word.groupBy(identity).view.mapValues(_.length).toMap

  def main(args: Array[String]): Unit = {
    println(commonChars(Array("bella", "label", "roller")))
    println(commonChars(Array("cool","lock","cook")))
  }

}
