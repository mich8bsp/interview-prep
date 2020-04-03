package leetcode.april30challange

import scala.collection.mutable

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 */
object HappyNumber {

  def isHappy(n: Int): Boolean = {
    def isHappyInner(n: Int, checked: mutable.Set[Int] = mutable.Set()): Boolean = n match {
      case 1 => true
      case x if checked.contains(x) => false
      case _ => {
        var rest = n
        var sum = 0
        while (rest > 0) {
          sum = sum + math.pow(rest % 10, 2).toInt
          rest = rest / 10
        }
        checked.add(n)
        isHappyInner(sum, checked)
      }
    }

    isHappyInner(n)
  }

  def main(args: Array[String]): Unit = {
    println(isHappy(2))
    println(isHappy(19))
  }
}
