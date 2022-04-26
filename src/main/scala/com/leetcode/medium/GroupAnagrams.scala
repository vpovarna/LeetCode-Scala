package com.leetcode.medium

object GroupAnagrams {

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs
      .groupBy(s => s.sorted)
      .values
      .map(_.toList)
      .toList
  }

  def main(args: Array[String]): Unit = {
    println(groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")))
    println(groupAnagrams(Array("ddddddddddg", "dgggggggggg")))
  }

}
