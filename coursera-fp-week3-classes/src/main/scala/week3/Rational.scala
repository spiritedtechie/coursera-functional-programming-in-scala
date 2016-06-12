package week3

class Rational(x: Int, y: Int) {
  require(y != 0, "_denominator must be non zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  // method functions
  def unary_- : Rational = new Rational(-numer, denom)

  def +(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  // DRY
  def -(that: Rational) = this + -that

  def <(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  override def toString =
    numer + "/" + denom

}