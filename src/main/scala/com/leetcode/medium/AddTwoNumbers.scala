package com.leetcode.medium

import com.leetcode.util.ListNode

object AddTwoNumbers {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

    def add(l1: ListNode, l2: ListNode, carryDigit: Int = 0): ListNode = {
      val sum: Int = (if (l1 == null) 0 else l1.x) +
        (if (l2 == null) 0 else l2.x) +
        carryDigit

      val current: ListNode = new ListNode(sum % 10)

      if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || sum >= 10)
        current.next = add(
          l1 = if (l1 != null && l1.next != null) l1.next else null,
          l2 = if (l2 != null && l2.next != null) l2.next else null,
          carryDigit = if (sum >= 10) 1 else 0)

      current
    }

    add(l1, l2)
  }


  def main(args: Array[String]): Unit = {
    val l1 = new ListNode(2, new ListNode(4, new ListNode(3)))
    val l2 = new ListNode(5, new ListNode(6, new ListNode(4)))

    val l = addTwoNumbers(l1, l2)
    println(s"${l.x} - ${l.next.x} - ${l.next.next.x}")

  }
}
