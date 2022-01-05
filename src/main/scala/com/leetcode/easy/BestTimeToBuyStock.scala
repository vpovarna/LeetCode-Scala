package com.leetcode.easy

import scala.annotation.tailrec

object BestTimeToBuyStock extends App {
  def maxProfit(prices: Array[Int]): Int = {
    maxProfitRecursive(prices, 0, Integer.MAX_VALUE)
  }

  @tailrec
  def maxProfitRecursive(prices: Array[Int], maxProfit: Int, minPrice: Int): Int = {
    if (prices.isEmpty) maxProfit
    else if (prices.head < minPrice) {
      val newMinValue: Int = prices.head
      maxProfitRecursive(prices.tail, maxProfit, newMinValue)
    }
    else if (prices.head - minPrice > maxProfit) {
      val newMaxProfit: Int = prices.head - minPrice
      maxProfitRecursive(prices.tail, newMaxProfit, minPrice)
    }
    else {
      maxProfitRecursive(prices.tail, maxProfit, minPrice)
    }
  }

  def mutableMaxProfit(prices: Array[Int]): Int = {
    var profit = 0
    var minPrice = Integer.MAX_VALUE

    prices.foreach { price =>
      if (price < minPrice) minPrice = price
      else if (price > minPrice) profit =
        if (price - minPrice > profit) price - minPrice
        else profit
    }

    profit
  }

  println(maxProfit(Array(7, 1, 5, 3, 6, 4)))
  println(maxProfit(Array(7, 6, 4, 3, 1)))
  println(maxProfit(Array(7)))
  println(maxProfit(Array(1, 2)))
  println(maxProfit(Array(1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9)))
}
