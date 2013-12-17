object ListScratch {

  // parameterized generic merge sort
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))(lt)
    }
  }                                               //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]

  // pattern matching tuples
  def merge[T](xs: List[T], ys: List[T])(lt: (T, T) => Boolean): List[T] =
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (lt(x, y)) x :: merge(xs1, ys)(lt)
        else y :: merge(xs, ys1)(lt)
    }                                             //> merge: [T](xs: List[T], ys: List[T])(lt: (T, T) => Boolean)List[T]

  val l = List(10, 5, 3, 14, 5, 20, 5, 6, 70)     //> l  : List[Int] = List(10, 5, 3, 14, 5, 20, 5, 6, 70)

  msort(l)((x, y) => x < y)                       //> res0: List[Int] = List(3, 5, 5, 5, 6, 10, 14, 20, 70)

  val fl = List("apple", "pineapple", "banana", "pear")
                                                  //> fl  : List[String] = List(apple, pineapple, banana, pear)
  msort(fl)((x, y) => x.compareTo(y) < 0)         //> res1: List[String] = List(apple, banana, pear, pineapple)
}