package com.strings

import org.scalatest.wordspec.AnyWordSpec

import scala.annotation.tailrec

class StringProblems {

  def countCharacters(s: String): Map[Char, Int] = {
    countCharactersTailRec(s, Map.empty)
  }

  def checkAnagrams(sa: String, sb: String): Boolean = {

    @tailrec
    def checkAnagramTailRec(remainingString: String, saCharacterCount: Map[Char, Int]): Boolean = {
      if (remainingString.isEmpty && saCharacterCount.isEmpty) true
      else if (remainingString.isEmpty) false
      else if (!saCharacterCount.contains(remainingString.head)) false
      else {
        val tmpVal = saCharacterCount(remainingString.head) - 1
        if (tmpVal == 0) checkAnagramTailRec(remainingString.tail, saCharacterCount - remainingString.head)
        else checkAnagramTailRec(remainingString.tail, saCharacterCount + (remainingString.head -> tmpVal))
      }
    }

    if (sa.length != sb.length) false
    else {
      val saCharacterCount = countCharactersTailRec(sa, Map.empty)
      checkAnagramTailRec(sb, saCharacterCount): Boolean
    }
  }

  // Another simple solution comparing the map
  def checkAnagramsSimpleImpl(sa: String, sb: String): Boolean = countCharacters(sa) == countCharacters(sb)

  // Another solution using string sort
  def checkAnagramsUsingSort(sa: String, sb: String): Boolean = sa.sorted == sb.sorted

  def generateAllValidParentheses(n: Int): List[String] = {
    @tailrec
    def generateAllValidParenthesesTailRec(nRemainingPrent: Int, currentStrings: Set[String]): Set[String] = {
      if (nRemainingPrent == 0) currentStrings
      else {
        val newStrings = for {
          string <- currentStrings
          index <- 0 until string.length
        } yield {
          val (before, after) = string.splitAt(index)
          s"$before()$after"
        }
        generateAllValidParenthesesTailRec(nRemainingPrent - 1, newStrings)
      }
    }

    assert(n >= 0)
    if (n == 0) List.empty
    else generateAllValidParenthesesTailRec(n-1, Set("()")).toList
  }


  @tailrec
  private def countCharactersTailRec(remainingString: String, map: Map[Char, Int]): Map[Char, Int] = {
    if (remainingString.isEmpty) map
    else {
      val tmpMap = map + (remainingString.head -> (map.getOrElse(remainingString.head, 0) + 1))
      countCharactersTailRec(remainingString.tail, tmpMap)
    }
  }
}

class StringProblemsSpec extends AnyWordSpec {
  val stringProblems = new StringProblems

  "for a give string countCharacters method" should {
    "do a word count for every string letter" in {
      assert(stringProblems.countCharacters("demo").equals(Map('d' -> 1, 'e' -> 1, 'm' -> 1, 'o' -> 1)))
      assert(stringProblems.countCharacters("hello").equals(Map('h' -> 1, 'e' -> 1, 'l' -> 2, 'o' -> 1)))
      assert(stringProblems.countCharacters("Scala").equals(Map('S' -> 1, 'c' -> 1, 'a' -> 2, 'l' -> 1)))
    }
  }

  "checkAnagrams method" should {
    "return true or false if the provided strings are anagrams" in {
      assert(!stringProblems.checkAnagrams("Scala", "Java"))
      assert(stringProblems.checkAnagrams("scala", "alacs"))
      assert(stringProblems.checkAnagrams("desserts", "stressed"))
    }
  }

  "generateAllValidParentheses method" should {
    "return a list of unique open close parentheses" in {
      assert(stringProblems.generateAllValidParentheses(0).equals(List.empty))
      assert(stringProblems.generateAllValidParentheses(1).equals(List("()")))
      assert(stringProblems.generateAllValidParentheses(2).equals(List("()()","(())")))
    }
  }
}
