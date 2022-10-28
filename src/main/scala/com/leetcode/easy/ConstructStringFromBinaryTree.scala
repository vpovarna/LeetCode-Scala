package com.leetcode.easy

import com.leetcode.util.TreeNode

object ConstructStringFromBinaryTree {

  def tree2str(root: TreeNode): String = {
    val trim = raw"(\(\))+$$".r
    def helper(root: TreeNode): String = {
      root match {
        case null => "()"
        case r =>
          val lt = trim.replaceFirstIn(helper(r.left), "")
          val rt = trim.replaceFirstIn(helper(r.right), "")
          s"${r.value}($lt)($rt)"
      }
    }
    trim.replaceFirstIn(helper(root), "")
  }

  def main(args: Array[String]): Unit = {
    val treeNode =
      new TreeNode(1, new TreeNode(3), new TreeNode(2, null, new TreeNode(4)))
    println(tree2str(treeNode))
  }
}
