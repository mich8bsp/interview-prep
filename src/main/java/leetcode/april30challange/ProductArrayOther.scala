package leetcode.april30challange

object ProductArrayOther {

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val forwardProduct: Array[Int] = Array.ofDim(nums.length)
    val backwardProduct: Array[Int] = Array.ofDim(nums.length)
    nums.indices.foreach(i => {
      if(i==0){
        forwardProduct(i) = 1
      }else{
        forwardProduct(i) = forwardProduct(i-1) * nums(i-1)
      }
    })

    nums.indices.reverse.foreach(i => {
      if(i==nums.length-1){
        backwardProduct(i) = 1
      }else{
        backwardProduct(i) = backwardProduct(i+1) * nums(i+1)
      }
    })

    val res: Array[Int] = Array.ofDim(nums.length)
    nums.indices.foreach(i => {
      res(i) = forwardProduct(i) * backwardProduct(i)
    })

    res
  }

  def main(args: Array[String]): Unit = {
        println(productExceptSelf(Array(1,2,3,4)).mkString(","))
  }
}
