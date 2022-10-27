package com.leetcode.easy

import com.leetcode.util.TreeNode

object BinaryTreePaths {

  def binaryTreePaths(root: TreeNode): List[String] = {
    getTreeNodeValues(root)
  }

  def getTreeNodeValues(
      root: TreeNode,
      list: List[String] = List.empty[String]
  ): List[String] = {
    if (root == null) List.empty[String]
    else if (root.left == null && root.right == null) {
      val tmpList = list :+ s"${root.value}"
      List(tmpList.mkString("->"))
    } else {
      val tmpList = list :+ s"${root.value}"
      getTreeNodeValues(root.left, tmpList) ++
        getTreeNodeValues(root.right, tmpList)
    }
  }

  def main(args: Array[String]): Unit = {
    val treeNode =
      new TreeNode(1, new TreeNode(3), new TreeNode(2, new TreeNode(5)))
    println(binaryTreePaths(treeNode))
  }

}
