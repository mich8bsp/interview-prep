package leetcode.april30challange

object ValidParenStr {

  def checkValidString(s: String): Boolean = {
    var balanceMin: Int = 0
    var balanceMax: Int = 0
    var isValid: Boolean = true
    s.foreach(c =>
      if (isValid) {
        c match {
          case '(' =>
            balanceMin += 1
            balanceMax += 1
          case ')' =>
            balanceMin -= 1
            balanceMax -= 1
          case '*' =>
            balanceMin -= 1
            balanceMax += 1
        }
        if (balanceMin < 0) {
          balanceMin = 0
        }
        if (balanceMax < 0) {
          isValid = false
        }
      })

    isValid && balanceMin == 0
  }

  def main(args: Array[String]): Unit = {
    //    println(checkValidString("(*)"))
    //    println(checkValidString("(*))"))
    //    println(checkValidString("*"))
    //    println(checkValidString(""))
    //    println(checkValidString("((*)"))
    //    println(checkValidString("()*)"))
    //    println(checkValidString(")((*)"))
    //    println(checkValidString("((*)(*()(())())())()()((()())((()))(*"))
    println(checkValidString("(**((*"))
  }
}
