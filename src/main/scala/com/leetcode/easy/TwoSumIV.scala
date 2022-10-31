package com.leetcode.easy

import scala.collection.mutable.HashSet
import com.leetcode.util.TreeNode

object TwoSumIV {

  def findTarget(root: TreeNode, k: Int): Boolean = {
    var valuesSet: HashSet[Int] = scala.collection.mutable.HashSet.empty[Int]
    checkSum(root, valuesSet, k)
  }

  def checkSum(
      root: TreeNode,
      values: HashSet[Int],
      targetValue: Int
  ): Boolean = {
    if (root == null) false
    else if (values.contains(targetValue - root.value)) true
    else {
      values.add(root.value)
      checkSum(root.left, values, targetValue) || checkSum(
        root.right,
        values,
        targetValue
      )
    }
  }

  def main(args: Array[String]): Unit = {
    val node = new TreeNode(
      5,
      new TreeNode(6, new TreeNode(7)),
      new TreeNode(3, new TreeNode(4), new TreeNode(2))
    )

    println(findTarget(node, 9))
  }
}
