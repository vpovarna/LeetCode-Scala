package com.leetcode.easy

import com.leetcode.util.TreeNode

object MaximumDepthBinaryTree {
  def maxDepth(root: TreeNode): Int = {
    if (root == null) 0
    else {
      val leftBinaryTreeDepth = maxDepth(root.left)
      val rightBinaryTreeDepth = maxDepth(root.right)
      Math.max(leftBinaryTreeDepth, rightBinaryTreeDepth) + 1
    }
  }

  def minDepth(root: TreeNode): Int = {

    def loop(root: TreeNode): Int = {
      if (root == null) Int.MaxValue
      else if (root.left == null && root.right == null) 1
      else {
        val leftBinaryTreeDepth = loop(root.left)
        val rightBinaryTreeDepth = loop(root.right)
        Math.min(leftBinaryTreeDepth, rightBinaryTreeDepth) + 1
      }
    }

    if (root == null) 0 else loop(root)
  }

  def main(args: Array[String]): Unit = {
    println(maxDepth(new TreeNode(1, null, new TreeNode(2))))
    println(maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))))
    println(minDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))))
  }
}
