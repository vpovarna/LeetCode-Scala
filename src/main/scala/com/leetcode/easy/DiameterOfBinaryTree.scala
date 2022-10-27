package com.leetcode.easy

import com.leetcode.util.TreeNode

import scala.collection.mutable.ArrayBuffer

object DiameterOfBinaryTree {
  def diameterOfBinaryTree(root: TreeNode): Int = {
    var distance: Int = 0

    def maxDiameter(root: TreeNode): Int = {
      if (root == null) 0
      else {
        val l = maxDiameter(root.left)
        val r = maxDiameter(root.right)
        distance = math.max(distance, l + r)
        scala.math.max(l, r) + 1
      }
    }
    maxDiameter(root)
    distance
  }

  def main(args: Array[String]): Unit = {
    val treeNode = new TreeNode(
      1,
      new TreeNode(3),
      new TreeNode(2, new TreeNode(5), new TreeNode(4))
    )
    println(diameterOfBinaryTree(treeNode))

    val treeNode2 = new TreeNode(1, new TreeNode(2))
    println(diameterOfBinaryTree(treeNode2))

  }

}
