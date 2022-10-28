package com.leetcode.medium

import scala.collection.mutable.Queue

object BinaryTreeLevelOrderTraversalII {

  def levelOrderBottom(root: TreeNode): List[List[Int]] = {
    if (root == null) List()
    else {
      var accList: List[List[Int]] = List.empty[List[Int]]
      val queue: Queue[TreeNode] = Queue.empty[TreeNode]

      queue.enqueue(root)

      while (queue.nonEmpty) {
        val queueSize: Int = queue.size
        val levelValues: List[Int] =
          (0 until queueSize).foldLeft(List.empty[Int]) { (list, _) =>
            {
              val tmpNode: TreeNode = queue.dequeue()
              val tmpList: List[Int] = tmpNode.value +: list

              if (tmpNode.right != null) queue.enqueue(tmpNode.right)
              if (tmpNode.left != null) queue.enqueue(tmpNode.left)

              tmpList
            }
          }
        accList = levelValues +: accList
      }

      accList
    }
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(
      3,
      new TreeNode(9),
      new TreeNode(20, new TreeNode(15), new TreeNode(7))
    )
    println(levelOrderBottom(root))
  }

}
