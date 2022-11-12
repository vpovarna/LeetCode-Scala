package com.leetcode.hard

import scala.collection.mutable

// balanced heaps
class MedianFinder() {
  val maxHeap: mutable.PriorityQueue[Int] = mutable.PriorityQueue[Int]()
  val minHeap: mutable.PriorityQueue[Int] = mutable.PriorityQueue[Int]().reverse

  def addNum(num: Int): Unit = {
    minHeap.enqueue(num) // need to add to min queue first so that we apply sorting.
    maxHeap.enqueue(minHeap.dequeue())
    if (minHeap.size < maxHeap.size) {
      minHeap.enqueue(maxHeap.dequeue())
    }
  }

  def findMedian(): Double = {
    if (minHeap.size > maxHeap.size) minHeap.head.toDouble
    else (minHeap.head + maxHeap.head.toDouble) / 2.0
  }

}


// sorted set
class MedianFinder2() {
  var elems: List[Int] = List()
  def addNum(num: Int): Unit = {
    elems = elems.filter(_ <= num) ++ (num :: elems.filter(_ > num))
  }

  def findMedian(): Double = {
    val mid = elems.size / 2
    if (elems.size % 2 == 0) (elems(mid-1) + elems(mid)) / 2.0
    else elems(mid).toDouble
  }
}

object FindMedianFromDataStream {
  def main(args: Array[String]): Unit = {
    val medianFinder = new MedianFinder2()
    medianFinder.addNum(1)
    medianFinder.addNum(2)
    println(medianFinder.findMedian()) // 1.5
    medianFinder.addNum(3)
    println(medianFinder.findMedian()) // 2.0
    medianFinder.addNum(4)
    println(medianFinder.findMedian()) // 2.5
    medianFinder.addNum(4)
    println(medianFinder.findMedian()) // 3.0
    medianFinder.addNum(4)
    println(medianFinder.findMedian()) // 3.5
  }
}
