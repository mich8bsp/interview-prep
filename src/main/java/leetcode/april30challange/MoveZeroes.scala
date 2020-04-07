package leetcode.april30challange

object MoveZeroes {

    def moveZeroes(nums: Array[Int]): Unit = {
      var nonZeroesSoFar = 0
      nums.indices.foreach(i => {
        val currInArray = nums(i)
          if (currInArray != 0) {
            nums(nonZeroesSoFar) = currInArray
            if(nonZeroesSoFar!=i){
              nums(i) = 0
            }
            nonZeroesSoFar += 1
          }
      })
    }
  def main(args: Array[String]): Unit = {
    val nums = Array(1,0,0,3,12,0)
    moveZeroes(nums)
    println(nums.mkString(", "))
  }
}
