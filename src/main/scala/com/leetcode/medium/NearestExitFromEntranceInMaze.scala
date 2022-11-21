package com.leetcode.medium

import scala.collection.mutable

object NearestExitFromEntranceInMaze {

  def nearestExit(maze: Array[Array[Char]], entrance: Array[Int]): Int = {
    val directions = List((0, 1), (0, -1), (1, 0), (-1, 0))
    val queue = mutable.ArrayDeque.empty[(Int, Int)]

    val rows = maze.length
    val collumns = maze(0).length
    val visited = Array.fill(rows)(Array.fill(collumns)(false))

    queue.addOne((entrance(0), entrance(1)))
    visited(entrance(0))(entrance(1)) = true

    var steps = 0

    while (queue.nonEmpty) {
      val queueSize = queue.size
      steps += 1
      (0 until queueSize).foreach { _ =>
        val (x, y) = queue.removeHead()
        directions.foreach { direction => {
          val newX = direction._1 + x
          val newY = direction._2 + y

          if (newX<0||newX>=rows||newY<0||newY>=collumns) ()
          else if (visited(newX)(newY) || maze(newX)(newY) == '+') ()
          else if (newX == 0 || newX == rows - 1 || newY == collumns - 1 || newY == 0) return steps
          else {
            queue.addOne((newX, newY))
            visited(newX)(newY) = true
          }
          }
        }
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val maze1 = Array(Array('+', '+', '.', '+'), Array('.', '.', '.', '+'), Array('+', '+', '+', '.'))
    println(nearestExit(maze1, Array(1,2)))

    val maze2 = Array(Array('+', '+', '+'), Array('.', '.', '.'), Array('+', '+', '+'))
    println(nearestExit(maze2, Array(1,0)))

    val maze3 = Array(Array('.', '+'))
    println(nearestExit(maze3, Array(0, 0)))
  }
}
