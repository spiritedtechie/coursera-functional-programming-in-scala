import week4._

object NatScratch {

  new Succ(new Succ(Zero)) + new Succ(new Succ(Zero))
                                                  //> res0: week4.Nat = 1 1 1 1 0 

  new Succ(new Succ(Zero)) - new Succ(new Succ(Zero))
                                                  //> res1: week4.Nat = 0 
  
  new Succ(new Succ(Zero)) - new Succ(Zero)       //> res2: week4.Nat = 1 0 

}