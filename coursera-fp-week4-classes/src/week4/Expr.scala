package week4

trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }

  def show(): String = this match {
    case Number(n) => n.toString
    case Var(x) => x
    case Sum(e1, e2) => "(" + e1.show + " + " + e2.show + ")"
    case Prod(e1, e2) => "(" + e1.show + " * " + e2.show + ")"
  }
}

// case class - Scala compiler automatically adds companion objects
case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Prod(e1: Expr, e2: Expr) extends Expr

case class Var(t: String) extends Expr