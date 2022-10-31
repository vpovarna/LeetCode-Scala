package com.leetcode

import scala.collection.mutable.ArrayBuffer

package object util {

  class ListNode(_x: Int, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  object ListNode {
    def apply(x: Int) = new ListNode(x)
  }

  def printListNode(listNode: ListNode): Unit = {
    var tmpListNode = listNode
    val tmpArray = ArrayBuffer[Int]()
    while (tmpListNode != null) {
      tmpArray += tmpListNode.x
      tmpListNode = tmpListNode.next
    }

    println(tmpArray.toArray.mkString("[", ", ", "]"))
  }

  def getListNodeSize(listNode: ListNode): Int = {
    var tmpListNode = listNode
    var length = 0
    while (tmpListNode != null) {
      length += 1
      tmpListNode = tmpListNode.next
    }
    length
  }

  def reverseList(listNode: ListNode): ListNode = {
    var tmpList: ListNode = listNode
    var result: ListNode = null

    while (tmpList != null) {
      val tmp = result
      result = new ListNode(tmpList.x, tmp)
      tmpList = tmpList.next
    }

    result
  }

  class TreeNode(_value: Int, _right: TreeNode = null, _left: TreeNode = null) {
    var value: Int = _value
    var right: TreeNode = _right
    var left: TreeNode = _left
  }

  class Node(_value: Int, _list: List[Node] = List()) {
    var value = _value
    var children: List[Node] = _list
  }

}
