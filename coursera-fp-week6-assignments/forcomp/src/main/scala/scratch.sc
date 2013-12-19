object scratch {

  def occurences(w: String) = {
    w.toLowerCase()
      .groupBy((c: Char) => c)
      .map((t: (Char, String)) => (t._1, t._2.length()))
      .toList.sorted
  }                                               //> occurences: (w: String)List[(Char, Int)]

  occurences("Robert")                            //> res0: List[(Char, Int)] = List((b,1), (e,1), (o,1), (r,2), (t,1))

  List("Robert", "sat", "down").foldLeft("")((acc, w) => acc concat w)
                                                  //> res1: String = Robertsatdown

  def dictionaryByOccurences(words: List[String]): Map[List[(Char, Int)], List[String]] =
    for {
      (occ, occForWords) <- words.map(w => (occurences(w), w)).groupBy(t => t._1)
    } yield occ -> occForWords.map(t => t._2)     //> dictionaryByOccurences: (words: List[String])Map[List[(Char, Int)],List[Stri
                                                  //| ng]]

  dictionaryByOccurences(List("ate", "eat", "tea", "pate", "tape", "bob"))
                                                  //> res2: Map[List[(Char, Int)],List[String]] = Map(List((a,1), (e,1), (p,1), (t
                                                  //| ,1)) -> List(pate, tape), List((b,2), (o,1)) -> List(bob), List((a,1), (e,1)
                                                  //| , (t,1)) -> List(ate, eat, tea))

  def combinations(occurrences: List[(Char, Int)]): List[List[(Char, Int)]] = occurrences match {
    case Nil => List(Nil)
    case (char, occCnt) :: t =>
      for {
        rest <- combinations(t)
        n <- 0 to occCnt
      } yield ((char, n) :: rest).filter(x => x._2 > 0)
  }                                               //> combinations: (occurrences: List[(Char, Int)])List[List[(Char, Int)]]

  combinations(List(('a', 2), ('b', 2), ('c', 2)))//> res3: List[List[(Char, Int)]] = List(List(), List((a,1)), List((a,2)), List(
                                                  //| (b,1)), List((a,1), (b,1)), List((a,2), (b,1)), List((b,2)), List((a,1), (b,
                                                  //| 2)), List((a,2), (b,2)), List((c,1)), List((a,1), (c,1)), List((a,2), (c,1))
                                                  //| , List((b,1), (c,1)), List((a,1), (b,1), (c,1)), List((a,2), (b,1), (c,1)), 
                                                  //| List((b,2), (c,1)), List((a,1), (b,2), (c,1)), List((a,2), (b,2), (c,1)), Li
                                                  //| st((c,2)), List((a,1), (c,2)), List((a,2), (c,2)), List((b,1), (c,2)), List(
                                                  //| (a,1), (b,1), (c,2)), List((a,2), (b,1), (c,2)), List((b,2), (c,2)), List((a
                                                  //| ,1), (b,2), (c,2)), List((a,2), (b,2), (c,2)))

  val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> x  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,1))
  val y = List(('r', 1))                          //> y  : List[(Char, Int)] = List((r,1))

  def subtract(x: List[(Char, Int)], y: List[(Char, Int)]): List[(Char, Int)] = {
    val yMap = y.toMap withDefaultValue 0

    def updateMap(m: Map[Char, Int], t: (Char, Int)): Map[Char, Int] = t match {
      case (char, cnt) => m updated (char, cnt - yMap(char))
      case _ => m
    }

    x.toMap.foldLeft(Map[Char, Int]())((acc, t) => updateMap(acc, t))
    	.toList.filter(t => t._2 > 0)
  }                                               //> subtract: (x: List[(Char, Int)], y: List[(Char, Int)])List[(Char, Int)]

  subtract(x, y)                                  //> res4: List[(Char, Int)] = List((a,1), (d,1), (l,1))

}