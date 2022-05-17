package com.leetcode.easy

import com.leetcode.util.TreeNode

object InvertBinaryTree {

  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) return root

    // Tree traversal: left --> right
    val leftTree = invertTree(root.left)
    val rightTree = invertTree(root.right)

    // Swapping
    root.right = leftTree
    root.left = rightTree

    root
  }

  def invertTreeSimpler(root: TreeNode): TreeNode = {
    if (root == null) null
    else {
      val tmp = root.left
      root.left = root.right
      root.right = tmp

      // DFS  traversal. Check left -> check right
      invertTreeSimpler(root.left)
      invertTreeSimpler(root.right)

      root
    }

  }

  def main(args: Array[String]): Unit = {

  }

}
