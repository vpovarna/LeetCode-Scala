package com.leetcode.medium

object WhereWillTheBallFall {
  def findBall(grid: Array[Array[Int]]): Array[Int] = {
    val (m, n) = (grid.length, grid.head.length)

    val mem = scala.collection.mutable.Map.empty[(Int, Int), Int]

    def dfs(r: Int, c: Int): Int =
      mem.getOrElseUpdate(
        (r, c),
        if (r == m) c
        else if (grid(r)(c) == 1) {
          if (c == n - 1 || grid(r)(c + 1) == -1) -1
          else dfs(r + 1, c + 1)
        } else {
          if (c == 0 || grid(r)(c - 1) == 1) -1
          else dfs(r + 1, c - 1)
        }
      )

    (0 until n).map(c => dfs(r = 0, c)).toArray
  }

}
