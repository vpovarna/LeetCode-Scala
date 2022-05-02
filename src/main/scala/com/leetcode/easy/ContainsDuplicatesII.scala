package com.leetcode.easy

object ContainsDuplicatesII {

  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    var collectionMap = Map[Int, Int]()
    var containsDuplicates: Boolean = false
    for (i <- nums.indices) {
      if (collectionMap.contains(nums(i))) {
        val index = collectionMap(nums(i))
        if (i - index <= k) containsDuplicates = true
        else collectionMap = collectionMap + (nums(i) -> i)
      } else {
        collectionMap = collectionMap + (nums(i) -> i)
      }
    }
    containsDuplicates
  }


  def containsNearbyDuplicateTR(nums: Array[Int], k: Int): Boolean = {
    // tailRec version
    @scala.annotation.tailrec
    def containsNearbyDuplicateTailRec(remainingNums: Array[Int], index: Int = 0, map: Map[Int, Int] = Map(), containsDuplicates: Boolean = false): Boolean = {
      if (remainingNums.isEmpty || containsDuplicates) containsDuplicates
      else {
        val currentNum = remainingNums.head
        if (map.contains(currentNum) && index - map(currentNum) <= k) {
          containsNearbyDuplicateTailRec(remainingNums.tail, index + 1, map, containsDuplicates = true)
        } else {
          containsNearbyDuplicateTailRec(remainingNums.tail, index + 1, map + (currentNum -> index), containsDuplicates)
        }
      }
    }

    containsNearbyDuplicateTailRec(nums)
  }

  def main(args: Array[String]): Unit = {
    println(containsNearbyDuplicate(Array(1, 2, 3, 1, 2, 3), 2))
    println(containsNearbyDuplicate(Array(1, 0, 1, 1), 1))
  }
}
