package com.leetcode.top100LikedQuestions

import scala.language.postfixOps

/**
 * @author Adobe Systems Incorporated.
 */
object BinaryTreeInorderTraversal extends App {

  def inorderTraversal(root: TreeNode): List[Int] = {
    if(root == null)  Nil
    else inorderTraversal(root.left) ::: List(root.value) ::: inorderTraversal(root.right)
  }

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }


}
