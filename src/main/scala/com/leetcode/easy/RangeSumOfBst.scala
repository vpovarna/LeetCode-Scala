package com.leetcode.easy

import com.leetcode.util.TreeNode

object RangeSumOfBst {
  def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
    def bstTraverse(tree: TreeNode): Int = {
      if (tree == null) 0
      else {
        val rangeValue =
          if (tree.value >= low && tree.value <= high) tree.value
          else 0
        bstTraverse(tree.left) + rangeValue + bstTraverse(tree.right)
      }
    }
    bstTraverse(root)
  }

  def main(args: Array[String]): Unit = {
    val tree = new TreeNode(
      10,
      new TreeNode(15, new TreeNode(18)),
      new TreeNode(5, new TreeNode(7), new TreeNode(3))
    )

    println(rangeSumBST(tree, 7, 15))
  }
}
