package com.leetcode.easy

object RansomNote {

  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    if (ransomNote.length > magazine.length) false
    else {
      val ransomNoteCharMap = buildCharOccurrenceMap(ransomNote)
      val magazineCharMap = buildCharOccurrenceMap(magazine)
      if (ransomNoteCharMap.size > magazineCharMap.size) false
      else checkRansomNote(ransomNoteCharMap, magazineCharMap)
    }
  }

  private def buildCharOccurrenceMap(magazine: String): Map[Char, Int] = {
    magazine.foldLeft(Map.empty[Char, Int]) { (aMap, c) =>
      aMap + (c -> (aMap.getOrElse(c, 0) + 1))
    }
  }

  @scala.annotation.tailrec
  def checkRansomNote(ransomNoteCharMap: Map[Char, Int], magazineCharMap: Map[Char, Int], isValid: Boolean = true): Boolean = {
    if (ransomNoteCharMap.isEmpty || !isValid) isValid
    else {
      val entity = ransomNoteCharMap.head
      if (!magazineCharMap.contains(entity._1)) checkRansomNote(ransomNoteCharMap.tail, magazineCharMap, isValid = false)
      else if (magazineCharMap.contains(entity._1) && magazineCharMap(entity._1) < entity._2) checkRansomNote(ransomNoteCharMap.tail, magazineCharMap, isValid = false)
      else checkRansomNote(ransomNoteCharMap.tail, magazineCharMap)
    }
  }

  def main(args: Array[String]): Unit = {
    println(canConstruct("aa", "ab")) // flase
    println(canConstruct("a", "b")) // false
    println(canConstruct("aa", "aab")) // true
    println(canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj")) // true
  }
}
