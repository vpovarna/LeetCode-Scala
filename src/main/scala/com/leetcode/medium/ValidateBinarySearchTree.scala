package com.leetcode.medium

object ValidateBinarySearchTree {

  def isValidBST(root: TreeNode): Boolean = {
    def dfs(node: TreeNode, min: Long, max: Long): Boolean = {
      if (node == null) true
      else if (node.value < min || node.value > max) false
      else dfs(node.left, min, node.value -1L) && dfs(node.right, node.value + 1L, max)
    }

    dfs(root, Int.MinValue, Int.MaxValue)
  }

}
