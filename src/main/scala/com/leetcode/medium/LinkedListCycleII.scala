package com.leetcode.medium

import com.leetcode.util.ListNode

object LinkedListCycleII {

  def detectCycle(head: ListNode): ListNode = {
    def getIntersect: Option[ListNode] = {
      var slow = head
      var fast = head

      while (fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next.next
        if (fast == slow) return Some(slow)
      }
      None
    }

    getIntersect match {
      case Some(node) =>
        var ptr1: ListNode = head
        var ptr2: ListNode = node

        while (ptr1 != ptr2) {
          ptr1 = ptr1.next
          ptr2 = ptr2.next
        }
        ptr1
      case None => null
    }
  }

  def getIntersect(head:ListNode): ListNode = {
    var slow = head
    var fast = head

    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
      if (fast == slow) return slow
    }
    null
  }

  def detectCycle_v2(head: ListNode): ListNode = {
    if (head == null || head.next == null) null
    else {
      val intersect = getIntersect(head)
      if (intersect == null) null
      else {
        var start = head
        var tmpNode = intersect

        while(start != tmpNode) {
          start = start.next
          tmpNode = tmpNode.next
        }
        tmpNode
      }
    }
  }

}
