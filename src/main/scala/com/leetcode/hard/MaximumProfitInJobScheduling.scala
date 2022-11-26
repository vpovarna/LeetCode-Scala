package com.leetcode.hard

import scala.util.control.Breaks.{break, breakable}

object MaximumProfitInJobScheduling {

  case class Job(startTime: Int, endTime: Int, profit: Int)

  def jobScheduling(
      startTime: Array[Int],
      endTime: Array[Int],
      profit: Array[Int]
  ): Int = {

    val jobs: Array[Job] = startTime.indices.map { i =>
      Job(startTime(i), endTime(i), profit(i))
    }.toArray

    val sortedJobs =
      jobs.sortWith((job1, job2) => job1.endTime <= job2.endTime)

    val dp = Array.fill(sortedJobs.length)(0)
    dp(0) = sortedJobs(0).profit

    (1 until sortedJobs.length).foreach { i =>
      dp(i) = Math.max(sortedJobs(i).profit, dp(i - 1))
      breakable {
        (i - 1 to 0 by -1).foreach { j =>
          if (sortedJobs(j).endTime <= sortedJobs(i).startTime) {
            dp(i) = Math.max(dp(i), sortedJobs(i).profit + dp(j))
            break
          }
        }
      }
      dp
    }
    dp.max
  }

  def main(args: Array[String]): Unit = {
    println(
      jobScheduling(Array(1, 2, 3, 3), Array(3, 4, 5, 6), Array(50, 10, 40, 70))
    )

    println(
      jobScheduling(
        Array(1, 2, 3, 4, 6),
        Array(3, 5, 10, 6, 9),
        Array(20, 20, 100, 70, 60)
      )
    )
  }

}
