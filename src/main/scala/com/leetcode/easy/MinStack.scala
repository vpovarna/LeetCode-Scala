package com.leetcode.easy

class MinStack() {
  private val stack = scala.collection.mutable.Stack.empty[Int]
  private var min = Int.MaxValue

  def push(`val`: Int): Unit = {
    // If the value is min, we push it to the stack and we update the current min
    if (`val` <= min) {
      stack.push(min)
      min = `val`
    }
    stack.push(`val`)
  }

  def pop(): Unit = {
    val topVal = stack.pop()
    // In case the top valu is the min value we pop another value and update it to min
    if (topVal == min)
      min = stack.pop()
  }

  def top(): Int = {
    stack.top
  }

  def getMin(): Int = {
    min
  }

}

class MinStackFP {
  private val stack  = scala.collection.mutable.Stack.empty[(Int, Int)]
  def push(`val`: Int): Unit = {
    stack.headOption match {
      case Some((_, min)) => stack.push((`val`, math.min(min, `val`)))
      case None => stack.push((`val`, `val`))
    }
  }

  def pop(): Unit = {
    stack.pop()
  }

  def top(): Int = {
    stack.top._1
  }

  def getMin(): Int = {
    stack.top._2
  }
}

object MinStack {
  def main(args: Array[String]): Unit = {
    val minStack = new MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)

    println(minStack.getMin()) // returns -3
    minStack.pop()
    println(minStack.top()) // returns 0
    println(minStack.getMin()) // returns -2
  }
}
