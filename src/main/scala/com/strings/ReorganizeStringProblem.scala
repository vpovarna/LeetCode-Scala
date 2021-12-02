package com.strings

import org.scalatest.wordspec.AnyWordSpec

import scala.annotation.tailrec

class ReorganizeStringProblem {

  @tailrec
  final def organizeTailRec(charCount: Map[Char, Int], forbiddenChar: Char = '\u0000', acc: String): String = {
    if (charCount.isEmpty) acc
    else {
      val someChar = charCount.filter(_._1 != forbiddenChar).maxBy(_._2)._1
      if (charCount(someChar) == 1) organizeTailRec(charCount - someChar, someChar, s"$acc$someChar")
      else organizeTailRec(charCount + (someChar -> (charCount(someChar) - 1)), someChar, s"$acc$someChar")
    }
  }

  def reorganizeString(string: String): String = {
    val charCount = string.foldLeft(Map[Char, Int]()) {
      case (map, char) => map + (char -> (map.getOrElse(char, 0) + 1))
    }

    if (charCount.values.exists(_ > (string.length + 1) / 2)) ""
    else organizeTailRec(charCount, '\u0000', "")
  }
}

class ReorganizeStringSpec extends AnyWordSpec {
  val problem = new ReorganizeStringProblem

  "reorganizeString method" should {
    "reorganize string so that an element is not duplicated in two consecutive characters" in {
      assert(problem.reorganizeString("aaabc") == "abaca")
      assert(problem.reorganizeString("aaaaaabc") == "")
    }
  }
}


