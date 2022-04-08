package com.work

/**
 * Let's compress the given string in the most easy way possible: every time we find a repeated sequence of characters,
 * we'll just print out the first occurrence of the character plus the number of times it is being shown in this repeated sequence ("aaa" should be converted to "a3").
 */
object Compression {

  def compress(s: String): String = {
    s.toCharArray
      .foldLeft(Tuple4[String, Int, Char, Int]("", 0, s.head, 1)) { (tuple, char) =>
        val (result, counter, prevChar, index) = tuple
        if (char == prevChar && index != s.length)
          (result, counter + 1, prevChar, index + 1)
        else if
            (char != prevChar && index != s.length) (s"$result$prevChar${generateCountValue(counter)}", 1, char, index + 1)
        else
          (s"$result$prevChar${counter + 1}", 1, char, index)
      }._1
  }

  private def generateCountValue(count: Int): String = {
    if (count == 1) "" else count.toString
  }

  def main(args: Array[String]): Unit = {
    println(compress("aaabcccddaa")) // should print "a3bc3d2a2"
    println(compress("aa")) // should print "a2"
    println(compress("ab")) // should print "ab"
  }

}
