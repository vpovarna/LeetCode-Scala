package com.leetcode.easy

import com.leetcode.util.TreeNode

object SameTree {

  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) true
    else if (p == null || q == null) false
    else if (p.value != q.value) false
    else isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
  }

  def main(args: Array[String]): Unit = {
    println(isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(3))))
    println(isSameTree(new TreeNode(1, new TreeNode(2), null), new TreeNode(1, null, new TreeNode(3))))
    println(isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(1)), new TreeNode(1, new TreeNode(1), new TreeNode(2))))
  }

}
