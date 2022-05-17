package com.leetcode.easy

import com.leetcode.util.TreeNode

import scala.collection.mutable.ArrayBuffer

object BinaryTreeTraversal {

  // Inorder traversal = left, root, right
  def inorderTraversal(root: TreeNode): List[Int] = {
    val dp: ArrayBuffer[Int] = ArrayBuffer.empty[Int]

    def traversal(root: TreeNode): ArrayBuffer[Int] = {
      if (root == null) dp
      else {
        traversal(root.left)
        dp.addOne(root.value)
        traversal(root.right)
      }
    }

    traversal(root).toList
  }

  // one liner
  def inorderTraversalOneLine(root: TreeNode): List[Int] = {
    if (root == null) List()
    else preorderTraversal(root.left) ++ List(root.value) ++ preorderTraversal(root.right)
  }

  // Node -> Left -> Right
  def preorderTraversal(root: TreeNode): List[Int] = {
    val dp: ArrayBuffer[Int] = ArrayBuffer.empty[Int]

    def traversal(root: TreeNode): ArrayBuffer[Int] = {
      if (root == null) dp
      else {
        dp.addOne(root.value)
        traversal(root.left)
        traversal(root.right)
      }
    }

    traversal(root).toList
  }

  // one liner
  def preorderTraversalOneLine(root: TreeNode): List[Int] = {
    if (root == null) List()
    else List(root.value) ++ preorderTraversal(root.left) ++ preorderTraversal(root.right)
  }

  // Left -> Right -> Root
  def postorderTraversal(root: TreeNode): List[Int] = {
    val dp: ArrayBuffer[Int] = ArrayBuffer.empty[Int]

    def traversal(root: TreeNode): ArrayBuffer[Int] = {
      if (root == null) dp
      else {
        traversal(root.left)
        traversal(root.right)
        dp.addOne(root.value)
      }
    }

    traversal(root).toList
  }

  def postorderTraversalOneLine(root: TreeNode): List[Int] = {
    if (root == null) List()
    else postorderTraversalOneLine(root.left) ++ postorderTraversalOneLine(root.right) ++ List(root.value)
  }


  def main(args: Array[String]): Unit = {
    val tree = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)))

    println(inorderTraversal(tree))
    println(inorderTraversal(null))

    println(inorderTraversalOneLine(tree))
    println(inorderTraversalOneLine(null))

    println(preorderTraversal(tree))
    println(preorderTraversal(null))

    println(preorderTraversalOneLine(tree))
    println(preorderTraversalOneLine(null))

    println(postorderTraversal(tree))
    println(postorderTraversal(null))

    println(postorderTraversalOneLine(tree))
    println(postorderTraversalOneLine(null))
  }

}
