object Lesson1Scratch {

  val xs = Array(1, 3, 4, 55)                     //> xs  : Array[Int] = Array(1, 3, 4, 55)

  xs map (x => x * x)                             //> res0: Array[Int] = Array(1, 9, 16, 3025)

  val s = "abcDeFg"                               //> s  : String = abcDeFg

  s filter (c => c.isUpper)                       //> res1: String = DF

  val pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,a), (2,b), (3,c))

  pairs.unzip                                     //> res2: (List[Int], List[Char]) = (List(1, 2, 3),List(a, b, c))

  s flatMap (c => List('.', c))                   //> res3: String = .a.b.c.D.e.F.g

  xs.min                                          //> res4: Int = 1

  xs.max                                          //> res5: Int = 55

  xs.sum                                          //> res6: Int = 63

  def isPrime(n: Int): Boolean = {
    (2 until n) forall (x => n % x != 0)
  }                                               //> isPrime: (n: Int)Boolean

  isPrime(11)                                     //> res7: Boolean = true

}