package com.leetcode.medium

object RectangleArea {

  def computeArea(
      ax1: Int,
      ay1: Int,
      ax2: Int,
      ay2: Int,
      bx1: Int,
      by1: Int,
      bx2: Int,
      by2: Int
  ): Int = {
    val intersectionX = math.min(ax2, bx2) - math.max(ax1, bx1)
    val intersectionY = math.min(ay2, by2) - math.max(ay1, by1)
    val intersection =
      if (intersectionX <= 0 || intersectionY <= 0) 0
      else intersectionX * intersectionY

    def area(x1: Int, x2: Int, y1: Int, y2: Int): Int = (x2 - x1) * (y2 - y1)

    area(ax1, ax2, ay1, ay2) + area(bx1, bx2, by1, by2) - intersection
  }

}
