package leetcode.april30challange


object ContiguousArray {

  import scala.collection.mutable
  def findMaxLength(nums: Array[Int]): Int = {
    val balanceToIdxs: mutable.Map[Int, Int] = mutable.Map()

    balanceToIdxs.put(0, -1)
    var balance: Int = 0
    var maxSoFar: Int = 0
    nums.indices.foreach(i => {
      balance += (nums(i) + (1 - nums(i)) * (-1))
      val prevBalanceIdx = balanceToIdxs.get(balance)
      prevBalanceIdx match {
        case Some(v) => maxSoFar = math.max(maxSoFar, i - v)
        case None => balanceToIdxs.put(balance, i)
      }
    })

    maxSoFar
  }

  def main(args: Array[String]): Unit = {
//    println(findMaxLength(Array(0, 1, 0, 1)))
        println(findMaxLength(Array(1,1,1,0,0,1,0,1,1,0)))
//        println(findMaxLength(Array(1,1,1)))
//        println(findMaxLength(Array(1,0)))
//        println(findMaxLength(Array(0,1,0)))
  }
}
