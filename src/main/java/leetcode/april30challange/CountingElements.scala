package leetcode.april30challange

object CountingElements {

  def countElements(arr: Array[Int]): Int = {
    val elementToCount: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map()

    arr.foreach(x => {
      elementToCount.put(x, elementToCount.getOrElse(x, 0) + 1)
    })

    elementToCount.map({
      case (x, c) => elementToCount.get(x + 1).map(_ => c).getOrElse(0)
    }).sum
  }

  def main(args: Array[String]): Unit = {
//    val arr = Array(1,2,3)
//    val arr = Array(1,1,3,3,5,5,7,7)
//    val arr = Array(1,3,2,3,5,0)
    val arr = Array(1,1,2,2)
    println(countElements(arr))
  }
}
