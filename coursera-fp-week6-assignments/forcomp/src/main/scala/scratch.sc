object scratch {

  "Robert".toLowerCase()
    .groupBy((c: Char) => c)
    .map((t: (Char, String)) => (t._1, t._2.length()))
    .toList.sorted                                //> res0: List[(Char, Int)] = List((b,1), (e,1), (o,1), (r,2), (t,1))

  List("Robert", "sat", "down")                   //> res1: List[String] = List(Robert, sat, down)

}