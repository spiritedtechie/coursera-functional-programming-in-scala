import math.Ordering

object ListScratch {

  // parameterized generic merge sort
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }                                               //> msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]

  // pattern matching tuples
  def merge[T](xs: List[T], ys: List[T])(implicit ord: Ordering[T]): List[T] =
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (ord.lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }                                             //> merge: [T](xs: List[T], ys: List[T])(implicit ord: scala.math.Ordering[T])Li
                                                  //| st[T]

  val l = List(10, 5, 3, 14, 5, 20, 5, 6, 70)     //> l  : List[Int] = List(10, 5, 3, 14, 5, 20, 5, 6, 70)

  msort(l)                                        //> res0: List[Int] = List(3, 5, 5, 5, 6, 10, 14, 20, 70)

  val fl = List("apple", "pineapple", "banana", "pear")
                                                  //> fl  : List[String] = List(apple, pineapple, banana, pear)
  msort(fl)                                       //> res1: List[String] = List(apple, banana, pear, pineapple)

  val l3 = List("a", "a", "a", "b", "c", "c", "a")//> l3  : List[String] = List(a, a, a, b, c, c, a)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  pack(l3)                                        //> res2: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 
  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))     //> encode: [T](xs: List[T])List[(T, Int)]

  encode(l3)                                      //> res3: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))

  l3.filter(x => x > "a")                         //> res4: List[String] = List(b, c, c)
}