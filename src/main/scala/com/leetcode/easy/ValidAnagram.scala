package com.leetcode.easy

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

object ValidAnagram {

  def isAnagram(s: String, t: String): Boolean = {
    if (s.length != t.length) false
    else buildWordCharacterMap(s) == buildWordCharacterMap(t)
  }

  private def buildWordCharacterMap(s: String): Map[Char, Int] = {
    s.foldLeft(Map.empty[Char, Int])((m, c) => {
      m + (c -> (m.getOrElse(c, 0) + 1))
    })
  }
}

class ValidAnagramSpec extends AnyFlatSpec with Matchers {
  "Valid Anagram" should
    "return true, if the isAnagram method is called with valid strings" in {
    ValidAnagram.isAnagram("anagram", "nagaram") shouldBe true
  }
  it should "return false, if the isAnagram method is called with valid strings" in {
    ValidAnagram.isAnagram("rat", "car") shouldBe false
  }

}


