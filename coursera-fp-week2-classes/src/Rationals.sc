object Rationals {

  val r = new Rational(1, 2)                      //> r  : Rational = 1/2

  r.numer                                         //> res0: Int = 1
  r.denom                                         //> res1: Int = 2

  val r2 = new Rational(2, 3)                     //> r2  : Rational = 2/3

  r.add(r2)                                       //> res2: Rational = 7/6

  r.neg                                           //> res3: Rational = -1/2

  // subtraction exercise
  val x = new Rational(1, 3)                      //> x  : Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Rational = 3/2

  x.sub(y).sub(z)                                 //> res4: Rational = -79/42
}

class Rational(x: Int, y: Int) {

  def numer = x
  def denom = y

  // method functions
  def neg(): Rational =
    new Rational(-numer, denom)

  def add(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def sub(that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom)

  override def toString =
    numer + "/" + denom

}