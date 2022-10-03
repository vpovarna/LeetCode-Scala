package com.leetcode.easy

object SqrtX {

  def mySqrt(x: Int): Int = {
    var left = 1
    var right = x

    while(left <= right) {
      val mid = left + (right - left) / 2
      if(mid > x/mid) right = mid - 1
      else if(mid < x/mid) left = mid + 1
      else return mid
    }
    right
  }

}
