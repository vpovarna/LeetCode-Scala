package com.leetcode.easy

import com.leetcode.util.ListNode

object LinkedListCycle {
  def hasCycle(head: ListNode): Boolean = {
    var currentNode = head
    val hashSet = scala.collection.mutable.HashSet.empty[ListNode]

    while (currentNode != null) {
      if (!hashSet.contains(currentNode)) {
        hashSet.add(currentNode)
        currentNode = currentNode.next
      } else {
        println("There is a cycle in the linked list, where the tail connects to the " + head.x + "th node")
        return true
      }
    }
    false
  }
}
