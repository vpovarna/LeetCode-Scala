package com.interviewes

/*
Write a function checking that the given string is valid. We consider a string
to be valid if all the characters of the string have exactly the same frequency.

Examples:
  "aabbcc" is a valid string
  "aabbccc" is an invalid string

Followup: Check if the string is valid as it is (same condition as before) or if one character at one position can be removed from the string so it will become valid.
*/

object InterviewB {

  def isStringValidPart1(str: String): Boolean = {
    if (str.isEmpty) false
    else {
      val charMap: Map[Char, Int] = buildCharsMap(str)
      // Set == O(size of unique values)
      charMap.values.toSet.size == 1
    }
  }


  def isStringValidPart2(str: String): Boolean = {
    val map: Map[Int, Int] = countSimilarMaps(buildCharsMap(str))
    val values = map.values.toArray

    if (map.size == 1) true
    else if (map.size > 2) false
    else {
      if (values.toSet.size == 1) true
      else {
        val keys = map.keys.toArray.sortInPlace()
        math.abs(values.last - values.head) == 1 && (map(keys(0)) > map(keys(1)))
      }
    }
  }

  // Time = O(N), N == size of the array
  // Space = 0(M), M == size of hashMap
  def buildCharsMap(nums: String): Map[Char, Int] = {
    nums.foldLeft(Map[Char, Int]()) { (aMap, c) =>
      aMap + (c -> (aMap.getOrElse(c, 0) + 1))
    }
  }

  // count the number of the same groups
  // Map('a' -> 2, 'b'-> 3, 'c' ->3) will become: Map('3' -> 2, '2'-> 1)
  def countSimilarMaps(charMap: Map[Char, Int]): Map[Int, Int] = {
    charMap.foldLeft(Map[Int, Int]()) {
      case (map, (_, value)) => map + (value -> (map.getOrElse(value, 0) + 1))
    }
  }

  def main(args: Array[String]): Unit = {
    println(isStringValidPart1("aabbcc")) // true
    println(isStringValidPart1("aabbccc")) // false

    println("Follow up question: -----")
    println(isStringValidPart2("aabbcc")) // true
    println(isStringValidPart2("aabbccc")) // true
    println(isStringValidPart2("aaabbccc")) // false
    println(isStringValidPart2("aabbbccc")) // false
    println(isStringValidPart2("aaabbbb")) // true
  }

}
