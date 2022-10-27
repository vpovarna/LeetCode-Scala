package com.leetcode.easy

import com.leetcode.util.TreeNode

object SubtreeOfAnotherTree {

  def isSubtree(root: TreeNode, subRoot: TreeNode): Boolean = {
    if (root == null) false
    else {
      if (isSameTree(root, subRoot)) true
      else
        isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }
  }

  def isSameTree(root: TreeNode, subRoot: TreeNode): Boolean = {
    if (root == null && subRoot == null) true
    else if (root == null || subRoot == null) false
    else if (root.value != subRoot.value) false
    else
      isSameTree(root.left, subRoot.left) && isSameTree(
        root.right,
        subRoot.right
      )
  }

  def main(args: Array[String]): Unit = {
    val parentTree = new TreeNode(
      3,
      new TreeNode(5),
      new TreeNode(4, new TreeNode(2), new TreeNode(1))
    )
    val subTree = new TreeNode(4, new TreeNode(2), new TreeNode(1))
    println(isSubtree(parentTree, subTree)) // true

    val parentTree1 = new TreeNode(
      3,
      new TreeNode(5),
      new TreeNode(4, new TreeNode(2, null, new TreeNode(0)), new TreeNode(1))
    )
    println(isSubtree(parentTree1, subTree)) // false
  }
}
