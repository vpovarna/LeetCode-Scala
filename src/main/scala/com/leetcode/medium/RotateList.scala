package com.leetcode.medium

import com.leetcode.util._

import scala.annotation.tailrec

object RotateList {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    if (head == null) head
    else if (head.next != null) {
      val myArray: Vector[Int] = buildArray(head).toVector
      val arrLength: Int = myArray.length
      println(myArray)
      val kk: Int = if (k > myArray.length) k % myArray.length else k
      println(kk)

      if (k == myArray.length) head
      else {
        val theArray = (0 until arrLength).map(x => {
          if (x + kk > arrLength - 1) {
            myArray(x + kk - arrLength)
          } else {
            myArray(x + kk)
          }
        })
        println(theArray)

        var theListNode = new ListNode(theArray(0), null)

        for (i <- 1 until theArray.length) {
          theListNode = new ListNode(theArray(i), theListNode)
        }

        theListNode
      }
    } else {
      head
    }
  }

  @tailrec
  private def buildArray(
      node: ListNode,
      acc: List[Int] = List.empty[Int]
  ): List[Int] = {
    if (node != null) buildArray(node.next, node.x :: acc)
    else acc
  }

  private def printListNodeValues(head: ListNode): Unit = {
    println()
    var tmpNode = head
    while (tmpNode != null) {
      print(tmpNode.x)
      tmpNode = tmpNode.next
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    val list1 =
      new ListNode(
        1,
        new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
      )
    printListNodeValues(rotateRight(list1, 2))

    val list2 = new ListNode(0, new ListNode(1, new ListNode(2)))
    printListNodeValues(rotateRight(list2, 4))

  }
}
