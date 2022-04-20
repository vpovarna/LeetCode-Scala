package com.leetcode.medium

import com.leetcode.util.{ListNode, getListNodeSize, printListNode, reverseList}

object RemoveNthNodeFromEndOfList {

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val listNodeSize: Int = getListNodeSize(head)

    if (n > listNodeSize) head
    else {
      var tmpListNode = head
      var i: Int = 0
      var resultListNode: ListNode = null

      while (tmpListNode != null) {
        if (i != listNodeSize - n) {
          val listTmp: ListNode = resultListNode
          resultListNode = new ListNode(tmpListNode.x, listTmp)
        }
        i += 1
        tmpListNode = tmpListNode.next
      }
      reverseList(resultListNode)
    }
  }

  def main(args: Array[String]): Unit = {
    val listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
    printListNode(removeNthFromEnd(listNode1, 2))
    val listNode2 = new ListNode(1, null)
    printListNode(removeNthFromEnd(listNode2, 1))
    val listNode3 = new ListNode(1, new ListNode(2))
    printListNode(removeNthFromEnd(listNode3, 1))
  }

}
