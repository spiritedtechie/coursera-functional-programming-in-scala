object MapScratch {

  val m = Map("I" -> 1, "V" -> 5, "X" -> 10)      //> m  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -> 5, X -> 10
                                                  //| )
  m("I")                                          //> res0: Int = 1
  //m("G")
  m get "G"                                       //> res1: Option[Int] = None
  val option = m get "V"                          //> option  : Option[Int] = Some(5)

  option match {
    case None => println("nothing")
    case Some(v) => println(v)
  }                                               //> 5

  val fruits = List("apple", "pear", "orange", "pineapple")
                                                  //> fruits  : List[String] = List(apple, pear, orange, pineapple)
  fruits.sorted                                   //> res2: List[String] = List(apple, orange, pear, pineapple)
  fruits.sortWith(_.length < _.length)            //> res3: List[String] = List(pear, apple, orange, pineapple)

  fruits.groupBy(_.head)                          //> res4: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
	
}