package leetcode.april30challange

object SearchRotated {

  def searchInRotated(nums: Array[Int], target: Int, lowIdx: Int, highIdx: Int): Int = {
    val middleIdx = (lowIdx + highIdx)/2
    val middle = nums(middleIdx)

    if(middle==target){
      middleIdx
    }else{
      lazy val foundInFirstHalf = searchUndetermined(nums, target, lowIdx, middleIdx)
      lazy val foundInSecondHalf = searchUndetermined(nums, target, middleIdx+1, highIdx)
      if(foundInFirstHalf != -1){
        foundInFirstHalf
      }else{
        foundInSecondHalf
      }
    }
  }

  def searchInSorted(nums: Array[Int], target: Int, lowIdx: Int, highIdx: Int): Int = {

    val first = nums(lowIdx)
    val last = nums(highIdx)
    if(target<first || target > last){
      -1
    }else{
      val middleIdx = (lowIdx + highIdx)/2
      val middle = nums(middleIdx)
      if(target>middle){
        searchInSorted(nums, target, lowIdx = middleIdx+1, highIdx = highIdx)
      }else if(target<middle){
        searchInSorted(nums, target, lowIdx = lowIdx, highIdx = middleIdx-1)
      }else{
        middleIdx
      }
    }
  }

  def searchUndetermined(nums: Array[Int], target: Int, lowIdx: Int, highIdx: Int): Int = {
    if(highIdx-lowIdx < 0){
      -1
    }else if(highIdx-lowIdx==0){
      if(nums(lowIdx)==target) lowIdx else -1
    }else{
      val first = nums(lowIdx)
      val last = nums(highIdx)
      if(first<last){
        searchInSorted(nums, target, lowIdx, highIdx)
      }else{
        searchInRotated(nums, target, lowIdx, highIdx)
      }
    }
  }

  def search(nums: Array[Int], target: Int): Int = {
    searchUndetermined(nums, target, 0, nums.length-1)
  }

  def main(args: Array[String]): Unit = {
    println(search(Array(1,3), 2))
    println(search(Array(4,6,7,0,1,2), 0))
    println(search(Array(4,5,6,7,0,1,2), 0))
    println(search(Array(4,5,6,7,0,1,2), 3))
  }
}
