package com.github.myyk.cracking

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class Chapter5SolutionsTest extends FlatSpec with Matchers {
  implicit def enrichStringContext(sc: StringContext) = new RichStringContext(sc)

  class RichStringContext(sc: StringContext) {
    def b() = {
      def parseBinary(s: String): Int = {
        var i = s.length - 1
        var sum = 0
        var mult = 1
        while (i >= 0) {
          s.charAt(i) match {
            case '1' => sum += mult
            case '0' =>
          }
          mult *= 2
          i -= 1
        }
        sum
      }
      val s = sc.parts.mkString
      parseBinary(s)
    }

  }

  "insert" should "insert the integer into the other" in {
    //    Chapter5Solutions.insert(0, 0, 0, 0) shouldBe 0
    Chapter5Solutions.insert(1, 1, 0, 0) shouldBe 1
    Chapter5Solutions.insert(1, 1, 0, 0) shouldBe 1
    Chapter5Solutions.insert(2, 1, 0, 0) shouldBe 3
    Chapter5Solutions.insert(1, 1, 1, 1) shouldBe 3
    Chapter5Solutions.insert(1, b"111", 8, 6) shouldBe b"111000001"
    Chapter5Solutions.insert(b"101000000000", b"1101", 4, 2) shouldBe b"101000110100"
    Chapter5Solutions.insert(~0, b"1101", 4, 2) shouldBe ~0 ^ (b"1111"<<2) | (b"1101"<<2)
    Chapter5Solutions.insert(b"111111", b"1010", 4, 1) shouldBe b"110101"
  }

}