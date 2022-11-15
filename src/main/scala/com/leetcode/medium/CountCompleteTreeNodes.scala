package com.leetcode.medium

object CountCompleteTreeNodes {
  def countNodes(root: TreeNode): Int = {
    if (root == null) 0
    else 1 + countNodes(root.left) + countNodes(root.right)
  }
}
