package com.leetcode.easy

object ConcertSortedArrayToBinarySearchTree {

  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    if (nums.length == 0) null
    else constructTreeFromArray(nums, 0, nums.length - 1)
  }

  def constructTreeFromArray(nums: Array[Int], left: Int, right: Int): TreeNode = {
    if (left > right) null
    else {
      val midPoint = left + (right - left) / 2
      val node = new TreeNode(nums(midPoint))
      node.left = constructTreeFromArray(nums, left, midPoint - 1)
      node.right = constructTreeFromArray(nums, midPoint + 1, right)
      node
    }
  }

  def main(args: Array[String]): Unit = {
    val node = sortedArrayToBST(Array(-10, -3, 0, 9, 5))
    println(node.value)
  }

  class TreeNode(_value: Int, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }
}
