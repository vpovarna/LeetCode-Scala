package com.leetcode.easy

import com.leetcode.util.{ListNode, printListNode}

object ReverseLinkedList {

  def reverseList(head: ListNode): ListNode = {
    if (head == null) head
    else {
      var newListNode: ListNode = null
      var tmpListNode = head

      while (tmpListNode != null) {
        newListNode = new ListNode(tmpListNode.x, newListNode)
        tmpListNode = tmpListNode.next
      }
      newListNode
    }
  }

  def main(args: Array[String]): Unit = {
    printListNode(reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))))
    printListNode(reverseList(new ListNode(1, new ListNode(2))))
  }

}
