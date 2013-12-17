object ReductionScratch {

  def sum(xs: List[Int]) = (0 :: xs) reduceLeft (_ + _)
                                                  //> sum: (xs: List[Int])Int
  def product(xs: List[Int]) = (1 :: xs) reduceLeft (_ * _)
                                                  //> product: (xs: List[Int])Int
  sum(List(1, 3, 4, 5))                           //> res0: Int = 13
  product(List(1, 3, 4, 5))                       //> res1: Int = 60

  def sum2(xs: List[Int]) = (xs foldLeft 0)(_ + _)//> sum2: (xs: List[Int])Int
  def product2(xs: List[Int]) = (xs foldLeft 1)(_ * _)
                                                  //> product2: (xs: List[Int])Int
  sum2(List(1, 3, 4, 5))                          //> res2: Int = 13
  product2(List(1, 3, 4, 5))                      //> res3: Int = 60

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())(f(_) :: _)           //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)((x, y) => 1 + y)             //> lengthFun: [T](xs: List[T])Int

  mapFun(List(1, 2, 3), (x: Int) => x * x)        //> res4: List[Int] = List(1, 4, 9)
  lengthFun(List('a', 'b', 'c'))                  //> res5: Int = 3
  lengthFun(List())                               //> res6: Int = 0
}