package com.trees

import scala.annotation.tailrec

class PathSumProblem {

  // Return true if there is path from root to a leaf, such that the sum of values is equal to target
  def hasPathSum(tree: BTree[Int], target: Int): Boolean = {

    // Stack Recursion version
    @tailrec
    def hasPathSumStack(tree: BTree[Int], target: Int): Boolean = {
      if (tree.isEmpty) target == 0
      else if (tree.isLeaf) target == tree.value
      else if (tree.leftLeaf.isEmpty) hasPathSumStack(tree.rightLeaf, target - tree.value)
      else hasPathSum(tree.leftLeaf, target - tree.value)
    }

    hasPathSumStack(tree, target)
  }

}


