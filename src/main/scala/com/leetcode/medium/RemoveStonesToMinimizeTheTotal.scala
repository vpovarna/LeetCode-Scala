package com.leetcode.medium

import scala.collection.mutable

object RemoveStonesToMinimizeTheTotal {

  def minStoneSum(piles: Array[Int], k: Int): Int = {

    val heap = mutable.PriorityQueue[Int]()((x,y) => x - y)
    piles.foreach(n => heap.addOne(n))

    var r = piles.sum

    for (_ <- 0 until k) {
      val max = heap.dequeue()
      val take = max / 2
      if (take == 0) {
        return r
      } else {
        r -= take
        heap.enqueue(max - take)
      }
    }
    r
  }

  def main(args: Array[String]): Unit = {
    println(minStoneSum(Array(5,4,9), 2))
  }

}
