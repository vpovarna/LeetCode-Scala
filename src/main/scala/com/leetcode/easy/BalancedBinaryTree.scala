package com.leetcode.easy

import com.leetcode.util.TreeNode

object BalancedBinaryTree {

  def isBalanced(root: TreeNode): Boolean = {
    if (root == null) true
    else {
      val isTreeBalanced = isBalanced(root.left) && isBalanced(root.right)
      val l = calculateMaxDepth(root.left: TreeNode)
      val r = calculateMaxDepth(root.right: TreeNode)
      // Condition
      (Math.abs(l - r) <= 1) && isTreeBalanced
    }
  }

  def calculateMaxDepth(root: TreeNode): Int = {
    if (root == null) 0
    else {
      val leftBinaryTreeDepth = calculateMaxDepth(root.left)
      val rightBinaryTreeDepth = calculateMaxDepth(root.right)
      Math.max(leftBinaryTreeDepth, rightBinaryTreeDepth) + 1
    }
  }

  def main(args: Array[String]): Unit = {
    val tree_v1 = new TreeNode(
      3,
      new TreeNode(20, new TreeNode(15), new TreeNode(7)),
      new TreeNode(9)
    )
    println(isBalanced(tree_v1)) // true

    val tree_v2 = new TreeNode(
      1,
      new TreeNode(2, new TreeNode(3), new TreeNode(3, new TreeNode(4), new TreeNode(4))),
      new TreeNode(2)
    )
    println(isBalanced(tree_v2)) // false

  }
}
