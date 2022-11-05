package com.leetcode.medium

object WordSearch {

  // Reverse BackTracking -> Depth First Search

  // Time Complexity: O(m * n * dfs). Time complexity of dfs is the word of the word. Since we are going on 4 branching: 4 ^ (word.length)
  // Time complexity: O(m * n * 4^(word.length))
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    if(board.length == 0) word.length == 0
    else if(word.length == 0) true
    else {
      // We recurse on each cell and try to match the first char of string
      board.indices.foreach{ r =>
        board(r).indices.foreach{ c =>
          if(board(r)(c) == word(0)){
            // When we found now we will recursively find all other match DFS
            if(checkDFS(board,word,0,r,c)) return true
          }

        }
      }
      false
    }

  }

  def checkDFS(board: Array[Array[Char]], word: String,index:Int,i:Int,j:Int) : Boolean = {
    if(index == word.length) {
      true
    }
    else if(i < 0 || j < 0 || i == board.length || j == board(i).length || board(i)(j) != word(index)){
      false
    }
    else {
      // Came here means we are in bound and matched the current cell
      val tmp = board(i)(j)
      board(i)(j) = ' ' // to represent visited
      // Now check if we match next char in any one of the direction
      val nextExists = checkDFS(board,word,index+1,i+1,j) || checkDFS(board,word,index+1,i-1,j) || checkDFS(board,word,index+1,i,j+1) || checkDFS(board,word,index+1,i,j-1)
      board(i)(j) = tmp // Revers the visited
      nextExists
    }

  }

  def main(args: Array[String]): Unit = {

    val board1 = Array(
      Array('A', 'B', 'C', 'E'),
      Array('S', 'F', 'C', 'S'),
      Array('A', 'D', 'E', 'E')
    )
    println(exist(board1, "ABCCED")) // true
  }

}
