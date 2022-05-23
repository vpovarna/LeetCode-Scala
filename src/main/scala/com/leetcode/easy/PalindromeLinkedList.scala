package com.leetcode.easy

import com.leetcode.util.{ListNode, reverseList}

object PalindromeLinkedList {

  // Solution 1 with reversed linked list
  def isPalindrome(head: ListNode): Boolean = {
    var pointerA = head
    var reversedList = reverseList(head)

    while (pointerA != null && reversedList != null) {
      if (pointerA.x != reversedList.x) {
        return false
      }
      pointerA = pointerA.next
      reversedList = reversedList.next
    }

    true
  }

  // Solution 2 -> Using array
  def isPalindromeArr(head: ListNode): Boolean = {
    val arr = scala.collection.mutable.ArrayBuffer.empty[Int]
    var pointer = head
    while (pointer != null) {
      arr.addOne(pointer.x)
      pointer = pointer.next
    }

    var (i, j) = (0, arr.length - 1)
    while (i < j) {
      if (arr(i) != arr(j)) {
        return false
      }
      i += 1
      j -= 1
    }
    true
  }

  // Solution 3 -> Using pointers
  def isPalindromePointers(head: ListNode): Boolean = {
    var fast = head
    var slow = head

    // Find middle (slow pointer)
    while (fast != null && fast.next != null) {
      fast = fast.next.next
      slow = slow.next
    }

    // Reverse second half
    var prev: ListNode = null
    while (slow != null) {
      val tmp = slow.next
      slow.next = prev
      prev = slow
      slow =  tmp
    }

    // Check if it's a palindrome
    var (left: ListNode, right: ListNode) = (head, prev)
    while (right != null) {
      if (left.x != right.x) {
        return false
      }
      left = left.next
      right = right.next
    }

    true
  }

}
