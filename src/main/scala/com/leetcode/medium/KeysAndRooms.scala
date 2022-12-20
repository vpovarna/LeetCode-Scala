package com.leetcode.medium

object KeysAndRooms {
  def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
    val visited: Array[Boolean] = Array.fill(rooms.length)(false)
    val queue = scala.collection.mutable.Queue.empty[Int]
    queue.append(0)

    while (queue.nonEmpty) {
      val room: Int = queue.dequeue()
      visited(room) = true

      for (key <- rooms(room)) {
        if (!visited(key)) queue.append(key)
      }
    }

    rooms.indices forall visited
  }

  def main(args: Array[String]): Unit = {
    println(canVisitAllRooms(List(List(1, 3), List(3, 0, 1), List(2), List(0))))
    println(canVisitAllRooms(List(List(1), List(2), List(3), List())))
  }
}
