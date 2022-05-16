package com.leetcode.medium

object CoinChange {

  def coinChange(coins: Array[Int], amount: Int): Int = {
    // We need to fill the array with a value gt then amount
    val dp: Array[Int] = Array.fill(amount + 1)(amount +1)
    dp.update(0, 0)

    for (a <- 1 to amount) {
      for (c <- coins) {
        if (c <= a) {
          // 1 + dp(a - c)) is 1 + the previous known solution
          dp.update(a, Math.min(dp(a), 1 + dp(a - c)))
        }
      }
    }
    if (dp(amount) == amount +1) -1 else dp(amount)
  }

  def main(args: Array[String]): Unit = {
    println(coinChange(Array(1,3,4,5), 7))
  }

}
