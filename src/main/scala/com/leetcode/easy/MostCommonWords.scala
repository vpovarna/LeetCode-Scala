package com.leetcode.easy

import scala.util.matching.Regex

object MostCommonWords extends App {

  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    var lowerWords = paragraph.map(_.toLower)
    val regex: Regex = "[!?',;.]".r

    lowerWords = regex.replaceAllIn(lowerWords, " ")

    var word_list = lowerWords.split(' ')

    for (i <- banned.indices) {
      word_list = word_list.filter(_ != banned(i))
    }
    word_list.filter(_.nonEmpty).groupBy(identity).maxBy(_._2.length)._1

  }

  println(mostCommonWord("a, a, a, a, b,b,b,c, c", Array[String]("a")))

}
