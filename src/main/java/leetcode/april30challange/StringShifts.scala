package leetcode.april30challange

object StringShifts {

  def consolidateShifts(shifts: Array[Array[Int]]): Int = {
    var totalShift = 0
    for{
      shiftArr <- shifts
    }yield{
      val Array(direction, shift) = shiftArr
      totalShift += (shift * (if(direction==0) -1 else 1))
    }
    totalShift
  }

  def fixShiftsToString(shifts: Int, str: String): Int = shifts match {
    case 0 => 0
    case x if x>0 => shifts % str.length
    case _ => -fixShiftsToString(-shifts, str)
  }

  def stringShift(s: String, shift: Array[Array[Int]]): String = {
    val totalShift: Int = consolidateShifts(shift)

    fixShiftsToString(totalShift, s) match {
      case 0 => s
      case x if x>0 => {
        val (preShift, shiftedPart) = s.splitAt(s.length - x)
        shiftedPart + preShift
      }
      case x if x<0 =>{
        val (shiftedPart, preShift) = s.splitAt(x*(-1))
        preShift + shiftedPart
      }
    }
  }

  def main(args: Array[String]): Unit = {
//    println(stringShift("abc", Array(Array(0,1), Array(1,2))))
//    println(stringShift("abcdefg", Array(Array(1,1), Array(1,1), Array(0,2), Array(1,3))))
    println(stringShift("xqgwkiqpif", Array(Array(1,4), Array(0,7), Array(0,8), Array(0,7),
      Array(0, 6), Array(1,3), Array(0, 1), Array(1,7), Array(0,5), Array(0,6))))
  }
}
