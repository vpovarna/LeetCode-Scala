package com.work

/**
 * I:  aab, cac, ac, ba, caa, d
 * O:  aab -> 2 [aab, ba]
 *     cac -> 3 [cac, ac, caa]
 *     d   -> 1 [d]
 */
object InterviewProblem extends App {

  val inputStr = "aab, cac, ac, ba, caa, d"

  val output = inputStr.split(",")
    .map(_.trim)
    .map(word => (word.toSet, word))
    .foldLeft(Map[Set[Char], Vector[String]]()) { (foldMap, pair) =>
      val (charSet, initialStr) = pair
      val tmpVector: Vector[String] = foldMap.getOrElse(charSet, Vector[String]())
      foldMap + (charSet -> (tmpVector :+ initialStr))
    }
    .values
    .map(vec => (vec.length, vec))
    .toList

  println(output)

}
