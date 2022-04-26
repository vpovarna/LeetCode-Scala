package com.leetcode.medium

import com.leetcode.util.{ListNode, printListNode}

object SwapNodesInPairs {

  def swapPairs(head: ListNode): ListNode = {
    if (head == null) null
    else if (head.next == null) head
    else {
      val dummy = new ListNode(0, head)
      var prev = dummy
      var curr = head

      while (curr != null && curr.next != null) {
        val node1 = curr.next.next
        val node2 = curr.next

        // reverse this pair
        node2.next = curr
        curr.next = node1
        prev.next = node2

        prev = curr
        curr = node1
      }
      dummy.next
    }
  }

  def swapPairsRecursion(head: ListNode): ListNode = {
    if (head == null || head.next == null) head
    else new ListNode(head.next.x, new ListNode(head.x, swapPairsRecursion(head.next.next)))
  }

  def main(args: Array[String]): Unit = {
    printListNode(swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))))))
  }

}
