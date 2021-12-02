package com.strings

import org.scalatest.wordspec.AnyWordSpec

class ReverseWordProblem {
  def reverseWords(string: String): String = {
    string.split(" ").filter(_.nonEmpty).reverse.mkString(" ")
  }

  //    val words = string.split(" ")
  //
  //    @tailrec
  //    def reverseWordsTailRec(remainingWords: List[String], result: String): String = {
  //      if (remainingWords.isEmpty) result.strip()
  //      else if (remainingWords.head.isEmpty) reverseWordsTailRec(remainingWords.tail, result)
  //      else reverseWordsTailRec(remainingWords.tail, s"${remainingWords.head.trim} $result")
  //    }
  //    reverseWordsTailRec(words.toList, "")
  //  }
}

class ReverseWordSpec extends AnyWordSpec {
  val problem = new ReverseWordProblem

  "reverseWords method" should {
    "return the list of words reverse as string" in {
      assert(problem.reverseWords("hello") == "hello")
      assert(problem.reverseWords("hello word") == "word hello")
      assert(problem.reverseWords("   hello      word ") == "word hello")
    }
  }
}
