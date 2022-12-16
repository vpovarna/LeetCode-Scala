package com.leetcode.easy

class ImplementQueueUsingStacks() {

  private val s1 = scala.collection.mutable.Stack.empty[Int]
  private val s2 = scala.collection.mutable.Stack.empty[Int]

  def push(x: Int): Unit = s1.push(x)

  def pop(): Int = {
    if (s2.nonEmpty) s2.pop
    else if (s1.isEmpty) -1
    else {
      move()
      s2.pop
    }
  }

  def peek(): Int = {
    if (s2.nonEmpty) s2.top
    else if (s1.isEmpty) -1
    else {
      move()
      s2.top
    }
  }

  def size(): Int = s1.size + s2.size

  def empty(): Boolean = s1.isEmpty && s2.isEmpty

  private def move(): Unit = {
    while (s1.nonEmpty) {
      s2.push(s1.pop)
    }
  }
}
