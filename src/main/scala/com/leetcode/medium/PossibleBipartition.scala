package com.leetcode.medium

object PossibleBipartition {
  def possibleBipartition(n: Int, dislikes: Array[Array[Int]]): Boolean = {
    import scala.collection.mutable

    val dislikesMap = mutable.HashMap[Int, mutable.HashSet[Int]]().withDefaultValue(mutable.HashSet[Int]())

    for(d <- dislikes) {
      dislikesMap.getOrElseUpdate(d(0), mutable.HashSet[Int]()) += d(1)
      dislikesMap.getOrElseUpdate(d(1), mutable.HashSet[Int]()) += d(0)
    }

    val colors = Array.fill[Int](n+1)(0)

    def tryToColor(i: Int, color: Int) : Boolean = {
      if(colors(i) != 0) return colors(i) == color
      colors(i) = color
      dislikesMap(i).forall(n => tryToColor(n, -color))
    }

    (1 to n).forall(i => colors(i) != 0 || tryToColor(i, 1))
  }

  def main(args: Array[String]): Unit = {
    println(possibleBipartition(4, Array(Array(1,2),Array(1,3),Array(2,4)))) // true
    println(possibleBipartition(3, Array(Array(1,2),Array(1,3),Array(2,3)))) // false
    println(possibleBipartition(5, Array(Array(1,2),Array(2,3),Array(3,4), Array(4,5)))) // false
    println(possibleBipartition(5, Array(Array(1,2),Array(1,3),Array(1,4), Array(1,5)))) // true
  }
}
