package leetcode.april30challange



class ListNode(var _x: Int = 0){
  var next: ListNode = null
  var x: Int = _x

  override def toString: String = {
    x.toString + "->" + {
      if(next == null) "NULL" else next.toString
    }
  }
}

object MiddleList {

  def middleNode(head: ListNode): ListNode = {
    import scala.util.Try
    def middleNodeInner(curr: ListNode, doubleSpeedCurr: ListNode): ListNode = {
      if(doubleSpeedCurr==null){
        curr
      }else{
        middleNodeInner(curr.next, Try(doubleSpeedCurr.next.next).getOrElse(null))
      }
    }

    middleNodeInner(head, head.next)
  }

  def main(args: Array[String]): Unit = {
      val lst = new ListNode(1)
      var curr = lst
      Range(1, 6).foreach(i => {
        curr.next = new ListNode(i+1)
        curr = curr.next
      })

      println(middleNode(lst))
  }
}
