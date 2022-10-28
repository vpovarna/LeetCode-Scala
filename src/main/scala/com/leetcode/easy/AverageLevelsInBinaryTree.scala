package com.leetcode.easy

import com.leetcode.util.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object AverageLevelsInBinaryTree {

  def averageOfLevels_v1(root: TreeNode): Array[Double] = {
    var queue = mutable.Queue.empty[TreeNode]
    val bufferArray = ArrayBuffer.empty[Double]

    queue.enqueue(root)

    while (queue.nonEmpty) {
      val tmpQueue = mutable.Queue.empty[TreeNode]

      var sum: Double = 0.0
      var count: Double = 0.0

      while (queue.nonEmpty) {
        val tmpNode = queue.dequeue()

        sum += tmpNode.value
        count += 1

        if (tmpNode.left != null) tmpQueue.enqueue(tmpNode.left)
        if (tmpNode.right != null) tmpQueue.enqueue(tmpNode.right)
      }
      val meanValue: Double = sum / count
      bufferArray.addOne(meanValue)
      queue = tmpQueue
    }

    bufferArray.toArray
  }

  // Using fold left
  def averageOfLevels_v2(root: TreeNode): Array[Double] = {
    val queue = mutable.Queue.empty[TreeNode]
    val arrayBuffer = ArrayBuffer.empty[Double]
    queue.enqueue(root)

    while (queue.nonEmpty) {
      val queueSize = queue.length

      val (sum, count) = (0 until queueSize).foldLeft((0.0, 0.0)) { (t, i) =>
        val (sum, count) = t
        val tmpNode = queue.dequeue()

        if (tmpNode.left != null) queue.enqueue(tmpNode.left)
        if (tmpNode.right != null) queue.enqueue(tmpNode.right)

        (sum + tmpNode.value, count + 1)
      }
      arrayBuffer.addOne(sum / count)
    }

    arrayBuffer.toArray

  }

  def main(args: Array[String]): Unit = {
    val treeNode = new TreeNode(
      3,
      new TreeNode(20, new TreeNode(7), new TreeNode(15)),
      new TreeNode(9)
    )
    println(averageOfLevels_v1(treeNode).toList)
    println(averageOfLevels_v2(treeNode).toList)
  }

}
