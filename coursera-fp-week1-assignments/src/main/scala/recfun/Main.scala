package recfun
import common._
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

    def nextRowList(l: List[Int]): List[Int] =
      1 :: combineAdjElements(l) ::: List(1)

    @tailrec
    def loopToRowList(rIter: Int, l: List[Int]): List[Int] =
      if (rIter == r) l
      else loopToRowList(rIter + 1, nextRowList(l))

    val matchedRowList = loopToRowList(0, List(1))

    matchedRowList(c)
  }

  def combineAdjElements(l: List[Int]): List[Int] = {

    @tailrec
    def addIter(accList: List[Int], i1: Int, i2: Int): List[Int] =
      if (i2 >= l.size) accList
      else addIter(accList ::: List(l(i1) + l(i2)), i1 + 1, i2 + 1)

    addIter(List(), 0, 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    @tailrec
    def countBalance(chars: List[Char], openCount: Int) : Int = {
        if (chars.isEmpty) openCount
        else if (chars.head == '(') countBalance(chars.tail, openCount + 1)
        else if (chars.head == ')' && openCount == 0) -1
        else if (chars.head == ')' && openCount > 0) countBalance(chars.tail, openCount - 1)
        else countBalance(chars.tail, openCount)
    }
    
    if (countBalance(chars, 0) != 0) false else true
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
