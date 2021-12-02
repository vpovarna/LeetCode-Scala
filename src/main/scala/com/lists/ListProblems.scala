package com.lists

import scala.annotation.tailrec
import scala.util.Random

sealed abstract class RList[+T] {
  def head: T

  def tail: RList[T]

  def isEmpty: Boolean

  def ::[S >: T](elem: S): RList[S] = new ::[S](elem, this)

  /*
   * Exercises
   */
  def apply(index: Int): T

  def length: Int

  def reverse: RList[T]

  // concatenation
  def ++[S >: T](anotherList: RList[S]): RList[S]

  // remove an element at a given index, return a NEW list
  def removeAt(index: Int): RList[T]

  // map
  def map[S](f: T => S): RList[S]

  // flatmap
  def flatMap[S](f: T => RList[S]): RList[S]

  // filter
  def filter(f: T => Boolean): RList[T]

  /*
  * Run length encoding
  */
  def rle: RList[(T, Int)]

  /*
   * Duplicate elements
   */
  def duplicateEach(n: Int): RList[T]

  /*
   * Rotate n elements
   */
  def rotateNrElem(p: Int): RList[T]

  /*
   * Return n random number of elements from the list
   */

  def sample(k: Int): RList[T]

  /*
   * Insertion sort
   */
  def insertionSort[S >: T](ordering: Ordering[S]): RList[S]

  /**
   * Merge sort implementation
   */
  def mergeSort[S >: T](ordering: Ordering[S]): RList[S]
}

case object RNil extends RList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException("Empty list doesn't have head")

  override def tail: RList[Nothing] = throw new NoSuchElementException("Empty list doesn't have tail")

  override def isEmpty: Boolean = true

  override def toString: String = "[]"

  override def apply(index: Int): Nothing = throw new NoSuchElementException(s"Can't retrieve index: $index element from an empty list")

  override def length: Int = 0

  // reverse an empty list will return an empty list
  override def reverse: RList[Nothing] = RNil

  // append another List
  def ++[S >: Nothing](anotherList: RList[S]): RList[S] = anotherList

  def removeAt(index: Int): RList[Nothing] = RNil

  override def map[S](f: Nothing => S): RList[S] = RNil

  override def flatMap[S](f: Nothing => RList[S]): RList[S] = RNil

  override def filter(f: Nothing => Boolean): RList[Nothing] = RNil

  override def rle: RList[(Nothing, Int)] = RNil

  override def duplicateEach(n: Int): RList[Nothing] = RNil

  override def rotateNrElem(p: Int): RList[Nothing] = RNil

  override def sample(k: Int): RList[Nothing] = RNil

  override def insertionSort[S >: Nothing](ordering: Ordering[S]): RList[S] = RNil

  /**
   * Merge sort implementation
   */
  override def mergeSort[S >: Nothing](ordering: Ordering[S]): RList[S] = RNil
}

