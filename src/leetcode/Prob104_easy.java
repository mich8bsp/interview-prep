package leetcode;

import leetcode.helper.TreeNode;

/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Prob104_easy {



    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        n1.left = new TreeNode(9);
        n1.right = new TreeNode(20);
        n1.right.left = new TreeNode(15);
        n1.right.right = new TreeNode(7);

        Prob104_easy prob = new Prob104_easy();
        System.out.println(prob.maxDepth(n1)); //3
    }
}
