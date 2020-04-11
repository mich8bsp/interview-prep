package leetcode.april30challange

class TreeNode(var _value: Int) {
     var value: Int = _value
     var left: TreeNode = null
     var right: TreeNode = null
   }

object BinaryTreeDiameter {

  def depth(node: TreeNode): Int = {
    if(node==null){
      0
    }else{
      1 + math.max(depth(node.left), depth(node.right))
    }
  }

  def diameterOfBinaryTree(root: TreeNode): Int = {
    if(root==null){
      0
    }else {
      val leftDepth = depth(root.left)
      val rightDepth = depth(root.right)
      val diameterOfLeft = diameterOfBinaryTree(root.left)
      val diameterOfRight = diameterOfBinaryTree(root.right)

      math.max(leftDepth + rightDepth, math.max(diameterOfLeft, diameterOfRight))
    }
  }

  def main(args: Array[String]): Unit = {

  }
}
