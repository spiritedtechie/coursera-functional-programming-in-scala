package funsets

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import FunSets.contains
import FunSets.diff
import FunSets.exists
import FunSets.filter
import FunSets.forall
import FunSets.intersect
import FunSets.map
import FunSets.singletonSet
import FunSets.union
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  test("singletonSet(1) contains 1") {

    new TestSets {
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains all shared elements - one element") {
    new TestSets {
      val s = intersect(s3, s3)
      assert(!contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")
      assert(contains(s, 3), "Intersect 3")
    }
  }

  test("intersect contains all shared elements - multiple elements") {
    new TestSets {
      val su1 = union(union(s1, s2), s3)
      val su2 = union(s2, s3)

      val s = intersect(su1, su2)
      assert(!contains(s, 1), "Intersect 1")
      assert(contains(s, 2), "Intersect 2")
      assert(contains(s, 3), "Intersect 3")
    }
  }

  test("diff of a first set is all elements not in second set") {
    new TestSets {
      val su1 = union(union(s1, s2), s3)
      val su2 = union(s2, s3)

      val s = diff(su1, su2)
      assert(contains(s, 1), "Diff 1")
      assert(!contains(s, 2), "Diff 2")
      assert(!contains(s, 3), "Diff 3")
    }
  }

  test("filter only contains elements matching a predicate") {
    new TestSets {
      val su1 = union(union(s1, s2), s3)

      val s = filter(su1, x => x <= 2)
      assert(contains(s, 1), "Filter 1")
      assert(contains(s, 2), "Filter 2")
      assert(!contains(s, 3), "Filter 3")
    }
  }

  test("forall where all elements match predicate") {
    new TestSets {
      val su1 = union(union(s1, s2), s3)

      val s = filter(su1, x => x <= 2)
      assert(contains(s, 1), "Filter 1")
      assert(contains(s, 2), "Filter 2")
      assert(!contains(s, 3), "Filter 3")
    }
  }

  test("forall where all elements do match predicate") {
    new TestSets {
      val su1 = union(union(s1, s2), s3)
      val su2 = union(union(s3, s3), s3)

      assert(forall(su1, x => x < 4), "ForAll 1")
      assert(forall(su1, x => x <= 3), "ForAll 2")
      assert(forall(su1, x => x >= 0), "ForAll 3")
      assert(forall(su1, x => x > -1000), "ForAll 4")
      assert(forall(su2, x => x == 3), "ForAll 5")
    }
  }

  test("forall where an element in set does NOT match predicate") {
    new TestSets {
      val su1 = union(union(s1, s2), s3)

      assert(!forall(su1, x => x == 0), "ForAll 1")
      assert(!forall(su1, x => x > 3), "ForAll 2")
    }
  }

  test("exists where sets contains at least one matching element") {
    new TestSets {
      val su1 = union(union(s1, s2), s3)

      assert(exists(su1, x => x == 1), "Exists 1")
      assert(exists(su1, x => x > 1), "Exists 2")
    }
  }

  test("exists where sets does not contain at least one matching element") {
    new TestSets {
      val su1 = union(union(s1, s2), s3)

      assert(!exists(su1, x => x == 5), "Exists 1")
      assert(!exists(su1, x => x < 1), "Exists 2")
    }
  }

  test("map of a set applying a mapping function") {
    new TestSets {
      val su1 = union(union(s1, s2), s3)

      val set = map(su1, x => 2 * x)
      assert(contains(set, 2), "Map 1")
      assert(contains(set, 4), "Map 2")
      assert(contains(set, 6), "Map 3")

      val set2 = map(su1, x => x * x)
      assert(contains(set2, 1), "Map 4")
      assert(contains(set2, 4), "Map 5")
      assert(contains(set2, 9), "Map 6")
    }
  }
}
