package leetcode

import scala.collection.mutable


case class Palindrome(startIdx: Int, length: Int, str: String)

object Prob5_medium {

  def buildPalindromsByLength(s: String, length: Int = 2, currMap: mutable.Map[Int, mutable.Buffer[Palindrome]] = mutable.Map()): mutable.Map[Int, mutable.Buffer[Palindrome]] = length match {
    case 2 => {
      Range(0, s.length-1).foreach(i => {
        if(s(i) == s(i+1)){
          val palindromesList = currMap.getOrElseUpdate(length, mutable.Buffer[Palindrome]())
          palindromesList.append(Palindrome(i, length, s(i).toString * 2))
        }
      })
      buildPalindromsByLength(s, length+1, currMap)
    }
    case 3 => {
      Range(0, s.length-2).foreach(i => {
        if(s(i) == s(i+2)){
          val palindromesList = currMap.getOrElseUpdate(length, mutable.Buffer[Palindrome]())
          palindromesList.append(Palindrome(i, length, s(i).toString + s(i+1) + s(i)))
        }
      })
      buildPalindromsByLength(s, length+1, currMap)
    }
    case x if x > s.length => {
      currMap
    }
    case currLength => {
      val subpalindromes = currMap.getOrElse(currLength-2, mutable.Buffer())
      val newPalindromes = subpalindromes.flatMap(subPal => {
        if(subPal.startIdx>0 && subPal.startIdx + subPal.length < s.length){
          if(s(subPal.startIdx-1) == s(subPal.startIdx + subPal.length)){
            Some(Palindrome(subPal.startIdx-1, currLength, s(subPal.startIdx-1) + subPal.str + s(subPal.startIdx-1)))
          }else{
            None
          }
        }else{
          None
        }
      })
      if(newPalindromes.nonEmpty){
        currMap.put(currLength, newPalindromes)
      }
      if(newPalindromes.isEmpty && currMap.get(currLength-1).isEmpty){
        currMap
      }else{
        buildPalindromsByLength(s, length+1, currMap)
      }
    }
  }

  def findPalindromeFromCenter(str: String, left: Int, rightOpt: Option[Int] = None): Int = {
    var rIdx = rightOpt.getOrElse(left)
    var lIdx = left
    while(lIdx >= 0 && rIdx < str.length && str(lIdx) == str(rIdx)){
      lIdx -= 1
      rIdx += 1
    }
    rIdx - lIdx - 1
  }

  def longestPalindrome(s: String): String = {
    if(s.length<2){
      s
    }else{
      var rIdx = 0
      var lIdx = 0
      Range(0, s.length).foreach(i => {
        val palindromeLengthFromCenter = findPalindromeFromCenter(s, i)
        val palindromeLengthFromCenterEven = findPalindromeFromCenter(s, i, Some(i+1))

        val currMaxLength = math.max(palindromeLengthFromCenter, palindromeLengthFromCenterEven)

        if(currMaxLength > rIdx - lIdx){
          lIdx = i - (currMaxLength - 1)/2
          rIdx = i + currMaxLength / 2
        }
      })

      s.substring(lIdx, rIdx+1)
    }

  }

  def main(args: Array[String]): Unit = {

    println(longestPalindrome("aaaaaaaaa"))
    println(longestPalindrome("aaaaaaaaaa"))
  }
}
