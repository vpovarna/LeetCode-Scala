package com.leetcode.easy

import com.leetcode.util.ListNode

object ConvertLinkedListToBinaryNumber {
  def getDecimalValue(head: ListNode): Int = {
    var result: Double = 0.0
    var count = getLinkedListSize(head)
    var t = head
    while (t != null) {
      result += scala.math.pow(2, count - 1) * t.x
      t = t.next
      count = count - 1
    }

    result.toInt
  }

  def getLinkedListSize(head: ListNode): Int = {
    var t = head
    var count = 0

    while (t != null) {
      count += 1
      t = t.next
    }
    count
  }
}
