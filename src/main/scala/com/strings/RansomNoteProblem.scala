package com.strings

import org.scalatest.wordspec.AnyWordSpec

import scala.annotation.tailrec

class RansomNoteProblem {

  /*
   ransomNote(
    "I have your daughter. I want 1000000 dollars, or you'll never see her again.",
    "I bought this really nice doll for my daughter. It was 20 dollars on Amazon. She's never been happier.
     I often have discounts from my network, so if you want to buy some really cool stuff for your kids, I can send you an invite
     if you sign up to my newsletter. It's read by 100000 people, and you'll never need to search for online discounts again."
   )
 */
  def ransomNote(note: String, magazine: String): Boolean = {
    assert(note.nonEmpty)
    assert(magazine.nonEmpty)

    val noteCharsMap = buildMap(note, Map.empty)
    val magazineCharsMap = buildMap(magazine, Map.empty)

    magazineCharsMap.keySet.forall(char => noteCharsMap.getOrElse(char, 0) <= magazineCharsMap.getOrElse(char, 0))
  }

  @tailrec
  final def buildMap(note: String, tmpMap: Map[Char, Int]): Map[Char, Int] = {
    if (note.isEmpty) tmpMap
    else {
      val head = note.head
      val newMap = tmpMap + (head -> (tmpMap.getOrElse(head, 0) + 1))
      buildMap(note.tail, newMap)
    }
  }

  final def buildMapV2(sentence: String): Map[Char, Int] = {
    sentence.foldLeft(Map[Char, Int]()) {
      case (map, char) => map + (char -> (map.getOrElse(char, 0) + 1))
    }
  }

  final def buildMapV3(sentence: String): Map[Char, Int] = sentence.groupBy(char => char).view.mapValues(_.length).toMap
}

class RansomNoteSpec extends AnyWordSpec {

  val ransomNoteProblem = new RansomNoteProblem

  "buildMap method" should {
    "Count each string character into a map" in {
      val charMap = ransomNoteProblem.buildMapV2("This is a test")
      assert(charMap == Map('T' -> 1, 'h' -> 1, 'i' -> 2, 's' -> 3, ' ' -> 3, 'a' -> 1, 't' -> 2, 'e' -> 1))
    }
  }

  "ransomNote method" should {
    "return true of false if a ransom note can be created with magazine characters" in {
      assertThrows[AssertionError](!ransomNoteProblem.ransomNote("test", ""))
      assert(ransomNoteProblem.ransomNote("test", "test"))
      assert(ransomNoteProblem.ransomNote("te test", "test et"))
      assert(ransomNoteProblem.ransomNote("te test ca gigi.", "gitest  gica et."))
    }
  }

}
