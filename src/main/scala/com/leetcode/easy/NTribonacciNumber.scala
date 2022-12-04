package com.leetcode.easy

object NTribonacciNumber {
  def tribonacci(n: Int): Int = {
    if (n==0) 0
    else if (n==1) 1
    else if (n==2) 1
    else {
      var n0=0
      var n1=1
      var n2=1
      for ( n <- (3 to n)) {
        val tmp = n2
        n2 = n0 + n1 + n2
        n0 = n1
        n1 = tmp
      }
      n2
    }
  }

}
