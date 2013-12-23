import waterpouring._

object WaterPouringScratch {

  val p = new Pouring(Vector(4, 9))               //> p  : waterpouring.Pouring = waterpouring.Pouring@439ed348

  p.moves                                         //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with Wa
                                                  //| terPouringScratch.p.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), Pour
                                                  //| (0,1), Pour(1,0))

  p.pathSets.take(5).toList                       //> res1: List[Set[WaterPouringScratch.p.Path]] = List(Set( --> Vector(0, 0)), S
                                                  //| et(Fill(0) --> Vector(4, 0), Fill(1) --> Vector(0, 9)), Set(Fill(0) Fill(1) 
                                                  //| --> Vector(4, 9), Fill(0) Pour(0,1) --> Vector(0, 4), Fill(1) Fill(0) --> Ve
                                                  //| ctor(4, 9), Fill(1) Pour(1,0) --> Vector(4, 5)), Set(Fill(0) Pour(0,1) Fill(
                                                  //| 0) --> Vector(4, 4), Fill(1) Pour(1,0) Empty(0) --> Vector(0, 5)), Set(Fill(
                                                  //| 0) Pour(0,1) Fill(0) Pour(0,1) --> Vector(0, 8), Fill(1) Pour(1,0) Empty(0) 
                                                  //| Pour(1,0) --> Vector(4, 1)))
  p.solution(6)                                   //> res2: Stream[WaterPouringScratch.p.Path] = Stream(Fill(1) Pour(1,0) Empty(0)
                                                  //|  Pour(1,0) Empty(0) Pour(1,0) Fill(1) Pour(1,0) --> Vector(4, 6), ?)
}