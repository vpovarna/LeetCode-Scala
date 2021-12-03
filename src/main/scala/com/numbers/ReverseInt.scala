package com.numbers

import scala.annotation.tailrec

object ReverseInt {

  // Return a number with the digits reversed
  // if the result overflow Int, return 0
  def reverseInteger(number: Int): Int = {

    @tailrec
    def reverseIntTailRec(remainingNum: Int, result: Int): Int = {
      if (remainingNum == 0) result
      else {
        val digit = remainingNum % 10
        val tentativeResult = result * 10 + digit

        if ((tentativeResult >= 0) != (result >= 0)) 0
        else reverseIntTailRec(remainingNum / 10, tentativeResult)
      }
    }

    if (number == Int.MinValue) 0
    else if (number >= 0) reverseIntTailRec(number, 0)
    else -reverseIntTailRec(-number, 0)
  }

}
