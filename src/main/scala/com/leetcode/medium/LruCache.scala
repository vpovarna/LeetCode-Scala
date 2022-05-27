package com.leetcode.medium

case class Node(key: Int, value: Int, var left: Node = null, var right: Node = null)

//TODO: Implement this using ListBuffer and Mutable Maps from scala
class LruCache(_capacity: Int) {
  private val capacity: Int = _capacity
  private val head = Node(-1, -1)
  private val tail = Node(-1, -1)
  head.right = tail
  tail.left = head
  private val indexMap = collection.mutable.Map[Int, Node]()

  private def removeFromTheList(node: Node): Unit = {
    node.left.right = node.right.left
  }

  private def putInFront(node: Node): Unit = {
    head.right.left = node
    node.right = head.right
    node.left = head
    head.right = node
  }

  def get(key: Int): Int = {
    indexMap.get(key) match {
      case Some(node) =>
        removeFromTheList(node)
        putInFront(node)
        node.value
      case None => -1
    }
  }

  def put(key: Int, value: Int): Unit = {
    val node = indexMap.get(key) match {
      case Some(node) =>
        removeFromTheList(node)
        node.copy(value = value)
      case None =>
        if (indexMap.size == capacity) {
          indexMap -= tail.left.key
          removeFromTheList(tail.left)
        }
        Node(key, value)
    }

    putInFront(node)
    indexMap += (key -> node)
  }
}

object LruCache {

  def main(args: Array[String]): Unit = {

    def scenario1(): Unit = {
      val lruCache = new LruCache(1)
      lruCache.put(2, 1)
      println(lruCache.get(2)) // 1

    }

    def scenario2(): Unit = {
      val lruCache: LruCache = new LruCache(2)
      lruCache.put(1, 1)
      lruCache.put(2, 2)
      println(lruCache.get(1)) // 1
      lruCache.put(3, 3)
      println(lruCache.get(2)) // -1
      lruCache.put(4, 4)
      println(lruCache.get(1)) // -1
      println(lruCache.get(3)) // 3
      println(lruCache.get(4)) // 4
    }

    def scenario3(): Unit = {
      val lruCache: LruCache = new LruCache(2)
      println(lruCache.get(2)) // -1
      lruCache.put(2, 6)
      println(lruCache.get(1)) // -1
      lruCache.put(1, 5)
      lruCache.put(1, 2)
      println(lruCache.get(1)) // 2
      println(lruCache.get(2)) // 6
    }

    scenario1()
  }


}
