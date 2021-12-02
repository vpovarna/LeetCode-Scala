package com.strings

import org.scalatest.wordspec.AnyWordSpec

import scala.annotation.tailrec

class ParenthesisProblems {

  // Assumption: The string contains only "( )" parenthesis
  def hasValidParenthesis(string: String): Boolean = {

    @tailrec
    def hasValidParenthesisTailRec(remainingString: String, openParents: Int): Boolean = {
      if (remainingString.isEmpty && openParents == 0) true
      else if (remainingString.isEmpty) false
      else {
        val head = remainingString.head
        if (head == '(') hasValidParenthesisTailRec(remainingString.tail, openParents + 1)
        else if (head == ')') hasValidParenthesisTailRec(remainingString.tail, openParents - 1)
        else hasValidParenthesisTailRec(remainingString.tail, openParents)
      }
    }

    if (string.isEmpty) true
    else hasValidParenthesisTailRec(string, 0)
  }

}

class ParenthesisProblemsSpec extends AnyWordSpec {
  val parenthesisProblems = new ParenthesisProblems

  "hasValidParenthesis method" should {
    "return true of false if the string contains balanced parenthesis" in {
      assert(parenthesisProblems.hasValidParenthesis("()"))
      assert(parenthesisProblems.hasValidParenthesis("()()"))
      assert(parenthesisProblems.hasValidParenthesis("(())"))
      assert(parenthesisProblems.hasValidParenthesis("((test))"))
      assert(!parenthesisProblems.hasValidParenthesis("(()"))
    }
  }
}