object Factorial {

  def factorial(n: Int): Int = {

    def go(acc: Int, n: Int): Int = if (n == 0) acc else go(acc * n, n - 1)

    go(1, n)
  }                                               //> factorial: (n: Int)Int

  factorial(4)                                    //> res0: Int = 24
}