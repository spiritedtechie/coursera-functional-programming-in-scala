object QueriesWithFor {

  case class Book(title: String, authors: List[String])

  val books: List[Book] = List(
    Book(title = "abc", List("bob", "john")),
    Book(title = "abd", List("bob", "john")),
    Book(title = "def", List("fred", "john")),
    Book(title = "ghi", List("harry", "george"))) //> books  : List[QueriesWithFor.Book] = List(Book(abc,List(bob, john)), Book(ab
                                                  //| d,List(bob, john)), Book(def,List(fred, john)), Book(ghi,List(harry, george)
                                                  //| ))

  for {
    b <- books
    if b.title contains "ab"
  } yield b                                       //> res0: List[QueriesWithFor.Book] = List(Book(abc,List(bob, john)), Book(abd,L
                                                  //| ist(bob, john)))

  for {
    b1 <- books
    b2 <- books
    if (b1.title < b2.title)
    a1 <- b1.authors
    a2 <- b2.authors
    if (a1 == a2)
  } yield a1                                      //> res1: List[String] = List(bob, john, john, john)

  books flatMap (b1 => books map (b2 => if (b1.title < b2.title) b1.authors map (a1 => b2.authors map (a2 => if (a1 == a2) a1))))
                                                  //> res2: List[Any] = List((), List(List(bob, ()), List((), john)), List(List(()
                                                  //| , ()), List((), john)), List(List((), ()), List((), ())), (), (), List(List(
                                                  //| (), ()), List((), john)), List(List((), ()), List((), ())), (), (), (), List
                                                  //| (List((), ()), List((), ())), (), (), (), ())
}