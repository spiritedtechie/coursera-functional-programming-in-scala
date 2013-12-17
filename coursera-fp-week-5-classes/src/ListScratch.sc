object ListScratch {

  // pattern matching tuples
  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }                                             //> merge: (xs: List[Int], ys: List[Int])List[Int]

  val l = List(1, 2, 3, 4, 5)                     //> l  : List[Int] = List(1, 2, 3, 4, 5)

  val l2 = List(2, 5, 6, 7)                       //> l2  : List[Int] = List(2, 5, 6, 7)

  merge(l, l2)                                    //> res0: List[Int] = List(1, 2, 2, 3, 4, 5, 5, 6, 7)
}