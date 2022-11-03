package com.interviewes

import scala.collection.mutable.ArrayBuffer
import scala.math.Ordering

object InterviewBook {

  def main(args: Array[String]): Unit = {
    // Day -> Prices
    val prices: Map[Int, Int] =
      Map(3 -> 100, 4 -> 300, 5 -> 500, 6 -> 500, 7 -> 200, 8 -> 100)

    val startDay = 3
    val endDay = 8
    val range = 3

    val result: ArrayBuffer[RangeResult] = ArrayBuffer.empty[RangeResult]
    implicit val myAOrdering: Ordering[(Int, Int)] = Ordering.by(-_._1)

    for (i <- startDay to endDay - 2) {
      val queue = scala.collection.mutable.PriorityQueue.empty[(Int, Int)]
      for (j <- 0 until range) {
        val day = j + i
        queue.addOne((prices(day), day))
      }
      val (day, smallestPrice) = queue.head
      val dayRange = s"$i-${i + range - 1}"
      result.addOne(
        RangeResult(
          dayRange,
          pricePerDay = DayPrice(day.toString, smallestPrice)
        )
      )
      queue.dequeueAll
    }

    println(result.toList)
  }

  case class RangeResult(dayRange: String, pricePerDay: DayPrice)
  case class DayPrice(day: String, price: Int)
}
