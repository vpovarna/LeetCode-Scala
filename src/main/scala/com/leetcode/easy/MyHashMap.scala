package com.leetcode.easy

class MyHashMap {
  private val map = collection.mutable.Map.empty[Int, List[Int]]

  def put(key: Int, value: Int): Unit = {
    map += (key.hashCode() -> (value +: map.getOrElse(key, List())))
  }

  def get(key: Int): Int = {
    map.get(key.hashCode()) match {
      case Some(value) => value.head
      case None => -1
    }
  }

  def remove(key: Int): Unit = {
    map -= key.hashCode()
  }
}

object MyHashMap {
  def main(args: Array[String]): Unit = {
    val myHashSet = new MyHashMap() // null
    myHashSet.put(1,1) // null
    myHashSet.put(2,2) // null
    println(myHashSet.get(1)) // 1
    println(myHashSet.get(3)) // -1
    myHashSet.put(2,1) // null
    println(myHashSet.get(2)) // 1
    myHashSet.remove(2) // null
    println(myHashSet.get(3)) // -1
  }
}
