package com.leetcode.medium

import scala.util.Random

class RandomizedSet() {
  private val indices = scala.collection.mutable.Map.empty[Int, Int]
  private val values = scala.collection.mutable.ArrayBuffer.empty[Int]

  def insert(value: Int): Boolean = {
    indices.get(value) match {
      case Some(_) => false
      case None =>
        values.append(value)
        indices.update(value, values.length -1)
        true
    }
  }

  def remove(value: Int): Boolean = {
    indices.get(value) match {
      case Some(idx) =>
        val last = values.last
        values.remove(values.length - 1)
        indices.remove(value)
        if (idx != values.length) {
          values.update(idx, last)
          indices.update(last, idx)
        }
        true
      case None => false
    }

  }

  def getRandom(): Int = {
    values(Random.nextInt(values.length))
  }

}

object RandomizedSet {
  def main(args: Array[String]): Unit = {
    val randomizedSet = new RandomizedSet()
    randomizedSet.insert(1)
    randomizedSet.remove(2)
    randomizedSet.insert(2)
    println(randomizedSet.getRandom())
    randomizedSet.remove(1)
    randomizedSet.insert(2)
    println(randomizedSet.getRandom())
  }
}
