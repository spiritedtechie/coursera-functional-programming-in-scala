object ScalaListScratch {

  val l = 1 :: 2 :: 3 :: Nil                      //> l  : List[Int] = List(1, 2, 3)

  // functions we are already familiar with
  l.head                                          //> res0: Int = 1
  l.tail                                          //> res1: List[Int] = List(2, 3)
  l.isEmpty                                       //> res2: Boolean = false

  def listMatch[T](x: List[T]): Unit =
    x match {
      case (Nil) => println("empty")
      case (x :: xs) => println(x + " and " + xs)
    }                                             //> listMatch: [T](x: List[T])Unit

  listMatch(l)                                    //> 1 and List(2, 3)
  listMatch(List())                               //> empty

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]

  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }                                               //> isort: (xs: List[Int])List[Int]

  isort(List(7, 3, 9, 2))                         //> res3: List[Int] = List(2, 3, 7, 9)
}