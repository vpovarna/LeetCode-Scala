package com.leetcode.hard

import com.leetcode.util.{ListNode, printListNode, reverseList}

object MergeSortedLists {

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    if (lists == null || lists.length == 0) null
    else {
      var tmpList: Array[ListNode] = lists
      while (tmpList.length != 1) {
        tmpList = tmpList.grouped(2).map((subList: Array[ListNode]) => mergeTwoListNodes(subList)).toArray
      }

      tmpList.head
    }
  }

  def mergeTwoListNodes(subList: Array[ListNode]): ListNode = {
    if (subList.length == 1) subList.head
    else {
      var mergedListNode: ListNode = null
      var list1Pointer = subList.head
      var list2Pointer = subList.last

      // TODO: Implement tail recursion.
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
      reverseList(mergedListNode)
    }
  }

  def main(args: Array[String]): Unit = {
    printListNode(mergeKLists(Array(
      new ListNode(1, new ListNode(4, new ListNode(5))),
      new ListNode(1, new ListNode(3, new ListNode(4))),
      new ListNode(2, new ListNode(6))
    )))
    printListNode(mergeKLists(null))
    printListNode(mergeKLists(Array.empty[ListNode]))
  }

}
