package com.leetcode.easy

import com.leetcode.util.ListNode

import scala.collection.mutable.ArrayBuffer

object MiddleLinkedList {
  // Solution 1 with array
  def middleNode(head: ListNode): ListNode = {
    val values = ArrayBuffer.empty[Int]
    var pointer = head

    while (pointer != null) {
      values.addOne(pointer.x)
      pointer = pointer.next
    }
    val midNodeValue: Int = values.length / 2

    var currentNode = head
    var i = 0
    while (currentNode != null) {
      if (i == midNodeValue) {
        return currentNode
      }
      i += 1
      currentNode = currentNode.next
    }
    null
  }

  // Solution 2 with two pointers: fast & slow
  def middleNodeV2(head: ListNode): ListNode = {
    var (slow, fast) = (head, head)

    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }

    slow
  }

    def main(args: Array[String]): Unit = {
    val fistListNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
    println(middleNode(fistListNode))
    val secondListNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))
    println(middleNode(secondListNode))
  }
}
