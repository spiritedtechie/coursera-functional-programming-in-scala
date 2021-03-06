val r = new Rational(1, 2)                      //> r  : Rational = 1/2

r.numer                                         //> res0: Int = 1
r.denom                                         //> res1: Int = 2

val r2 = new Rational(2, 3)                     //> r2  : Rational = 2/3

r + r2                                          //> res2: Rational = 7/6

-r2                                             //> res3: Rational = -2/3

// subtraction exercise
val x = new Rational(1, 3)                      //> x  : Rational = 1/3
val y = new Rational(5, 7)                      //> y  : Rational = 5/7
val z = new Rational(3, 2)                      //> z  : Rational = 3/2

x - y - z                                       //> res4: Rational = -79/42

y + y                                           //> res5: Rational = 10/7

x < y                                           //> res6: Boolean = true

z max y                                         //> res7: Rational = 3/2

val a = new Rational(3)                         //> a  : Rational = 3/1


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