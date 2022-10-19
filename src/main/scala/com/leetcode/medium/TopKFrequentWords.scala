package com.leetcode.medium

import scala.annotation.tailrec

object TopKFrequentWords {

  def topKFrequent_1(words: Array[String], k: Int): List[String] = {
    val wordCountMap = getWordCountMap(words)

    // Invert the map
    val sortedInvertedMap = wordCountMap.foldLeft(Map.empty[Int, List[String]]) {
      (map, wordCountMapValue) =>
        val (key, value) = wordCountMapValue
        map + (value -> (map.getOrElse(value, List.empty[String]) :+ key))
    }
      .toSeq.sortWith(_._1 > _._1)

    // Extract the values
    @tailrec
    def buildResult(remainingVal: Int, remainingSortedInvertedMap: Seq[(Int, List[String])], result: List[String] = List.empty[String]): List[String] = {
      if (remainingVal <= 0) result
      else {
        val (_, words) = remainingSortedInvertedMap.head
        val sortedWords = words.sorted
        val tmpList = if (sortedWords.length > remainingVal)
          sortedWords.take(remainingVal)
        else
          sortedWords
        buildResult(remainingVal - words.length, remainingSortedInvertedMap.tail, result ++ tmpList)
      }
    }

    buildResult(k, sortedInvertedMap)

  }

  def topKInvert_2(words: Array[String], k: Int): List[String] = {
    val wordCountMap = getWordCountMap(words)
    wordCountMap.toSeq
      .sortBy(a => (-a._2, a._1))
      .map(_._1)
      .take(k)
      .toList
  }

  private def getWordCountMap(words: Array[String]): Map[String, Int] = {
    words.groupBy(identity)
      .view
      .mapValues(_.length)
      .toMap
  }

  def main(args: Array[String]): Unit = {
    val inputArray_1 = Array("i", "love", "leetcode", "i", "love", "coding")
    println(topKInvert_2(inputArray_1, 2)) // List("i", "love")
    val inputArray_2 = Array("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is")
    println(topKInvert_2(inputArray_2, 4)) // List("the", "is", "sunny", "day")
    println(topKInvert_2(inputArray_1, 1)) // List("i")
  }

}
