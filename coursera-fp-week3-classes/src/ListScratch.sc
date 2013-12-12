import week3._

object ListScratch {

  def nth[T](l: List[T], n: Int): T = {
    if (l.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) l.head
    else nth(l.tail, n - 1)
  }                                               //> nth: [T](l: week3.List[T], n: Int)T

  val l = new Cons(1, new Cons(2,
    new Cons(3, new Cons(4, new Nil()))))         //> l  : week3.Cons[Int] = week3.Cons@35ed35e0

  nth(l, 2)                                       //> res0: Int = 3
  nth(l, 5)                                       //> java.lang.IndexOutOfBoundsException
                                                  //| 	at ListScratch$$anonfun$main$1.nth$1(ListScratch.scala:6)
                                                  //| 	at ListScratch$$anonfun$main$1.apply$mcV$sp(ListScratch.scala:15)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at ListScratch$.main(ListScratch.scala:3)
                                                  //| 	at ListScratch.main(ListScratch.scala)
}