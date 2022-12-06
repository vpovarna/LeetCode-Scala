package com.leetcode.medium

import com.leetcode.util.ListNode

object OddEvenLinkedList {
  def oddEvenList(head: ListNode): ListNode = {
    var tmpHead = head

    if (tmpHead == null) null
    else {
      val oddHead = new ListNode(0)
      var oddIt = oddHead
      val evenHead = new ListNode(0)
      var evenIt = evenHead

      while (tmpHead != null) {

        oddIt.next = tmpHead
        evenIt.next = tmpHead.next
        oddIt = oddIt.next
        evenIt = evenIt.next
        if (tmpHead.next != null) {
          tmpHead = tmpHead.next.next
        } else {
          tmpHead = null;
        }
      }

      oddIt.next = evenHead.next
      oddHead.next
    }
  }
}
