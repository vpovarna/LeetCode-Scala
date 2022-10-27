package com.leetcode.easy

import com.leetcode.util.TreeNode

object MinimumAbsoluteDifferenceInBST {

  def getMinimumDifference(root: TreeNode): Int = {
    val values = traverseTree(root)
    (0 until values.length - 1)
      .map(i => scala.math.abs(values(i) - values(i + 1)))
      .min
  }

  def traverseTree(root: TreeNode): List[Int] = {
    if (root == null) List.empty[Int]
    else traverseTree(root.left) ++ List(root.value) ++ traverseTree(root.right)
  }

  def main(args: Array[String]): Unit = {

    val treeNode = new TreeNode(
      4,
      new TreeNode(6),
      new TreeNode(2, new TreeNode((3)), new TreeNode(1))
    )

    println(getMinimumDifference(treeNode))
  }

}
