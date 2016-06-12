package idealised.scala

abstract class Boolean {

  def ifThenElse[T](t: => T, e: => T): T

  def &&(x: => Boolean): Boolean = ifThenElse(x, f)

  def ||(x: Boolean): Boolean = ifThenElse(t, x)

  def unary_!(): Boolean = ifThenElse(f, t)

  def ==(x: Boolean): Boolean = ifThenElse(x, !x)

  def !=(x: Boolean): Boolean = ifThenElse(!x, x)

  def <(x: Boolean): Boolean = ifThenElse(f, x)
}

object t extends Boolean {

  def ifThenElse[T](t: => T, e: => T): T = t
}

object f extends Boolean {

  def ifThenElse[T](t: => T, e: => T): T = e
}
