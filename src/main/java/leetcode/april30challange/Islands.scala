package leetcode.april30challange



object Islands {
  import scala.util.Try
  import scala.collection.mutable

  def getNeighborsOfCell(grid: Array[Array[Char]], i: Int, j: Int): Set[Char] = {

    Try(grid(i-1)(j)).toOption.toSet ++
    Try(grid(i+1)(j)).toOption.toSet ++
    Try(grid(i)(j-1)).toOption.toSet ++
    Try(grid(i)(j+1)).toOption.toSet
  }

  def getUnvisitedLandNeighbors(grid: Array[Array[Char]], i: Int, j: Int): Seq[(Int, Int)] = {
    Seq((i-1, j), (i+1, j), (i, j-1), (i, j+1))
      .filter({
        case (currI, currJ) =>
          val cellContent: Option[Char] = Try(grid(currI)(currJ)).toOption
          cellContent.contains('1')
      })
  }

  def numIslands(grid: Array[Array[Char]]): Int = {
    if(grid.isEmpty){
      0
    }else{
      val n = grid.length
      val m = grid(0).length

      var islandsCounter: Int = 0

      val cellsForProcessing: mutable.Set[(Int, Int)] = mutable.Set()

      for{
        i <- 0 until n
        j <- 0 until m
      }yield {
        if(grid(i)(j) == '1'){
          islandsCounter += 1
          cellsForProcessing.add((i, j))
        }
        while(cellsForProcessing.nonEmpty){
          val (currI, currJ) = cellsForProcessing.head
          cellsForProcessing.remove((currI, currJ))
          grid(currI)(currJ) = 'x'
          getUnvisitedLandNeighbors(grid, currI, currJ).foreach(cellsForProcessing.add)
        }
      }

      islandsCounter

    }

  }

  def main(args: Array[String]): Unit = {
    println(numIslands(Array(
      Array('1', '1', '1'),
      Array('0', '1', '0'),
      Array('1', '1', '1'))
    ))
  }
}
