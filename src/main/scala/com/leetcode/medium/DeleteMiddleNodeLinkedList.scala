package com.leetcode.medium

import com.leetcode.util.{ListNode, printListNode}

object DeleteMiddleNodeLinkedList {

  def deleteMiddle(head: ListNode): ListNode = {
    if (head.next == null) null
    else {
      var slow = head
      var fast = head
      var prev = head

      while (fast != null && fast.next != null) {
        prev = slow
        slow = slow.next
        fast = fast.next.next
      }
      prev.next = slow.next
      head
    }
  }

  def main(args: Array[String]): Unit = {
    printListNode(deleteMiddle(new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))))))
    printListNode(deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))))
    printListNode(deleteMiddle(new ListNode(2, new ListNode(1))))
  }

}
