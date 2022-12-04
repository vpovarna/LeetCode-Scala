package com.leetcode.easy

object DetermineIfStringHalvesAreAlike {
  def halvesAreAlike(s: String): Boolean = {
    val a = s.slice(0, s.length / 2)
    val b = s.slice((s.length / 2), s.length)

    countVowels(a) == countVowels(b)
  }

  def countVowels(s: String): Int = {
    val vowels = Set('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    s.foldLeft(0) { (count, c) =>
      if (vowels.contains(c)) count + 1
      else count
    }

  }
}
