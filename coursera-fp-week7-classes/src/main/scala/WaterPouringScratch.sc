import waterpouring._

object WaterPouringScratch {

  val p = new Pouring(Vector(4, 9, 7))            //> p  : waterpouring.Pouring = waterpouring.Pouring@6016a917

  p.moves                                         //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with W
                                                  //| aterPouringScratch.p.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0), F
                                                  //| ill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), Pour
                                                  //| (2,1))

  p.pathSets.take(5).toList                       //> res1: List[Set[WaterPouringScratch.p.Path]] = List(Set( --> Vector(0, 0, 0))
                                                  //| , Set(Fill(0) --> Vector(4, 0, 0), Fill(1) --> Vector(0, 9, 0), Fill(2) --> 
                                                  //| Vector(0, 0, 7)), Set(Fill(2) Fill(0) --> Vector(4, 0, 7), Fill(2) Fill(1) -
                                                  //| -> Vector(0, 9, 7), Fill(0) Pour(0,2) --> Vector(0, 0, 4), Fill(2) Pour(2,0)
                                                  //|  --> Vector(4, 0, 3), Fill(1) Fill(0) --> Vector(4, 9, 0), Fill(0) Fill(1) -
                                                  //| -> Vector(4, 9, 0), Fill(1) Pour(1,0) --> Vector(4, 5, 0), Fill(1) Pour(1,2)
                                                  //|  --> Vector(0, 2, 7), Fill(2) Pour(2,1) --> Vector(0, 7, 0), Fill(1) Fill(2)
                                                  //|  --> Vector(0, 9, 7), Fill(0) Pour(0,1) --> Vector(0, 4, 0), Fill(0) Fill(2)
                                                  //|  --> Vector(4, 0, 7)), Set(Fill(2) Fill(0) Pour(0,1) --> Vector(0, 4, 7), Fi
                                                  //| ll(2) Fill(1) Fill(0) --> Vector(4, 9, 7), Fill(1) Fill(2) Fill(0) --> Vecto
                                                  //| r(4, 9, 7), Fill(0) Pour(0,1) Fill(0) --> Vector(4, 4, 0), Fill(1) Fill(0) P
                                                  //| our(0,2) --> Vector(0, 9, 4), Fill(2) Pour(2,1) Fill(0) --> Vector(4, 7, 0),
                                                  //|  Fill(2) Pour(2,0) Pour(
                                                  //| Output exceeds cutoff limit.
  p.solution(6)                                   //> res2: Stream[WaterPouringScratch.p.Path] = Stream(Fill(1) Fill(0) Pour(1,2) 
                                                  //| Pour(0,1) --> Vector(0, 6, 7), ?)
}