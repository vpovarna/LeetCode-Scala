package com.leetcode.medium

object BinaryTreeMaximumPathSum {

  def maxPathSum(root: TreeNode): Int = {
    var result = Integer.MIN_VALUE

    def postOrderTraversal(root: TreeNode): Int = {
      if (root == null) 0
      else {
        val sumLeft = postOrderTraversal(root.left)
        val sumRight = postOrderTraversal(root.right)
        val tmpMax = Math.max(sumLeft, sumRight)

        result = if (tmpMax > result) tmpMax
        else {
          if (root.value > root.value + Math.max(sumLeft, sumRight)) {
            root.value
          } else {
            root.value + Math.max(sumLeft, sumRight)
          }
        }
      }
      postOrderTraversal(root)
    }

    result
  }

}