case class ::[+T](override val head: T, override val tail: RList[T]) extends RList[T] {
  override def isEmpty: Boolean = false

  override def toString: String = {
    @tailrec
    def toStringTailRec(remaining: RList[T], result: String): String = {
      if (remaining.isEmpty) result
      else if (remaining.tail.isEmpty) s"$result${remaining.head}"
      else toStringTailRec(remaining.tail, s"$result${remaining.head}, ")
    }

    "[" + toStringTailRec(this, "") + "]"

  }

  override def apply(index: Int): T = {

    @tailrec
    def applyTaiRec(list: RList[T], position: Int): T = {
      if (position == index) list.head
      else applyTaiRec(list.tail, position + 1)
    }

    if (index < 0) throw new NoSuchElementException
    else applyTaiRec(this, 0)
  }

  // Complexity: O(N x M)
  def ++[S >: T](anotherList: RList[S]): RList[S] = {

    @tailrec
    def concatenateListsTailRec(remainingList: RList[S], result: RList[S]): RList[S] = {
      if (remainingList.isEmpty) result
      else concatenateListsTailRec(remainingList.tail, remainingList.head :: result)
    }

    concatenateListsTailRec(this.reverse, anotherList)
  }

  override def reverse: RList[T] = {

    @tailrec
    def reverseTailRec(list: RList[T], newList: RList[T]): RList[T] = {
      if (list.isEmpty) newList
      else reverseTailRec(list.tail, list.head :: newList)
    }

    reverseTailRec(this, RNil)
  }

  // Remove an element from a given index
  def removeAt(index: Int): RList[T] = {

    @tailrec
    def removeIndexTailRec(remainingList: RList[T], acc: RList[T], count: Int): RList[T] = {
      if (remainingList.isEmpty) acc.reverse
      else if (count == index) acc.reverse ++ remainingList.tail
      else removeIndexTailRec(remainingList.tail, remainingList.head :: acc, count + 1)
    }

    if (index < 0) this
    else removeIndexTailRec(this, RNil, 0)
  }

  override def map[S](f: T => S): RList[S] = {

    @tailrec
    def mapTailRecursion(remainingMap: RList[T], acc: RList[S]): RList[S] = {
      if (remainingMap.isEmpty) acc.reverse
      else mapTailRecursion(remainingMap.tail, f(remainingMap.head) :: acc)
    }

    mapTailRecursion(this, RNil)

  }

  // Complexity:
  // O(Z^2) where Z = sum of all lengths of f(x)
  override def flatMap[S](f: T => RList[S]): RList[S] = {

    @tailrec
    def flatmapTailRecursion(remainingMap: RList[T], acc: RList[S]): RList[S] = {
      if (remainingMap.isEmpty) acc
      else flatmapTailRecursion(remainingMap.tail, acc ++ f(remainingMap.head))
    }

    /*
      [1,2,3].flatMap(x => [x, x*2]) = concatenateAll([[1,2],[2,4],[3,6]])
    */
    @tailrec
    def betterFlatMap(remainingList: RList[T], accumulator: RList[RList[S]]): RList[S] = {
      if (remainingList.isEmpty) concatenateAll(accumulator, RNil, RNil)
      else betterFlatMap(remainingList.tail, f(remainingList.head).reverse :: accumulator)
    }

    @tailrec
    def concatenateAll(elements: RList[RList[S]], currentList: RList[S], accumulator: RList[S]): RList[S] = {
      if (elements.isEmpty && currentList.isEmpty) accumulator
      else if (currentList.isEmpty) concatenateAll(elements.tail, elements.head, accumulator)
      else concatenateAll(elements, currentList.tail, currentList.head :: accumulator)
    }

    betterFlatMap(this, RNil)

  }

  override def filter(f: T => Boolean): RList[T] = {

    @tailrec
    def filterTailRecursion(remainingList: RList[T], acc: RList[T]): RList[T] = {
      if (remainingList.isEmpty) acc.reverse
      else if (f(remainingList.head)) filterTailRecursion(remainingList.tail, remainingList.head :: acc)
      else filterTailRecursion(remainingList.tail, acc)
    }

    filterTailRecursion(this, RNil)
  }

  override def rle: RList[(T, Int)] = {
    @tailrec
    def rleTailRec(remainingList: RList[T], tmpTuple: (T, Int), result: RList[(T, Int)]): RList[(T, Int)] = {
      if (remainingList.isEmpty & tmpTuple._2 == 0) result
      else if (remainingList.isEmpty) tmpTuple :: result
      else if (remainingList.head == tmpTuple._1) rleTailRec(remainingList.tail, tmpTuple.copy(_2 = tmpTuple._2 + 1), result)
      else rleTailRec(remainingList.tail, (remainingList.head, 1), tmpTuple :: result)
    }

    rleTailRec(this, (this.head, 1), RNil).reverse
  }

  // Complexity: O(N + M)
  override def duplicateEach(n: Int): RList[T] = {
    @tailrec
    def duplicateEachTailRec(remainingList: RList[T], tmpList: RList[T], acc: RList[T]): RList[T] = {
      if (remainingList.isEmpty & tmpList.isEmpty) acc.reverse
      else if (remainingList.isEmpty) tmpList ++ acc
      else if (tmpList.length < n) duplicateEachTailRec(remainingList, remainingList.head :: tmpList, acc)
      else duplicateEachTailRec(remainingList.tail, RNil, tmpList ++ acc)
    }

    if (n < 0) throw new IllegalArgumentException("Number of iterations should be greater than 0")
    else duplicateEachTailRec(this, RNil, RNil)
  }

  //  Implementation using Map
  //  override def rle: RList[(T, Int)] = {
  //
  //    @tailrec
  //    def rleTailRec(remainingList: RList[T], accMap: Map[T, Int]): Map[T, Int] = {
  //      if (remainingList.isEmpty) accMap
  //      else rleTailRec(remainingList.tail, updateMap(remainingList.head, accMap))
  //    }
  //
  //    def updateMap(head: T, accMap: Map[T, Int]): Map[T, Int] = {
  //      val newValue: Int = accMap.getOrElse(head, 0) + 1
  //      accMap ++ Map(head -> newValue)
  //    }
  //
  //    val result: Map[T, Int] = rleTailRec(this, Map.empty)
  //
  //    @tailrec
  //    def buildRListTailRec(map: Map[T, Int], acc: RList[(T, Int)]): RList[(T, Int)] = {
  //      if (map.isEmpty) acc
  //      else {
  //        buildRListTailRec(map.tail, (map.head._1 -> map.head._2) :: RNil ++ acc)
  //      }
  //    }
  //
  //    buildRListTailRec(result, RNil)
  //  }

  /*
   * Rotate the first p elem
   */
  override def rotateNrElem(p: Int): RList[T] = {
    @tailrec
    def rotateNrElemTailRec(remainingList: RList[T], fistPElem: RList[T], remainingElem: RList[T]): RList[T] = {
      if (remainingList.isEmpty) remainingElem.reverse ++ fistPElem.reverse
      else if (fistPElem.length < p) rotateNrElemTailRec(remainingList.tail, remainingList.head :: fistPElem, remainingElem)
      else rotateNrElemTailRec(remainingList.tail, fistPElem, remainingList.head :: remainingElem)
    }

    rotateNrElemTailRec(this, RNil, RNil)
  }

  /*
   * Complexity: O(N x K)
   */
  override def sample(k: Int): RList[T] = {
    val random = new Random(System.currentTimeMillis())
    val maxIndex = this.length

    @tailrec
    def sampleTailRec(nRemaining: Int, acc: RList[T]): RList[T] = {
      if (nRemaining == 0) acc
      else {
        val nextIndex = random.nextInt(maxIndex)
        val newNumber = this (nextIndex)
        sampleTailRec(nRemaining - 1, newNumber :: acc)
      }
    }

    def sampleElegant: RList[T] = {
      RList.from(1 to k)
        .map(_ => random.nextInt(maxIndex))
        .map(index => this (index))
    }

    if (k < 0) RNil
    else sampleTailRec(k, RNil)
  }

  override def length: Int = {
    @tailrec
    def lengthTailRec(list: RList[T], count: Int): Int = {
      if (list.isEmpty) count
      else lengthTailRec(list.tail, count + 1)
    }

    lengthTailRec(this, 0)
  }

  // Using insertion sort algorithm -> my impl
//  override def sorted[S >: T](ordering: Ordering[S]): RList[S] = {
//
//    @tailrec
//    def insertionSortTailRec(remainingList: RList[T], previousElem: T, result: RList[S]): RList[S] = {
//      if (remainingList.isEmpty) result
//      else if (ordering.lt(remainingList.head, previousElem)) {
//        val updatedResult: RList[S] = insertAnElementInTheList(result, inserted = false, remainingList.head, RNil)
//        insertionSortTailRec(remainingList.tail, remainingList.head, updatedResult)
//      }
//      else insertionSortTailRec(remainingList.tail, remainingList.head, (remainingList.head :: result.reverse).reverse)
//    }
//
//    @tailrec
//    def insertAnElementInTheList(tmpList: RList[S], inserted: Boolean, elem: T, result: RList[S]): RList[S] = {
//      if (tmpList.isEmpty) result.reverse
//      else if (ordering.lt(tmpList.head, elem)) insertAnElementInTheList(tmpList.tail, inserted = false, elem, tmpList.head :: result)
//      else if (ordering.gt(tmpList.head, elem) && !inserted) insertAnElementInTheList(tmpList, inserted = true, elem, elem :: result)
//      else insertAnElementInTheList(tmpList.tail, inserted = true, elem, tmpList.head :: result)
//    }
//
//    insertionSortTailRec(this.tail, this.head, this.head::RNil)
//  }

  // training impl
  override def insertionSort[S >: T](ordering: Ordering[S]): RList[S] = {
    @tailrec
    def insertSortTailRec(remainingList: RList[T], acc: RList[S]): RList[S] = {
      if (remainingList.isEmpty) acc
      else insertSortTailRec(remainingList.tail, insertSorted(remainingList.head, RNil, acc))
    }

    @tailrec
    def insertSorted(t: S, before: RList[S], after: RList[S]): RList[S] ={
      if (after.isEmpty || ordering.lteq(t, after.head)) before ++ (t :: after)
      else insertSorted(t, after.head :: before, after.tail)
    }

    insertSortTailRec(this, RNil)
  }

  /**
   * Merge sort implementation
   */
  override def mergeSort[S >: T](ordering: Ordering[S]): RList[S] = ???
//  {
//
//    def merge(listA: RList[S], listB: RList[S], accumulator: RList[S]): RList[S] = ???
//    def mergeSortTailrec(smallList: RList[S], biglist: RList[RList[S]]): RList[S] = ???
//
//  }
}

