object QueriesWithFor {

  case class Book(title: String, authors: List[String])

  val books: List[Book] = List(
    Book(title = "abc", List("bob", "john")),
    Book(title = "abd", List("bob", "john")),
    Book(title = "def", List("fred", "john")),
    Book(title = "ghi", List("harry", "george"))) //> books  : List[QueriesWithFor.Book] = List(Book(abc,List(bob, john)), Book(ab
                                                  //| d,List(bob, john)), Book(def,List(fred, john)), Book(ghi,List(harry, george)
                                                  //| ))

  for (b <- books if b.title contains "ab") yield b
                                                  //> res0: List[QueriesWithFor.Book] = List(Book(abc,List(bob, john)), Book(abd,L
                                                  //| ist(bob, john)))

  // filter equivalent
  books filter (b => b.title contains "ab")       //> res1: List[QueriesWithFor.Book] = List(Book(abc,List(bob, john)), Book(abd,L
                                                  //| ist(bob, john)))

  for {
    b1 <- books
    b2 <- books
    if (b1.title < b2.title)
    a1 <- b1.authors
    a2 <- b2.authors
    if (a1 == a2)
  } yield a1                                      //> res2: List[String] = List(bob, john, john, john)

  // exercise - translate for expression to HO functions
  for (b <- books; a <- b.authors if a startsWith "bo")
    yield b.title                                 //> res3: List[String] = List(abc, abd)

  // steps to reduce
  books.flatMap(b =>
    for (a <- b.authors if a startsWith "bo")
      yield b.title)                              //> res4: List[String] = List(abc, abd)

  books.flatMap(b =>
    for (a <- b.authors.withFilter(a => a startsWith "bo"))
      yield b.title)                              //> res5: List[String] = List(abc, abd)

  books.flatMap(b =>
    b.authors.withFilter(a => a startsWith "bo").map(a => b.title) //for (a <- b.authors.withFilter(a => a startsWith "bo"))
    //yield b.title
    )                                             //> res6: List[String] = List(abc, abd)

  // end result
  books.flatMap(b => b.authors.withFilter(a => a startsWith "bo").map(a => b.title))
                                                  //> res7: List[String] = List(abc, abd)
}