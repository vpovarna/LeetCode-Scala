package com.leetcode.medium

import scala.collection.mutable

object MinimumGeneticMutation {
  val possibleMutations: List[Char] = List[Char]('A', 'C', 'G', 'T')
  val queue: mutable.Queue[(String, Int)] = mutable.Queue.empty[(String, Int)]
  val visited: mutable.HashSet[String] = mutable.HashSet.empty[String]

  def minMutation(start: String, end: String, bank: Array[String]): Int = {
    if (bank.contains(end)) {

      queue.enqueue((start, 0))
      visited.addOne(start)

      while (queue.nonEmpty) {
        val (gene, level) = queue.dequeue()
        if (gene == end) return level
        else checkPossibleMutatedGene(gene, level, bank)
      }
    }
    -1
  }

  def checkPossibleMutatedGene(gene: String, level: Int, bank: Array[String]): Unit = {
    gene.indices.foreach { i =>
      possibleMutations.foreach { letter =>
        val words = gene.splitAt(i)
        val newGene = s"${words._1}$letter${words._2.tail}"
        if (!visited.contains(newGene) && bank.contains(newGene)) {
          queue.enqueue((newGene, level + 1))
          visited.add(newGene)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(
      minMutation(
        "AAAAACCC",
        "AACCCCCC",
        bank = Array("AAAACCCC", "AAACCCCC", "AACCCCCC")
      )
    )

    println(
      minMutation(
        "AACCGGTT",
        "AAACGGTA",
        bank = Array("AACCGGTA", "AACCGCTA", "AAACGGTA")
      )
    )
  }

}
