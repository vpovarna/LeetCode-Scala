package com.leetcode

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * @author Adobe Systems Incorporated.
 */
object ValidParentheses extends App {

  /**
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
   * An input string is valid if:
   * Open brackets must be closed by the same type of brackets.
   * Open brackets must be closed in the correct order.
   */

  val parenthesesMap: Map[Char, Char] = Map(
    ')' -> '(',
    '}' -> '{',
    ']' -> '['
  )

  def isValid(s: String): Boolean = {
    val chars: List[Char] = s.toList;

    if (chars.size <= 1) false
    else validParenthesesRecursion(chars, mutable.Stack[Char](), stopCondition = false)
  }

  @tailrec
  def validParenthesesRecursion(chars: List[Char], stack: mutable.Stack[Char], stopCondition: Boolean): Boolean = {
    if (stopCondition) false
    else if (chars.isEmpty && stack.nonEmpty) false
    else if (chars.isEmpty && stack.isEmpty) true
    else {
      if (parenthesesMap.contains(chars.head)) {
        val topElement = if (stack.isEmpty) '#' else stack.pop()
        val matcherCheck: Boolean = parenthesesMap.get(chars.head) match {
          case Some(param) =>
            if (param != topElement) true
            else false
          case None => false
        }
        validParenthesesRecursion(chars.tail, stack, stopCondition = matcherCheck)
      } else validParenthesesRecursion(chars.tail, stack.push(chars.head), stopCondition = false)
    }
  }

  println(isValid("()"))
  println(isValid("()[]{}"))
  println(isValid("(]"))
  println(isValid("([)]"))
  println(isValid("{[]}"))
  println(isValid("["))
  println(isValid("(("))
  println(isValid("){"))

}
