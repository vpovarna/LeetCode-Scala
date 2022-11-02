package com.leetcode.easy

import com.leetcode.util.Node

import scala.collection.mutable

object MaximumDepthOfNTree {

  def maxDepth(root: Node): Int = {
    if (root == null) 0
    else {
      val tmpNode = root
      val queue = mutable.Queue.empty[(Node, Int)]
      queue.enqueue((tmpNode, 0))

      var longestPath = 0

      while (queue.nonEmpty) {
        val queueSize = queue.size

        (0 until queueSize).foreach { i =>
          {
            val (node, level) = queue.dequeue()
            if (node.children.nonEmpty)
              node.children.foreach(n => queue.enqueue((n, level + 1)))
            longestPath = Math.max(longestPath, level)
          }
        }
      }
      longestPath + 1
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

    println(maxDepth(node))
  }

}
