package com.leetcode.easy

import com.leetcode.util.TreeNode

object SumOfLeftLeaves {

  def sumOfLeftLeaves(root: TreeNode): Int = {
    getLeftValues(root, isLeft = false).sum
  }

  def getLeftValues(
      root: TreeNode,
      isLeft: Boolean,
      list: List[Int] = List.empty[Int]
  ): List[Int] = {
    if (root == null) List.empty[Int]
    else {
      if (root.isLeaf && isLeft) list :+ root.value
      else
        getLeftValues(root.left, isLeft = true, list) ++
          getLeftValues(root.right, isLeft = false, list)
    }
  }

  implicit class ReachTreeNode(node: TreeNode) {
    def isLeaf: Boolean =
      node.left == null & node.right == null
  }

  def main(args: Array[String]): Unit = {
    val treeNode = new TreeNode(
      3,
      new TreeNode(20, new TreeNode(7), new TreeNode(15)),
      new TreeNode(9)
    )
    println(sumOfLeftLeaves(treeNode))
  }

}
