package com.leetcode.medium

object FindPlayersWithZeroOrOneLosses {
  def findWinners(matches: Array[Array[Int]]): List[List[Int]] = {

    val emptyMap1 = Map.empty[Int, Int]
    val emptyMap2 = Map.empty[Int, Int]

    val (tmpMap1, tmpMap2) = matches.foldLeft((emptyMap1, emptyMap2)) {
      case ((map1, map2), arr) =>
        val tmpMap1 = map1 + (arr(0) -> (map1.getOrElse(arr(0), 0) + 1))
        val tmpMap2 = map2 + (arr(1) -> (map2.getOrElse(arr(1), 0) + 1))
        (tmpMap1, tmpMap2)
    }

    val list1 = tmpMap1.filter(kv => !tmpMap2.contains(kv._1)).keys.toList.sorted
    val list2 = tmpMap2.filter(_._2 == 1).keys.toList.sorted

    List(list1, list2)
  }

  def main(args: Array[String]): Unit = {
    val input = Array(
      Array(1, 3),
      Array(2, 3),
      Array(3, 6),
      Array(5, 6),
      Array(5, 7),
      Array(4, 5),
      Array(4, 8),
      Array(4, 9),
      Array(10, 4),
      Array(10, 9)
    )

    println(findWinners(input))
  }

}
