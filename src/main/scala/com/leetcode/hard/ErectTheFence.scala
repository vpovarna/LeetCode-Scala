package com.leetcode.hard

import scala.annotation.tailrec
import scala.collection.mutable

object ErectTheFence {

  final case class Point(x: Int, y: Int)

  def crossProduct(p1: Array[Int], p2: Array[Int], p3: Array[Int]): Int = {
    // V1 = (a,b) ; V2=(c,d)
    // V1 x V2 = (a*d, b*c)
    val a = p2(0) - p1(0)
    val b = p2(1) - p1(1)
    val c = p3(0) - p1(0)
    val d = p3(1) - p1(1)
    a * d - b * c
  }

  def constructHalHalf(points: Array[Array[Int]]): mutable.ArrayDeque[Array[Int]] = {
    val stack = mutable.ArrayDeque.empty[Array[Int]]
    points.foldLeft(stack) { (stack, p) =>
      @tailrec
      // while loop using tailrec
      def cleanupStack(stack: mutable.ArrayDeque[Array[Int]]): mutable.ArrayDeque[Array[Int]] = {
        if (stack.size >= 2 && crossProduct(stack(stack.size - 2), stack(stack.size - 1), p) > 0) {
          stack.removeLast()
          cleanupStack(stack)
        } else {
          stack
        }
      }
      cleanupStack(stack)
      stack.append(p)
    }
  }

  def outerTrees(trees: Array[Array[Int]]): Array[Array[Int]] = {
    val sortedTrees = trees.sortBy(arr => (arr.head, arr.last))

    val leftToRight = constructHalHalf(sortedTrees)
    val rightToLeft = constructHalHalf(sortedTrees.reverse)

    leftToRight.toSet.union(rightToLeft.toSet).toArray
  }

  def main(args: Array[String]): Unit = {
    val points1 = outerTrees(
      Array(
        Array(1, 1),
        Array(2, 2),
        Array(2, 0),
        Array(2, 4),
        Array(3, 3),
        Array(4, 2)
      )
    )
    outerTrees(points1).foreach(arr => println(arr.mkString("[", ", ", "]")))
    println("======")
    val points2 = outerTrees(Array(Array(1, 2), Array(2, 2), Array(4, 2)))
    outerTrees(points2).foreach(arr => println(arr.mkString("[", ", ", "]")))
  }
}
