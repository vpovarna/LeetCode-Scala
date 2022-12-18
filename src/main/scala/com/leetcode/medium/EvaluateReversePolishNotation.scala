package com.leetcode.medium

object EvaluateReversePolishNotation {

  def evalRPN(tokens: Array[String]): Int = {
    val stack = scala.collection.mutable.Stack.empty[Int]
    tokens.foldLeft(stack){ (stack, token) =>
      token match {
        case "+" =>
          stack.push(stack.pop() + stack.pop())
        case "-" =>
          // order matters
          val y = stack.pop()
          val x = stack.pop()
          stack.push(x - y)
        case "*" =>
          stack.push(stack.pop() * stack.pop())
        case "/" =>
          // order matters
          val y = stack.pop()
          val x = stack.pop()
          stack.push(x / y)
        case _ => stack.push(token.toInt)
      }
    }.head
  }

  def main(args: Array[String]): Unit = {
    println(evalRPN(Array("2","1","+","3","*")))  // 9
    println(evalRPN(Array("4","13","5","/","+"))) // 6
    println(evalRPN(Array("10","6","9","3","+","-11","*","/","*","17","+","5","+"))) // 22
  }
}
