package leetcode.april30challange

object MaximumSubarray {

  def maxSubArray(nums: Array[Int]): Int = {
    if(nums.forall(_ < 0)){
      nums.max
    }else {
      var currSum = 0
      var maxSubarraySum = 0
      for {
        n <- nums
      } yield {
        currSum = currSum + n
        if (currSum < 0) {
          currSum = 0
        }
        if (maxSubarraySum < currSum) {
          maxSubarraySum = currSum
        }
      }

      maxSubarraySum
    }
  }

  def main(args: Array[String]): Unit = {
    println(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(Array(-2, -1)))
  }
}
