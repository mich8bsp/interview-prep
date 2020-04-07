package leetcode.april30challange


object GroupAnagrams {

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    import scala.collection.mutable

    val canonicalAnagramToList: mutable.Map[String, mutable.Buffer[String]] = mutable.Map()

    strs.foreach(str => {
      val canonical = str.sorted
      canonicalAnagramToList.getOrElseUpdate(canonical, mutable.Buffer())
        .append(str)
    })

    canonicalAnagramToList.values
      .map(_.toList).toList

  }

  def main(args: Array[String]): Unit = {
    val grouped = groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat"))

    grouped.foreach(x => println(x.mkString(", ")))
  }
}
