package leetcode.april30challange

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
object SingleNumber {
  def singleNumber(nums: Array[Int]): Int = nums.reduce(_ ^ _)


  def main(args: Array[String]): Unit = {
    println(singleNumber(Array(2,2,1)))
    println(singleNumber(Array(4,1,2,1,2)))
  }
}

