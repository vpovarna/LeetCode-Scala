package com.leetcode.easy

import com.leetcode.util.{ListNode, printListNode, reverseList}

object RemoveLinkedListElements {

  def removeElements(head: ListNode, `val`: Int): ListNode = {
    val dummyHead = new ListNode(Int.MinValue)
    dummyHead.next = head

    var currentNode = dummyHead
    while (currentNode.next != null) {
      if (currentNode.next.x == `val`) currentNode.next = currentNode.next.next
      else currentNode = currentNode.next
    }

    dummyHead.next
  }

  def removeElementsRecursion(head: ListNode, `val`: Int): ListNode = {
    if (head == null) {
      return null
    }

    if (head.x != `val`) {
      head.next = removeElementsRecursion(head.next, `val`)
      head
    } else {
      removeElementsRecursion(head.next, `val`)
    }
  }

  def removeElementWhile(head: ListNode, `val`: Int): ListNode = {
    var tmpList: ListNode = null
    var currentNode = head

    while (currentNode != null) {
      if (currentNode.x != `val`) {
        tmpList = new ListNode(currentNode.x, tmpList)
      }
      currentNode = currentNode.next
    }

    reverseList(tmpList)
  }

  def main(args: Array[String]): Unit = {
    val listNode = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))))
    printListNode(removeElements(listNode, 6))
  }

}
