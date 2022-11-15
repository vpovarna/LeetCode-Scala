package com.leetcode.easy

import scala.collection.mutable

object FloodFill {

  // DFS -> without recursion
  def floodFill(
                 image: Array[Array[Int]],
                 sr: Int,
                 sc: Int,
                 color: Int
               ): Array[Array[Int]] = {
    if (image(sr)(sc) == color) image
    else {
      val rowNr = image.length;
      val columnNr = image(0).length

      val queue = mutable.Queue.empty[(Int, Int)]
      queue.addOne((sr, sc))
      val initialColor = image(sr)(sc)

      while (queue.nonEmpty) {
        val (x, y) = queue.dequeue()
        if (!(x < 0 || x >= rowNr || y < 0 || y >= columnNr || image(x)(y) != initialColor)) {
          val tmpArr = image(x)
          tmpArr.update(y, color)
          image.update(x, tmpArr)
          queue.enqueue((x - 1, y))
          queue.enqueue((x + 1, y))
          queue.enqueue((x, y - 1))
          queue.enqueue((x, y + 1))
        }
      }
      image
    }
  }

  // DFS - recursive
  def floodFill2(
      image: Array[Array[Int]],
      sr: Int,
      sc: Int,
      color: Int
  ): Array[Array[Int]] = {
    if (image(sr)(sc) == color) image
    else {
      fill(image, sr, sc, image(sr)(sc), color)
    }
  }

  def fill(
      image: Array[Array[Int]],
      sr: Int,
      sc: Int,
      color: Int,
      newColor: Int
  ): Array[Array[Int]] = {
    if (sr < 0 || sr >= image.length || sc < 0 || sc >= image(0).length || image(sr)(sc) != color) {
      image
    } else {
      val tmpArr = image(sr)
      tmpArr.update(sc, newColor)
      image.update(sr, tmpArr)
      fill(image, sr - 1, sc, color, newColor)
      fill(image, sr + 1, sc, color, newColor)
      fill(image, sr, sc - 1, color, newColor)
      fill(image, sr, sc + 1, color, newColor)
    }
  }

  final case class GridPosition(x: Int, y: Int)

  def main(args: Array[String]): Unit = {
    val grid = Array(Array(1, 1, 1), Array(1, 1, 0), Array(1, 0, 1))
    println(floodFill(grid, 1, 1, 2).toList.map(_.toList))

    val grid2 = Array(Array(0, 0, 0), Array(0, 0, 0))
    println(floodFill(grid2, 0, 2, 2).toList.map(_.toList))
  }

}
