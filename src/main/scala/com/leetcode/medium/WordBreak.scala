package com.leetcode.medium

object WordBreak {

  def wordBreak(s: String, wordDict: List[String]): Boolean = {
   val res =  (1 to s.length).foldLeft(List(0)) { (acc, i) =>
      if (acc.exists((x: Int) => {
        val str = s.substring(x, i)
        wordDict.contains(str)
      })) i :: acc
      else acc
    }
    println(res)

    res.head == s.length
  }

  def main(args: Array[String]): Unit = {
    println(WordBreak.wordBreak("bb", List("a", "b", "bbb", "bbbbb")))
    println(WordBreak.wordBreak("leetcode", List("leet", "code")))
  }

}
