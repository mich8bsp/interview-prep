package leetcode.april30challange



class MinStack() {
  import scala.collection.mutable
  import scala.util.Try

  case class StackNode(value: Int, min: Int)

  /** initialize your data structure here. */
    private val innerBuffer: mutable.Buffer[StackNode] = mutable.Buffer()


  def push(x: Int) {
    val newMin = Try(math.min(getMin(), x)).getOrElse(x)
    innerBuffer.append(StackNode(x, newMin))
  }

  def pop() {
    innerBuffer.remove(innerBuffer.size-1)
  }

  private def topNode(): StackNode = innerBuffer.last

  def top(): Int = {
    topNode().value
  }

  def getMin(): Int = {
    topNode().min
  }
}

object Testy{
  def main(args: Array[String]): Unit = {
    val minStack = new MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) //   --> Returns -3.
    minStack.pop()
    println(minStack.top()) //      --> Returns 0.
    println(minStack.getMin()) //   --> Returns -2.


  }
}