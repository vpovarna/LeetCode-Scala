package com.leetcode.easy

import com.leetcode.util.Node

object NTreePreorderTraversal {

  def preorder(root: Node): List[Int] = {
    if (root == null) List.empty[Int]
    else List(root.value) ++ root.children.flatMap(node => preorder(node))
  }

  def main(args: Array[String]): Unit = {
    val node = new Node(
      1,
      List(
        new Node(3, List(new Node(5), new Node(6))),
        new Node(2),
        new Node(4)
      )
    )
    println(preorder(node))
  }
}
