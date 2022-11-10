package com.leetcode.medium

object BestTimeToBuyAndSellStockWithTransactionFee {

  def maxProfit(prices: Array[Int], fee: Int): Int = {
    var effectiveBuyPrice = prices(0)
    var profit = 0

    for (i <- (1 until prices.length)) {
      profit = math.max(profit, prices(i) - effectiveBuyPrice - fee)
      effectiveBuyPrice = math.min(effectiveBuyPrice, prices(i) - profit)
    }

    profit
  }

  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(1,3,2,8,4,9), 2)) //8
    println(maxProfit(Array(1,3,7,5,10,3), 3)) //6
  }
}
