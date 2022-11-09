package com.leetcode.medium

import scala.collection.mutable

object OnlineStockSpan {

  val prevPrices: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer.empty[Int]

  // brute force
  def next(price: Int): Int = {
    var span = 1
    if (prevPrices.isEmpty) {
      prevPrices.addOne(price)
      span
    } else {
      for (i <- (prevPrices.length - 1 to 0) by -1) {
        if (prevPrices(i) > price) {
          prevPrices.addOne(price)
          return span
        } else if (prevPrices(i) <= price) {
          span += 1
        }
      }
      prevPrices.addOne(price)
      span
    }
  }

  var tmpResult: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer.empty[Int]

  // brute force
  // An optimization would be to save the last spanResult for in an array and if the last span array is gt > 1 start to look from prevPrices.length - lastSpan - 1
  def next_v2(price: Int): Int = {
    var span = 1
    if (prevPrices.isEmpty) {
      prevPrices.addOne(price)
      tmpResult.addOne(span)
      span
    } else {
      if (prevPrices(prevPrices.length - 1) <= price) {
        val lastSpan = tmpResult.last
        span += lastSpan
        for (i <- (prevPrices.length - lastSpan - 1 to 0) by -1) {
          if (prevPrices(i) > price) {
            prevPrices.addOne(price)
            return span
          } else if (prevPrices(i) <= price) {
            span += 1
          }
        }
        prevPrices.addOne(price)
        span
      } else {
        prevPrices.addOne(price)
        1
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val onlineStockSpan = OnlineStockSpan
    println(List(100, 80, 60, 70, 60, 75, 85).map(onlineStockSpan.next_v2))
  }

}
