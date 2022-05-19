package com.leetcode.hard

object SlidingWindowMaximum {

  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    nums.length match {
      case 1 => nums
      case len =>
        val result = scala.collection.mutable.ArrayBuffer[Int]()
        val window = scala.collection.mutable.ArrayDeque[(Int,Int)]() // Maintain Dequeue of (value,index)
        for(i <- 0 until len){
          //Remove all elements from queue head, if there index is out of range now
          while(window.nonEmpty && window.head._2 < (i-k+1)){
            window.removeHead()
          }
          //Remove all the elements which are less than current element, as the current element will be the max anyhow in the window
          while(window.nonEmpty && window.last._1 < nums(i)){
            window.removeLast()
          }
          window.append((nums(i),i))
          if(i >= k-1){
            result.append(window.head._1)
          }
        }
        result.toArray
    }
  }

  // Complexity: O(n*k)
  def maxSlidingWindowFP(nums: Array[Int], k: Int): Array[Int] = {
    nums.sliding(k).map(_.max).toArray
  }

  def main(args: Array[String]): Unit = {
    println(maxSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 3).mkString("Array(", ", ", ")"))
    println(maxSlidingWindow(Array(9, 10, 9, -7, -4, -8, 2, -6), 5).mkString("Array(", ", ", ")"))
  }

}
