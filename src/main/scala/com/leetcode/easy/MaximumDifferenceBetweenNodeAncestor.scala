package com.leetcode.easy

import com.leetcode.util.TreeNode

object MaximumDifferenceBetweenNodeAncestor {

  def maxAncestorDiff(root: TreeNode): Int = {

    def dfs(root:TreeNode, max: Int, min: Int): Int  ={
      if (root == null) max - min
      else {
        val tmpMax = Math.max(root.value, max)
        val tmpMin = Math.min(root.value, min)
        Math.max(dfs(root.left, tmpMax, tmpMin), dfs(root.right, tmpMax, tmpMin))
      }
    }

    dfs(root, root.value, root.value)
  }
}
