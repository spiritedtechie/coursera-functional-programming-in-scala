package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  import Main.combineAdjElements
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }
  
  test("pascal: col=4,row=6") {
    assert(pascal(4,6) === 15)
  }
  
  test("pascal: col=3,row=6") {
    assert(pascal(3,6) === 20)
  }
  
  test("pascal: col=3,row=1000") {
    assert(pascal(1,1000) === 1000)
  }
  
  test("combineAdjElements: List(1, 2, 3, 4, 5, 6, 7)") {
    assert(combineAdjElements(List(1, 2, 3, 4, 5, 6, 7)) == List(3, 5, 7, 9, 11, 13))
  }
}
