package week4

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}

object List {

  def apply[T](a: T): List[T] =
    new Cons(a, Nil)

  def apply[T](a: T, b: T): List[T] =
    new Cons(a, new Cons(b, Nil))

  def apply[T](a: T, b: T, c: T): List[T] =
    new Cons(a, new Cons(b, new Cons(c, Nil)))

  def apply[T]() = Nil
}