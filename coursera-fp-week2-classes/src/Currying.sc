object Currying {

  def mapReduce(f: Int => Int)(combine: (Int, Int) => Int)(a: Int, b: Int, z: Int): Int = {
    def loop(a: Int, acc: Int): Int =
      if (a > b) acc
      else loop(a + 1, combine(acc, f(a)))

    loop(a, z)
  }                                               //> mapReduce: (f: Int => Int)(combine: (Int, Int) => Int)(a: Int, b: Int, z: In
                                                  //| t)Int

	// currying
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f)((x, y) => x + y)(a, b, 0)        //> sum: (f: Int => Int)(a: Int, b: Int)Int

	// currying
  def product(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f)((x, y) => x * y)(a, b, 1)        //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x)(1, 5)                           //> res0: Int = 120

  def factorial(n: Int): Int =
    product(x => x)(1, n)                         //> factorial: (n: Int)Int

  factorial(5)                                    //> res1: Int = 120
  
  // partially applied function
  val paProd = product(x => x) _                  //> paProd  : (Int, Int) => Int = <function2>
  
  paProd(1, 5)                                    //> res2: Int = 120
}