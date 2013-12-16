import week4._

object ExprScratch {

  def localEval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => localEval(e1) + localEval(e2)
  }                                               //> localEval: (e: week4.Expr)Int

  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => show(e1) + "+" + show(e2)
  }                                               //> show: (e: week4.Expr)String

  println(Number(3))                              //> Number(3)
  localEval(Number(1))                            //> res0: Int = 1
  localEval(Sum(Number(2), Number(3)))            //> res1: Int = 5

  Sum(Number(26), Number(33)).eval                //> res2: Int = 59

  show(Sum(Number(26), Number(33)))               //> res3: String = 26+33
}