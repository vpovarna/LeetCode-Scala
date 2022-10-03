package com.leetcode.easy

import com.leetcode.util.TreeNode

object PathSum {
  def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
    // empty tree case
    if (root == null) {
      return false
    }

    // leaf node
    if (root.left == null && root.right == null) {
      return root.value == targetSum
    }

    val removeElement = targetSum - root.value
    hasPathSum(root.left, removeElement) || hasPathSum(root.right, removeElement)
  }
}
