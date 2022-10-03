package com.work

object StringsProblem extends App {

  val inputStr = "aab, cac, ac, ba, caa, d"

  val t = inputStr.split(" ")
    .map(_.toSet)
    .groupBy(identity)
    .view
    .mapValues(_.length)
    .toMap

  println(t)
}
