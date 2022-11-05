package com.leetcode.medium

import com.leetcode.util.{ListNode, printListNode}

object ReverseLinkedListII {
  def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
    if (head == null) null
    else {
      var newHead = head
      var cur: ListNode = head
      var prev: ListNode = null
      var l = left
      var r = right

      while (l > 1) {
        prev = cur
        cur = cur.next
        l -= 1
        r -= 1
      }

      var tail: ListNode = cur
      var con: ListNode = prev

      var dummy: ListNode = null
      while (r > 0) {
        dummy = cur.next
        cur.next = prev
        prev = cur
        cur = dummy
        r -= 1
      }

      if (con != null) {
        con.next = prev
      } else {
        newHead = prev
      }

      tail.next = cur

      newHead
    }
  }

  def main(args: Array[String]): Unit = {
    val node = new ListNode(
      1,
      new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
    )
    printListNode(reverseBetween(node, 2, 4))
  }
}
