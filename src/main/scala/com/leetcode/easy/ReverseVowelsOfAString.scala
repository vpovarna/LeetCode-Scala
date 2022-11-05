package com.leetcode.easy

object ReverseVowelsOfAString {

  def reverseVowels(s: String): String = {

    val vowelsSet = Set[Char]('a', 'e', 'i', 'o', 'u', 'A', 'E',
    'I', 'O', 'U')

    val chars: Array[Char] = s.toCharArray
    var (start, end) = (0, chars.length - 1)

    while (start < end) {
      val (charA, charB) = (chars(start), chars(end))
      if (!vowelsSet.contains(charA) && !vowelsSet.contains(charB)) {
        // both chars are not vowels, increment both
        start += 1
        end -= 1
      } else if (!vowelsSet.contains(charA) && vowelsSet.contains(charB)) {
        // second element is a vowels, increment start
        start += 1
      } else if (vowelsSet.contains(charA) && !vowelsSet.contains(charB)) {
        // second element is a vowels, decrease end
        end -= 1
      } else if (vowelsSet.contains(charA) && vowelsSet.contains(charB) && charA == charB) {
        // both chars are vowels and they are the same
        start += 1
        end -= 1
      } else {
        chars.update(start, charB)
        chars.update(end, charA)
        start += 1
        end -= 1
      }
    }

    chars.mkString("")
  }

  def main(args: Array[String]): Unit = {
    println(reverseVowels("hello")) // holle
    println(reverseVowels("leetcode")) // leotcede
    println(reverseVowels("aA")) // Aa
  }

}
