package com.leetcode.medium

object SortCharactersByFrequency {
  def frequencySort(s: String): String = {
    val charOccurrence = s.toArray
      .groupBy(identity)
      .view
      .mapValues(_.length)
      .toList
      .sortBy(-_._2)

    charOccurrence
      .foldLeft(List.empty[String]) {
        (arr, touple) =>
          val (character, count) = touple
          arr :+ s"$character" * count
      }
      .toList
      .mkString
  }

  def main(args: Array[String]): Unit = {
    println(frequencySort("tree")) // "eert"
  }
}
