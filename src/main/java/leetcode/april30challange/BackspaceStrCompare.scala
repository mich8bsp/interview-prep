package leetcode.april30challange

object BackspaceStrCompare {

  def backspaceCompare(S: String, T: String): Boolean = {
    var sIdx = S.length-1
    var tIdx = T.length-1

    var sDeletions = 0
    var tDeletions = 0
    var comparisonPassed = true
    while((sIdx >= 0 || tIdx >= 0) && comparisonPassed){
      var currSToCompare: Option[Char] = None
      if(sIdx>=0) {
        if (S(sIdx) == '#') {
          sDeletions += 1
          sIdx -= 1
        } else if (sDeletions > 0) {
          sDeletions -= 1
          sIdx -= 1
        } else {
          currSToCompare = Some(S(sIdx))
        }
      }
      var currTToCompare: Option[Char] = None
      if(tIdx>=0) {
        if (T(tIdx) == '#') {
          tDeletions += 1
          tIdx -= 1
        } else if (tDeletions > 0) {
          tDeletions -= 1
          tIdx -= 1
        } else {
          currTToCompare = Some(T(tIdx))
        }
      }

      (currSToCompare, currTToCompare) match {
        case (Some(sChar), Some(tChar)) => {
          if(sChar!=tChar){
            comparisonPassed = false
          }else{
            sIdx -= 1
            tIdx -= 1
          }
        }
        case (None, Some(_)) if sIdx<0 || tIdx<0 => comparisonPassed = false
        case (Some(_), None) if sIdx<0 || tIdx<0 => comparisonPassed = false
        case _ =>
      }
    }

    comparisonPassed
  }

  def main(args: Array[String]): Unit = {
    println(backspaceCompare("ab#c", "ad#c"))
    println(backspaceCompare("ab##", "c#d#"))
    println(backspaceCompare("a##c", "#a#c"))
    println(backspaceCompare("a#c", "b"))
    println(backspaceCompare("bxj##tw", "bxj###tw"))
  }
}
