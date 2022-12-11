package com.leetcode.hard

import com.leetcode.util.TreeNode

object BinaryTreeMaximumPathSum {
  def maxPathSum(root: TreeNode): Int = {
    var result = Integer.MIN_VALUE
    def getLP(node: TreeNode): Int = {
      if (node == null) 0
      else {
        val (left, right) = (getLP(node.left), getLP(node.right))
        result = Math.max(result, node.value + left + right)
        val tmpMaxRightLeft = Math.max(left, right)
        Math.max(node.value + tmpMaxRightLeft, 0)
      }
    }

    getLP(root)
    result
  }
}
