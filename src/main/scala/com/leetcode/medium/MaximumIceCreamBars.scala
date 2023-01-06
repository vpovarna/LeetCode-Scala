package com.leetcode.medium

object MaximumIceCreamBars {
  def maxIceCream(costs: Array[Int], coins: Int): Int = {
      @scala.annotation.tailrec
      def maxIceCreamTailRec(costs:Array[Int], remainingCoins: Int, count: Int = 0): Int = {
        if (costs.isEmpty) count
        else if (remainingCoins < 0) count
        else {
          val cost = costs.head
          if (remainingCoins - cost >= 0) maxIceCreamTailRec(costs.tail, remainingCoins - cost, count + 1)
          else maxIceCreamTailRec(costs.tail, remainingCoins - cost, count)
        }
      }
    maxIceCreamTailRec(costs.sorted, coins)
  }

  def main(args: Array[String]): Unit = {
    println(maxIceCream(Array(1,3,2,4,1), 7))
  }
}
