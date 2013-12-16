import week4._

object ExprScratch {

  def localEval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => localEval(e1) + localEval(e2)
  }                                               //> localEval: (e: week4.Expr)Int

  def localShow(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => localShow(e1) + " + " + localShow(e2)
  }                                               //> localShow: (e: week4.Expr)String

  println(Number(3))                              //> Number(3)
  localEval(Number(1))                            //> res0: Int = 1
  localEval(Sum(Number(2), Number(3)))            //> res1: Int = 5
  localShow(Sum(Number(26), Number(33)))          //> res2: String = 26 + 33

  Sum(Number(26), Number(33)).eval                //> res3: Int = 59
  Sum(Number(26), Number(33)).show                //> res4: String = (26 + 33)

  Sum(Prod(Number(2), Var("x")), Var("y")).show   //> res5: String = ((2 * x) + y)
  Prod(Sum(Number(2), Var("x")), Var("y")).show   //> res6: String = ((2 + x) * y)
}