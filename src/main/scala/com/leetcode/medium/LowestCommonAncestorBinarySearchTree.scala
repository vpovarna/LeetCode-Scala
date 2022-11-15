package com.leetcode.medium

import scala.annotation.tailrec

object LowestCommonAncestorBinarySearchTree {

  @tailrec
  def lowestCommonAncestor(
      root: TreeNode,
      p: TreeNode,
      q: TreeNode
  ): TreeNode = {
    val currentNode = root
    if (p.value < currentNode.value && q.value < currentNode.value) {
      lowestCommonAncestor(currentNode.left, p, q)
    } else if (p.value > currentNode.value && q.value > currentNode.value) {
      lowestCommonAncestor(currentNode.right, p, q)
    } else {
      currentNode
    }
  }

}
