package com.leetcode.easy

import com.leetcode.util.ListNode

object IntersectionOfTwoLinkedLists {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    if (headA == null || headB == null) null
    else {
      var a = headA
      var b = headB

      while (a != b) {
        a = if (a == null) headB else a.next
        b = if (b == null) headA else b.next
      }
      a
    }
  }
}
