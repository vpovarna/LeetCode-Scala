package com.leetcode.medium

object ValidSudoku {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    val rowCondition: Boolean = validateBoard(board, i => i > 9)
    val columnCondition: Boolean = validateBoard(board.transpose, i => i > 9)

    val inputPoints: List[(Int, Int)] = (board.indices by 3).toList.flatMap(i =>
      (board.indices by 3).toList.map(j => (i, j))
    )
    val gridCondition = validateGrid(inputPoints, board)
    rowCondition && columnCondition && gridCondition
  }

  //TODO: Refactor this method
  private def validateGrid(inputPoints: List[(Int, Int)], board: Array[Array[Char]]): Boolean = {
    var isGridValid: Boolean = true

    inputPoints.map(t => {
      val testSet = collection.mutable.Set[Int]()

      (t._1 until 3 + t._1).foreach { i =>
        (t._2 until 3 + t._2).foreach { j =>
          val element = board(i)(j)
          if (element != '.') {
            val nr = element.toString.toInt
            if (testSet.contains(nr)) isGridValid = false
            else testSet.add(nr)
          }
        }
      }
      isGridValid
    }).forall(_ == true)
  }

  private def validateBoard(board: Array[Array[Char]], condition: Int => Boolean): Boolean = {
    board
      .map(arr => arr.filter(_ != '.').map(c => c.toString).map(_.toInt))
      .forall(x => x.count(condition) == 0 && x.toSet.size == x.length)
  }

  def main(args: Array[String]): Unit = {
    val board = Array(
      Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9'))

    val secondBoard = Array(
      Array('8', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9'))

    val thiordBoard = Array(
      Array('.', '.', '4', '.', '.', '.', '6', '3', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('5', '.', '.', '.', '.', '.', '.', '9', '.'),
      Array('.', '.', '.', '5', '6', '.', '.', '.', '.'),
      Array('4', '.', '3', '.', '.', '.', '.', '.', '1'),
      Array('.', '.', '.', '7', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '5', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.')
    )
    println(isValidSudoku(thiordBoard))
  }

}
