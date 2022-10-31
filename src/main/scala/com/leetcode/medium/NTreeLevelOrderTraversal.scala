package com.leetcode.medium

import scala.collection.mutable
import com.leetcode.util.Node

object NTreeLevelOrderTraversal {

  def levelOrder(root: Node): List[List[Int]] = {
    val queue = mutable.Queue.empty[Node]
    val arrayBuffer: mutable.ArrayBuffer[List[Int]] =
      mutable.ArrayBuffer.empty[List[Int]]

    if (root == null) List()
    else {
      queue.append(root)

      while (queue.nonEmpty) {
        val queueSize = queue.size

        val levelList: List[Int] =
          (0 until queueSize).foldLeft(List.empty[Int]) { (accList, _) =>
            val node = queue.dequeue()

            if (node.children.nonEmpty)
              node.children.foreach(n => queue.enqueue(n))
            accList :+ node.value
          }
        arrayBuffer.addOne(levelList)

      }

      arrayBuffer.toList
    }
  }

  def main(args: Array[String]): Unit = {
    val node = new Node(
      1,
      List(
        new Node(3, List(new Node(5), new Node(6))),
        new Node(2),
        new Node(4)
      )
    )

    println(levelOrder(node))
  }

}
