package com.trees

import scala.annotation.tailrec
import scala.collection.immutable.Queue

sealed abstract class BTree[+T] {
  def value: T

  def leftLeaf: BTree[T]

  def rightLeaf: BTree[T]

  def isEmpty: Boolean

  /**
   * Easy problems
   */
  // Leaf node in a tree is a node for whichsi both leaf children are empty. Are the BEnd objects
  def isLeaf: Boolean

  def collectLeaves: List[BTree[T]]

  def leafCount: Int

  def size: Int

  /**
   * Medium problems
   */

  def collectNodes(level: Int): List[BTree[T]]

  def mirror: BTree[T]

  def sameShapeAs[B >: T](that: BTree[B]): Boolean

  // Collect all nodes to a list
  def toList: List[T]

}

case object BEnd extends BTree[Nothing] {
  override val size: Int = 0

  override def value: Nothing = throw new NoSuchElementException

  override def leftLeaf: BTree[Nothing] = throw new NoSuchElementException

  override def rightLeaf: BTree[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  /**
   * Easy methods
   */
  override def isLeaf: Boolean = false

  override def collectLeaves: List[BTree[Nothing]] = List()

  override def leafCount: Int = 0

  /**
   * Medium problems
   */
  override def collectNodes(level: Int): List[BTree[Nothing]] = List()

  override def mirror: BTree[Nothing] = BEnd

  override def sameShapeAs[B >: Nothing](that: BTree[B]): Boolean = that.isEmpty

  override def toList: List[Nothing] = List()
}

case class BNode[+T](override val value: T, override val leftLeaf: BTree[T], override val rightLeaf: BTree[T]) extends BTree[T] {
  override val size: Int = 1 + leftLeaf.size + rightLeaf.size

  /**
   * Easy methods
   */
  override def isLeaf: Boolean = leftLeaf.isEmpty && rightLeaf.isEmpty

  override def leafCount: Int = collectLeaves.length

  override def collectLeaves: List[BTree[T]] = {

    /*
           _____1_____
          /           \
        __2__       __6__
       /     \     /     \
       3     4     7     8
              \
               5

          collectLeavesTailrec([BNode(1)], [])
          collectLeavesTailrec([2, 6], [])
          collectLeavesTailrec([3, 4, 6], [])
          collectLeavesTailrec([4, 6], [3])
          collectLeavesTailrec([5, 6], [3])
          collectLeavesTailrec([6], [5, 3])
          collectLeavesTailrec([7, 8], [5, 3])
          collectLeavesTailrec([8], [7, 5, 3])
          collectLeavesTailrec([], [8, 7, 5, 3])

     */
    @tailrec
    def collectLeavesTailrec(todo: List[BTree[T]], leaves: List[BTree[T]]): List[BTree[T]] = {
      if (todo.isEmpty) leaves
      else if (todo.head.isEmpty) collectLeavesTailrec(todo.tail, leaves)
      else if (todo.head.isLeaf) collectLeavesTailrec(todo.tail, todo.head :: leaves)
      else {
        val node = todo.head
        collectLeavesTailrec(node.leftLeaf :: node.rightLeaf :: todo.tail, leaves)
      }
    }

    collectLeavesTailrec(List(this), List())

  }

  /*
       _____1_____
      /           \
    __2__       __6__
   /     \     /     \
   3     4     7     8
          \
           5
      clt([1], []) =
      clt([2, 6], []) =
      clt([3,4,6], []) =
      clt([4,6], [3]) =
      clt([5,6], [3]) =
      clt([6], [5,3]) =
      clt([7,8], [5,3]) =
      clt([8], [7,5,3]) =
      clt([], [8,7,5,3]) =
      [8,7,5,3]
    */

  override def isEmpty: Boolean = false

  //  override def size: Int = {
  //    @tailrec
  //    def sizeTailRec(todo: List[BTree[T]], acc: List[BTree[T]]): List[BTree[T]] = {
  //      if (todo.isEmpty) acc
  //      else if (todo.head.isEmpty) sizeTailRec(todo.tail, acc)
  //      else sizeTailRec(todo.head.leftLeaf :: todo.head.rightLeaf :: todo.tail, todo.head :: acc)
  //    }
  //
  //    sizeTailRec(List(this), List()).length
  //  }

  /**
   * Medium problems
   */
  override def collectNodes(level: Int): List[BTree[T]] = {

    /*

             _____1_____
            /           \
          __2__       __6__
         /     \     /     \
         3     4     7     8
                \
                 5

        collectNodesTailRec([1],0, List())
        collectNodesTailRec([2, 6], 1, List())
        collectNodesTailRec([6], 2, List(3,4))
        collectNodesTailRec([0], 2, List(3,4, 7, 8))
     */
    @tailrec
    def collectNodesTailRec(currentLevel: Int, acc: List[BTree[T]]): List[BTree[T]] = {
      if (acc.isEmpty) List()
      else if (currentLevel == level) acc
      else {
        val expendedNodes = for {
          node <- acc
          child <- List(node.leftLeaf, node.rightLeaf) if !child.isEmpty
        } yield child
        collectNodesTailRec(currentLevel + 1, expendedNodes)
      }
    }

    collectNodesTailRec(0, List(this))

    //    @tailrec
    //    def collectNodesTailRec(todo: List[BTree[T]], currentLevel: Int, acc: List[BTree[T]]): List[BTree[T]] = {
    //      if (currentLevel > level || todo.isEmpty) acc
    //      else if (currentLevel == level && todo.nonEmpty) {
    //        val head = todo.head
    //        collectNodesTailRec(todo.tail, currentLevel, head :: acc)
    //      }
    //      else {
    //        collectNodesTailRec(recreateToDoList(todo, List()), currentLevel + 1, acc)
    //      }
    //    }
    //
    //    @tailrec
    //    def recreateToDoList(todo: List[BTree[T]], acc: List[BTree[T]]): List[BTree[T]] = {
    //      if (todo.isEmpty) acc
    //      else if (todo.head.isLeaf) recreateToDoList(todo.tail, acc)
    //      else if (!todo.head.leftLeaf.isEmpty && !todo.head.rightLeaf.isEmpty) {
    //        recreateToDoList(todo.tail, todo.head.leftLeaf :: todo.head.rightLeaf :: acc)
    //      }
    //      else {
    //        val head = todo.head
    //        val tmp = if (!head.leftLeaf.isEmpty) head.leftLeaf
    //        else head.rightLeaf
    //        recreateToDoList(todo.tail, tmp :: acc)
    //      }
    //    }
    //
    //    collectNodesTailRec(List(this), 0, List.empty)

  }

  override def mirror: BTree[T] = {
    /*
             _____1_____
            /           \
          __2__       __6__
         /     \     /     \
         3     4     7     8
                \
                 5

        mirrorTailRec([1], [0], List[{}])
        mirrorTailRec([1], [1], List[{1}])
        mirrorTailRec([2, 6], [1], List[{1}])
        mirrorTailRec([6], [1,2], List[{2},{1}])
    */

    @tailrec
    def mirrorTailRec(todo: List[BTree[T]], visited: Set[BTree[T]], done: List[BTree[T]]): BTree[T] = {
      if (todo.isEmpty) done.head
      else if (todo.head.isLeaf || todo.head.isEmpty) mirrorTailRec(todo.tail, visited, todo.head :: done)
      else if (!visited.contains(todo.head)) {
        val head = todo.head
        mirrorTailRec(head.leftLeaf :: head.rightLeaf :: todo, visited + head, done)
      }
      else {
        val head = visited.head
        val newLeftBTree = done.head
        val newRightBTree = done.tail.head
        val newTree = BNode(head.value, newLeftBTree, newRightBTree)
        mirrorTailRec(todo.tail, visited, newTree :: done.drop(2))
      }

    }

    mirrorTailRec(List(this), Set(), List())
  }

  override def sameShapeAs[B >: T](that: BTree[B]): Boolean = {

    @tailrec
    def sameShapeTailRec(thisRemaining: List[BTree[B]], thatRemaining: List[BTree[B]]): Boolean = {
      if (thisRemaining.isEmpty) thatRemaining.isEmpty
      else if (thatRemaining.isEmpty) thisRemaining.isEmpty
      else if (thisRemaining.head.isEmpty) thatRemaining.head.isEmpty && sameShapeTailRec(thisRemaining.tail, thatRemaining.tail)
      else if (thatRemaining.head.isLeaf) thisRemaining.head.isLeaf && sameShapeTailRec(thisRemaining.tail, thatRemaining.tail)
      else sameShapeTailRec(thisRemaining.head.leftLeaf :: thisRemaining.head.rightLeaf :: thisRemaining.tail,
        thatRemaining.head.leftLeaf :: thatRemaining.head.rightLeaf :: thatRemaining.tail)
    }

    sameShapeTailRec(List(this), List(that))
  }

  /*
               _____1_____
              /           \
            __2__       __6__
           /     \     /     \
           3     4     7     8
                  \
                   5

    Traverse the tree:
          Left -> Root -> Right
      - in-order traverser [3,2,4,5,1,7,6,8]
         left -> right  -> root
      - post-order [3, 5, 4, 2, 7, 6, 8, 1]
          root -> Left -> Right
      - pre-order [1,2,3,4,5,6,7,8]
      - per-level
   */

  override def toList: List[T] = {

    // StackRecursion: pre-order
    def preOrderToListTailRec(tree: BTree[T]): List[T] = {
      if (tree.isEmpty) List()
      else tree.value :: preOrderToListTailRec(tree.leftLeaf) ++ preOrderToListTailRec(tree.rightLeaf)
    }

    // StackRecursion: post-order
    def postOrderToListTailRec(tree: BTree[T]): List[T] = {
      if (tree.isEmpty) List()
      else postOrderToListTailRec(tree.leftLeaf) ++ postOrderToListTailRec(tree.rightLeaf) ++ List(tree.value)
    }

    // StackRecursion: in-order
    def inOrderToListTailRec(tree: BTree[T]): List[T] = {
      if (tree.isEmpty) List()
      else inOrderToListTailRec(tree.leftLeaf) ++ List(tree.value) ++ inOrderToListTailRec(tree.rightLeaf)
    }

    @tailrec
    def preOrderTailRec(stack: List[BTree[T]], visited: Set[BTree[T]] = Set(), acc: Queue[T] = Queue()): List[T] = {
      if (stack.isEmpty) acc.toList
      else {
        val node = stack.head
        if (node.isEmpty) preOrderTailRec(stack.tail, visited, acc)
        else if (node.isLeaf || visited.contains(node)) preOrderTailRec(stack.tail, visited, acc :+ node.value)
        else preOrderTailRec(node :: node.leftLeaf :: node.rightLeaf :: stack.tail, visited + node, acc)
      }
    }

    @tailrec
    def perLevelTailRec(level: List[BTree[T]], finalQueue: List[BTree[T]]): List[T] = {
      if (level.isEmpty) finalQueue.map(_.value).toList
      else {
        val newList: List[BTree[T]] = for {
          node <- level
          child <- List(node.leftLeaf, node.rightLeaf) if !child.isEmpty
        } yield child
        perLevelTailRec(newList, finalQueue ++ level)
      }
    }

    postOrderToListTailRec(this)
    preOrderToListTailRec(this)
    inOrderToListTailRec(this)

    preOrderTailRec(List(this))
    perLevelTailRec(List(this), List())
  }


}

object BinaryTreeProblem extends App {

  /**
   * Easy problems
   */

  val bTree = new BNode[Int](
    1,
    new BNode[Int](2, BEnd, BEnd),
    new BNode[Int](3,
      new BNode[Int](4, BEnd, BEnd),
      new BNode[Int](5, BEnd, BEnd)))

  val tree = new BNode[Int](1,
    BNode(2,
      BNode(3, BEnd, BEnd),
      BNode(4,
        BEnd,
        BNode(5, BEnd, BEnd),
      )
    ),
    BNode(6,
      BNode(7, BEnd, BEnd),
      BNode(8, BEnd, BEnd)
    )
  )

  println(tree.collectLeaves.map(_.value))
  println(tree.leafCount)

  println(bTree.size)
  println(tree.size)

  println(tree.collectNodes(0).map(_.value))
  println(tree.collectNodes(1).map(_.value))
  println(tree.collectNodes(2).map(_.value))
  println(tree.collectNodes(3).map(_.value))

  println(bTree.mirror)
  println(bTree.sameShapeAs(bTree))

  println(tree.toList)
}
