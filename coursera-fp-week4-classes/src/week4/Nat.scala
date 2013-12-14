package week4

// Peano numbers
abstract class Nat {

  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = true
  def predecessor: Nat = throw new Error("")
  def +(that: Nat): Nat = that
  def -(that: Nat) = if (that.isZero) this else throw new Error("")
  override def toString() = "0 "
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def predecessor: Nat = n
  def +(that: Nat): Nat = new Succ(predecessor + that)
  def -(that: Nat) = if (that.isZero) this else this.predecessor - that.predecessor
  override def toString() = "1 " + predecessor.toString()
}

