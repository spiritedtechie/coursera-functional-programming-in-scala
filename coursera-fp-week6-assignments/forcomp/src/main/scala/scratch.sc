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
}