package com.leetcode.medium

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object BinaryTreeZigzagLevelOrderTraversal {

  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    val resultList: ArrayBuffer[ArrayBuffer[Int]] = ArrayBuffer.empty[ArrayBuffer[Int]]
    val queue = mutable.Queue.empty[TreeNode]
    var level = 0

    queue.append(root)

    while (queue.nonEmpty) {
      val queueLength = queue.length

      val levelList = (0 until queueLength).foldLeft(ArrayBuffer.empty[Int]) { (tmpList, _) =>
        val node = queue.dequeue()
        val someNode = Option(node)
        someNode.map(node => queue.enqueue(node.left))
        someNode.map(node => queue.enqueue(node.right))
        someNode.map(node => tmpList.addOne(node.value))
        tmpList
      }

      if (level % 2 != 0) resultList.addOne(levelList.reverse) else resultList.addOne(levelList)
      level = level + 1
    }

    resultList.filter(_.nonEmpty).map(_.toList).toList
  }

  def main(args: Array[String]): Unit = {
    val testTree1 = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15, TreeNode(10), TreeNode(22)), TreeNode(7)))
    val testTree2 = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))
    println(zigzagLevelOrder(testTree1))
    println(zigzagLevelOrder(testTree2))
  }

}

case class TreeNode(_value: Int, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
