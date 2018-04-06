package leetcode;

import leetcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a binary tree, return the inorder traversal of its nodes' values.
Note: Recursive solution is trivial, could you do it iteratively?


 */
public class Prob94_medium {

    public static class MyTreeNode extends TreeNode {
        MyTreeNode parent;
        boolean marked;

        public MyTreeNode(int x, MyTreeNode parent){
            super(x);
            parent = null;
            marked = false;
        }
    }

    public MyTreeNode wrapTreeNode(TreeNode root, MyTreeNode parent){
        if(root==null){
            return null;
        }
        MyTreeNode myNode = new MyTreeNode(root.val, parent);
        myNode.parent = parent;
        myNode.left = wrapTreeNode(root.left, myNode);
        myNode.right = wrapTreeNode(root.right, myNode);
        return myNode;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        MyTreeNode current = wrapTreeNode(root, null);
        List<Integer> nodes = new ArrayList<>();
        while(current!=null){
            MyTreeNode left = (MyTreeNode)current.left;
            while(left!=null && !left.marked){
                current = left;
                left = (MyTreeNode)current.left;
            }
            if(!current.marked){
                nodes.add(current.val);
                current.marked = true;
            }
            if(current.right==null || ((MyTreeNode)current.right).marked){
                current = current.parent;
            }else{
                current = (MyTreeNode)current.right;
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.right = new TreeNode(2);
        n1.right.left = new TreeNode(3);


        Prob94_medium prob = new Prob94_medium();
        System.out.println(Arrays.toString(prob.inorderTraversal(n1).toArray())); // [1, 3, 2]
    }
}
