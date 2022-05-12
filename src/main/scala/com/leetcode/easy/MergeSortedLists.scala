package com.leetcode.easy

import com.leetcode.util.{ListNode, printListNode}

object MergeSortedLists {

  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    var mergedListNode: ListNode = null
    var list1Pointer = list1
    var list2Pointer = list2

    while (list1Pointer != null || list2Pointer != null) {
      if (list1Pointer == null && list2Pointer != null) {
        mergedListNode = new ListNode(list2Pointer.x, mergedListNode)
        list2Pointer = list2Pointer.next
      } else if (list1Pointer != null && list2Pointer == null) {
        mergedListNode = new ListNode(list1Pointer.x, mergedListNode)
        list1Pointer = list1Pointer.next
      } else if (list1Pointer.x < list2Pointer.x) {
        mergedListNode = new ListNode(list1Pointer.x, mergedListNode)
        list1Pointer = list1Pointer.next
      } else if (list2Pointer.x < list1Pointer.x) {
        mergedListNode = new ListNode(list2Pointer.x, mergedListNode)
        list2Pointer = list2Pointer.next
      } else {
        mergedListNode = new ListNode(list1Pointer.x, mergedListNode)
        mergedListNode = new ListNode(list2Pointer.x, mergedListNode)
        list1Pointer = list1Pointer.next
        list2Pointer = list2Pointer.next
      }
    }
    ReverseLinkedList.reverseList(mergedListNode)
  }

  def main(args: Array[String]): Unit = {
    printListNode(mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4, null))), new ListNode(1, new ListNode(3, new ListNode(4, null)))))
    printListNode(mergeTwoLists(null, ListNode(0)))
  }

}
