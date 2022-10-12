package com.leetcode.medium

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object SortedListToBinarySearchTree {

  //  Using an Array
  def sortedListToBST(head: ListNode): TreeNode = {
    if (head == null) null
    else {
      val nums: Array[Int] = createIndexList(head)
      createTree(nums: Array[Int], 0, nums.length - 1)
    }
  }

  def createIndexList(head: ListNode): Array[Int] = {
    var tmpNode = head
    val list: ArrayBuffer[Int] = new ArrayBuffer[Int]()
    while (tmpNode != null) {
      list.addOne(tmpNode.x)
      tmpNode = tmpNode.next
    }
    list.toArray
  }

  def createTree(nums: Array[Int], left: Int, right: Int): TreeNode = {
    if (left > right) null
    else {
      val midElement = left + (right - left) / 2
      val node = new TreeNode(nums(midElement))
      node.left = createTree(nums, left, midElement - 1)
      node.right = createTree(nums, midElement + 1, right)
      node
    }
  }

  // Without Array
  def sortedListToBST_v2(head: ListNode): TreeNode = {
    val length: Int = getSizeOfLinkedList(head)

    var tmpNode = head

    def generateTree(left: Int, right: Int): TreeNode = {
      if (left > right) null
      else {
        val midPoint = left + (right - left) / 2
        // generate left tree
        val leftTree = generateTree(left, midPoint - 1)
        // creating root and move fw in the linked list
        val root = new TreeNode(tmpNode.x)
        tmpNode = tmpNode.next
        // assign left tree to root
        root.left = leftTree
        // generating right tree
        val rightTree = generateTree(midPoint + 1, right)
        root.right = rightTree
        // returning root
        root
      }
    }

    generateTree(0, length - 1)
  }

  def getSizeOfLinkedList(head: ListNode): Int = {
    var n = 0
    var currentNode = head
    while (currentNode != null) {
      currentNode = currentNode.next
      n += 1
    }
    n
  }

  def getSizeOfLinkedList_v2(head: ListNode): Int = {
    @tailrec
    def getSizeTailRec(remainingNode: ListNode, n: Int = 0): Int = {
      if (remainingNode == null) n
      else getSizeTailRec(remainingNode.next, n + 1)
    }
    getSizeTailRec(head)
  }

  def main(args: Array[String]): Unit = {
    val listNode = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9, null)))))
    println(sortedListToBST(listNode).value)
  }

  class ListNode(_x: Int, _next: ListNode = null) {
    var x: Int = _x
    var next: ListNode = _next
  }

  // TreeNode class
  class TreeNode(_value: Int, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

}
