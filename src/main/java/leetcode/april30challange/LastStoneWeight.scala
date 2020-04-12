package leetcode.april30challange


object LastStoneWeight {

  def lastStoneWeight(stones: Array[Int]): Int = {
    import scala.collection.mutable
    val stonesByWeight: mutable.PriorityQueue[Int] = mutable.PriorityQueue(stones: _*)
    while (stonesByWeight.size > 1) {
      val stone1 = stonesByWeight.dequeue()
      val stone2 = stonesByWeight.dequeue()
      val res = math.abs(stone1 - stone2)
      if (res > 0) {
        stonesByWeight.enqueue(res)
      }
    }
    stonesByWeight.headOption.getOrElse(0)
  }

  def main(args: Array[String]): Unit = {
    println(lastStoneWeight(Array(2, 7, 4, 1, 8, 1)))
  }
}
