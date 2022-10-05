package com.leetcode.easy

import com.leetcode.util.TreeNode

object MergeTwoBinaryTrees {

  def mergeTrees(root1: TreeNode, root2: TreeNode): TreeNode = {
    if (root1 == null) root2
    else if (root2 == null) root1
    else {
      root1.value += root2.value
      root1.left = mergeTrees(root1.left, root2.left)
      root1.right = mergeTrees(root1.right, root2.right)
      root1
    }
  }

  def main(args: Array[String]): Unit = {

  }
}
