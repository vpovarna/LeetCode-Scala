package com.leetcode.medium

object JumpGameII {

  // greedy solution
  def jump(nums: Array[Int]): Int = {
    var res = 0

    // Starting from position 0 with two pointers
    var (l, r) = (0, 0)

    // Iterate until we reach the end of the array
    while (r < nums.length - 1) {
      // temp value to store the maximum point where we can jump
      var farthest = 0
      for (i <- l to r) {
        // For all the interval (l,r) we are calculating the maximum point where we can jump
        farthest = math.max(farthest, i + nums(i))
      }
      // Updating the pointer
      // left pointer is the next element of the window
      l = r + 1
      // right is the far pointer we can reach
      r = farthest
      // Updating the result
      res +=1
    }
    res
  }


  def main(args: Array[String]): Unit = {
    println(jump(Array(2,3,1,1,4)))
  }

}
