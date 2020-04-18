package leetcode.april30challange


object MinimumPathSum {
  import scala.collection.mutable

  def minPathSum(grid: Array[Array[Int]]): Int = {

    val rows: Int = grid.length
    val cols: Int = grid(0).length

    val cache: mutable.Map[(Int, Int), Int] = mutable.Map()

    def minPathSumInner(grid: Array[Array[Int]], i: Int, j: Int): Int = {
      if((i, j) == (rows-1, cols-1)){
          val currRes = grid(i)(j)
          cache.put((i,j), currRes)
          currRes
      }else{
        lazy val resDown = cache.getOrElseUpdate((i+1, j), minPathSumInner(grid, i+1, j))
        lazy val resRight = cache.getOrElseUpdate((i, j+1), minPathSumInner(grid, i, j+1))

        val nextStepRes = if(i==rows-1){
          resRight
        }else if(j==cols-1){
          resDown
        }else{
          math.min(resDown, resRight)
        }

        val currRes = grid(i)(j) + nextStepRes

        cache.put((i,j), currRes)

        currRes
      }
    }

    minPathSumInner(grid, 0, 0)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(
      Array(1,3,1),
      Array(1,5,1),
      Array(4,2,1)
    )

    println(minPathSum(arr))
  }
}
