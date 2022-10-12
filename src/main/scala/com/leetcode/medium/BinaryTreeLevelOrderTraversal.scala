package com.leetcode.medium

import com.leetcode.util.TreeNode

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object BinaryTreeLevelOrderTraversal {

  // Breadth-first search algorithm. This is done with a queue. Time and memory complexity is O(N)
  def levelOrder(root: TreeNode): List[List[Int]] = {
    // variable for saving level results
    val result: ArrayBuffer[ArrayBuffer[Int]] = mutable.ArrayBuffer.empty[ArrayBuffer[Int]]

    // Temporary queue for saving nodes. Initializing the queue with the root node.
    val queue = mutable.Queue.empty[TreeNode]
    queue.append(root)

    while (queue.nonEmpty) {
      val queueLength = queue.size

      val levelList: ArrayBuffer[Int] =
        (0 until queueLength).foldLeft(ArrayBuffer.empty[Int]) { (list, _) =>
          val node: TreeNode = queue.dequeue()
          // For every TreeNode if it's not null add the value to queue and add the left / right nodes to the queue
          if (node != null) {
            queue.append(node.left)
            queue.append(node.right)
            list.addOne(node.value)
          } else list
        }

      if (levelList.nonEmpty)
        result.addOne(levelList)
    }

    result.map(_.toList).toList
  }

  def levelOrder_v2(root: TreeNode): List[List[Int]] = {
    @tailrec
    def levelOrderTailRec(queue: mutable.Queue[TreeNode], result: List[List[Int]]): List[List[Int]] = {
      if (queue.isEmpty) result
      else {
        val levelList = queue.indices
          .foldLeft(List.empty[Int]) { (list, _) =>
            val node: TreeNode = queue.dequeue()
            // For every TreeNode if it's not null add the value to queue and add the left / right nodes to the queue
            if (node != null) {
              queue.append(node.left)
              queue.append(node.right)
              list :+ node.value
            } else list
          }

        if (levelList.nonEmpty) levelOrderTailRec(queue, result :+ levelList)
        else levelOrderTailRec(queue, result)
      }
    }

    val queue = mutable.Queue.empty[TreeNode]
    // initialize the queue with head
    queue.addOne(root)

    levelOrderTailRec(queue, List.empty[List[Int]])
  }


  def main(args: Array[String]): Unit = {
    val testTreeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))
    println(BinaryTreeLevelOrderTraversal.levelOrder(testTreeNode))
    println(BinaryTreeLevelOrderTraversal.levelOrder_v2(testTreeNode))
  }

}
