package com.leetcode.easy

import com.leetcode.util.TreeNode

import scala.collection.mutable.ArrayBuffer

object SymmetricTree {
  val dp: ArrayBuffer[Int] = ArrayBuffer.empty[Int]

  def isSymmetric(root: TreeNode): Boolean = {
    isMirrored(root, root)
  }

  def isMirrored(t1: TreeNode, t2: TreeNode): Boolean = {
    if (t1 == null && t2 == null)  true
    else if (t1 == null || t2 == null)  false
    else (t1.value == t2.value) && isMirrored(t1.left, t2.right) && isMirrored(t1.right, t2.left)
  }

  def main(args: Array[String]): Unit = {
    println(isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))))
  }


}
