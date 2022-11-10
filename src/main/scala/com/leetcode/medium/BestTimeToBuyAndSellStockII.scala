package com.leetcode.medium

object BestTimeToBuyAndSellStockII {

  def maxProfit(prices: Array[Int]): Int = {
    var profit = 0
    for (i <- (1 until prices.length)) {
      if (prices(i) > prices(i - 1)) {
        profit += (prices(i) - prices(i - 1))
      }
    }

    profit
  }

  def maxProfitFp(prices: Array[Int]): Int = {
    (1 until prices.length).foldLeft(0) { (profit, i) =>
      if (prices(i) > prices(i - 1)) profit + (prices(i) - prices(i - 1))
      else profit
    }
  }

  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(7, 1, 5, 3, 6, 4))) // 7
    println(maxProfit(Array(7, 6, 5, 4, 3, 2))) // 0
  }

}
