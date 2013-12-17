package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("times for a list of characters") {
    assert(times(List('a', 'b', 'c', 'a')) === List(('a', 2), ('b', 1), ('c', 1)))
    assert(times(List('a', 'b', 'b', 'a')) === List(('a', 2), ('b', 2)))
    assert(times(List('a', 'b', 'c', 'd')) === List(('a', 1), ('b', 1), ('c', 1), ('d', 1)))
    assert(times(List('a')) === List(('a', 1)))
    assert(times(List('a', 'a')) === List(('a', 2)))
    assert(times(List()) === List())
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
    assert(makeOrderedLeafList(List(('a', 3), ('b', 4), ('c', 5))) === List(Leaf('a', 3), Leaf('b', 4), Leaf('c', 5)))
  }

  test("singleton") {
    assert(!singleton(List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3))))
    assert(!singleton(List()))
    assert(singleton(List(Leaf('e', 1))))
    assert(singleton(List(Fork(Leaf('a', 1), Leaf('b', 1), List('a', 'b'), 1))))
  }

  test("combine of some leaf list") {
    val leaflist = List(
      Leaf('e', 1),
      Leaf('t', 2),
      Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))

    val leaflist2 = List(
      Leaf('e', 3),
      Leaf('t', 4),
      Leaf('x', 6))
    assert(combine(leaflist2) === List(Leaf('x', 6), Fork(Leaf('e', 3), Leaf('t', 4), List('e', 't'), 7)))

    val leaflist3 = List(
      Leaf('x', 6),
      Fork(Leaf('e', 3), Leaf('t', 4), List('e', 't'), 7))
    assert(combine(leaflist3) === List(
      Fork(Leaf('x', 6),
        Fork(Leaf('e', 3), Leaf('t', 4), List('e', 't'), 7),
        List('x', 'e', 't'),
        13)))

  }

  test("combine of some leaf list - less than two elements") {

    val leaflist4 = List(Leaf('x', 6))
    assert(combine(leaflist4) === List(Leaf('x', 6)))
  }

  test("until") {
    val leaflist = List(Leaf('e', 3), Leaf('t', 4), Leaf('x', 6))
    assert(until(singleton, combine)(leaflist) === List(
      Fork(Leaf('x', 6),
        Fork(Leaf('e', 3), Leaf('t', 4), List('e', 't'), 7),
        List('x', 'e', 't'),
        13)))

    val leaflist2 = List(Leaf('a', 1), Leaf('b', 1), Leaf('c', 1), Leaf('d', 1), Leaf('e', 3))
    val exp2 = List(Fork(
      Leaf('e', 3),
      Fork(
        Fork(Leaf('a', 1), Leaf('b', 1), List('a', 'b'), 2),
        Fork(Leaf('c', 1), Leaf('d', 1), List('c', 'd'), 2),
        List('a', 'b', 'c', 'd'), 4),
      List('e', 'a', 'b', 'c', 'd'), 7))

    assert(until(singleton, combine)(leaflist2) === exp2)
  }

  test("create code tree") {
    assert(createCodeTree(string2Chars("etetxxxtxtexx")) ===
      Fork(Leaf('x', 6),
        Fork(Leaf('e', 3), Leaf('t', 4), List('e', 't'), 7),
        List('x', 'e', 't'),
        13))
  }

  test("decode secret") {
    assert(decodedSecret == List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode and encode a larger text should be identical") {
    new TestTrees {
      assert(decode(t2, encode(t2)("abbaddbdd".toList)) === "abbaddbdd".toList)
    }
  }
  
  test("convert to code table") {
    new TestTrees {
      println(convert(t2))
    }
  }
  
  test("decode and quick encode") {
    new TestTrees {
      assert(decode(t2, quickEncode(t2)("abbaddbdd".toList)) === "abbaddbdd".toList)
    }
  }
}
