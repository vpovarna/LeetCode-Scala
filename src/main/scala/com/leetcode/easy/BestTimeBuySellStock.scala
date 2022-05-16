package com.leetcode.easy

object BestTimeBuySellStock {

  def maxProfit(prices: Array[Int]): Int = {
    var minValue = Integer.MAX_VALUE
    var maxProfit = 0

    for (i <- prices.indices) {
      if (prices(i) < minValue) {
        minValue = prices(i)
      } else if (prices(i) - minValue > maxProfit) {
        maxProfit = prices(i) - minValue
      }
    }

    maxProfit
  }

  def maxProfitFp(prices: Array[Int]): Int = {
    prices.indices.foldLeft((Integer.MAX_VALUE, 0)) {
      case ((minValue, maxProfit), i) =>
        if (prices(i) < minValue)
          (prices(i), maxProfit)
        else if (prices(i) - minValue > maxProfit)
          (minValue, prices(i) - minValue)
        else (minValue, maxProfit)
    }._2
  }

  def main(args: Array[String]): Unit = {
    println(maxProfitFp(Array(7, 1, 5, 3, 6, 4)))
  }

}