object RList {
  def from[T](iterable: Iterable[T]): RList[T] = {

    @tailrec
    def convertToRListTailRec(remaining: Iterable[T], result: RList[T]): RList[T] = {
      if (remaining.isEmpty) result
      else convertToRListTailRec(remaining.tail, remaining.head :: result)
    }

    convertToRListTailRec(iterable, RNil).reverse
  }
}

object ListProblems extends App {
  val aSmallList = 1 :: 2 :: 3 :: RNil
  val aNewList = 1 :: 2 :: 3 :: 5 :: 6 :: 7 :: RNil
  val largeList: RList[Int] = RList.from(1 to 10000)
  //
  //  println(aSmallList)
  //  println(aSmallList.apply(2))
  //  println(largeList.apply(2231))
  //  println(aSmallList.length)
  //  println(largeList.length)
  //
  //  println(aSmallList.reverse)
  //  println(largeList.reverse)
  //
  //  println(RList.from(5 to 7) ++ aSmallList)
  //
  //  println(RList.from(1 to 10).removeAt(11))
  //  println(RList.from(1 to 10).removeAt(2))
  //

  // Testing Map
  println(aSmallList.map(_ + 1))

  // Testing filter
  println(aSmallList.filter(x => x % 2 == 0))

  // Testing flatMap
  println(largeList.flatMap(x => x :: x + 1 :: RNil))

  val testList = 1 :: 2 :: 2 :: 3 :: 3 :: 3 :: 4 :: 4 :: RNil

  println(testList.rle)

  println(aSmallList.duplicateEach(2))

  println(aNewList.rotateNrElem(3))

  println(aNewList.sample(3))

  val unsortedList = 2 :: 4 :: 3 :: 1 :: 6 :: 5 :: RNil
  val ordering = Ordering.fromLessThan[Int](_ < _)
  println(unsortedList.insertionSort(ordering))
}

