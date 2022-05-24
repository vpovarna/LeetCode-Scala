package com.leetcode.easy

import com.leetcode.util.{ListNode, printListNode, reverseList}

object RemoveDuplicatesFromSortedLinkedList {

  // Time Complexity: O(N), Space complexity: 2 x O(M), where M is the number of unique numbers
  def deleteDuplicates(head: ListNode): ListNode = {
    val hashSet = collection.mutable.Set.empty[Int]
    var currentNode = head
    var result: ListNode = null

    while (currentNode != null) {
      if (! hashSet.contains(currentNode.x)) {
        hashSet.add(currentNode.x)
        result = new ListNode(currentNode.x, result)
      }
      currentNode = currentNode.next
    }

    reverseList(result)
  }


  // Without reverse
  def deleteDuplicatesV2(head: ListNode): ListNode = {
    val dummy = new ListNode(-2132, head)
    var (prev, curr) = (dummy, head)

    while (curr != null) {
      if (prev.x == curr.x) {
        prev.next = curr.next
      } else {
        prev = curr
      }
      curr = curr.next
    }

    dummy.next
  }

  def main(args: Array[String]): Unit = {
    printListNode(deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))))
  }

}
