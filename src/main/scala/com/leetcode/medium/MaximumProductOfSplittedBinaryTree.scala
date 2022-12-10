package com.leetcode.medium

import com.leetcode.util.TreeNode

object MaximumProductOfSplittedBinaryTree {

  def maxProduct(root: TreeNode): Int = {
    val totalSum = subTreeSum(root)

    def maxProductRecursive(node: TreeNode): Long = {
      if (node == null) 0
      else {
        List(
          node.value.toLong * (totalSum - node.value),
          maxProductRecursive(node.left),
          maxProductRecursive(node.right)
        ).max
      }
    }
    (maxProductRecursive(root) % 1000000007).toInt
  }

  def subTreeSum(root: TreeNode): Int = {
    if (root == null) 0
    else
      root.value + subTreeSum(root.left) + subTreeSum(root.right)
  }


  // simpler method
  def maxProduct_v2(root: TreeNode): Int = {
    val sums = collection.mutable.ArrayBuffer.empty[Long]
    def helper(node: TreeNode): Long = {
      if (node == null) 0
      else {
        val leftSum: Long = helper(node.left);
        val rightSum: Long = helper(node.right)
        val sum = leftSum + rightSum + node.value
        sums.addOne(sum)
        sum
      }
    }

    val total = helper(root)

    val max: Long = sums.foldLeft(0L) { (max, s) =>
      val p = s * (total - s)
      Math.max(p, max)
    }

    (max % 1000000007).toInt
  }

  def main(args: Array[String]): Unit = {
    val tree = new TreeNode(
      1,
      new TreeNode(3, null, new TreeNode(6)),
      new TreeNode(2, new TreeNode(5), new TreeNode(4))
    )

    println(maxProduct(tree))

    val tree2 = new TreeNode(
      1,
      new TreeNode(
        2,
        new TreeNode(4, new TreeNode(6), new TreeNode(5)),
        new TreeNode(3)
      )
    )

    println(maxProduct(tree2))
  }

}
