package com.leetcode.easy

import com.leetcode.util.TreeNode

object LeafSimilarTrees {

  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {

    def leafTreeTraverse(treeNode: TreeNode): List[Int] = {
      if (treeNode == null) Nil
      else {
        val tmpList =
          if (treeNode.right == null && treeNode.left == null)
            List(treeNode.value)
          else Nil

        leafTreeTraverse(treeNode.left) ++ tmpList ++ leafTreeTraverse(
          treeNode.right
        )
      }
    }

    leafTreeTraverse(root1) == leafTreeTraverse(root2)
  }

  def main(args: Array[String]): Unit = {
    val treeNode1 = new TreeNode(
      3,
      new TreeNode(1, new TreeNode(8), new TreeNode(9)),
      new TreeNode(
        5,
        new TreeNode(2, new TreeNode(4), new TreeNode(7)),
        new TreeNode(6)
      )
    )

    val treeNode2 = new TreeNode(
      3,
      new TreeNode(
        1,
        new TreeNode(2, new TreeNode(8), new TreeNode(9)),
        new TreeNode(4)
      ),
      new TreeNode(5, new TreeNode(7), new TreeNode(6))
    )

    println(leafSimilar(treeNode1, treeNode2))
  }
}
