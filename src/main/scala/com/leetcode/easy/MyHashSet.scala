package com.leetcode.easy

class MyHashSet() {
    private val listBuffer = scala.collection.mutable.ListBuffer.empty[Int]

    def add(key: Int): Unit = {
      if (!listBuffer.contains(key)) listBuffer.addOne(key)
    }

    def remove(key: Int): Unit = {
      listBuffer -= key
    }

    def contains(key: Int): Boolean = {
      listBuffer.contains(key)
    }

}
