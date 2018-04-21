package ctci.treesgraphs;

import impl.collections.BinaryTree;

public class Q4_8_FirstCommonAncestor {


    public static <T> BinaryTree<T> findCommonAncestor(BinaryTree<T> root, BinaryTree<T> node1, BinaryTree<T> node2) {
        return commonAncestorOrElseNode(root, node1, node2);
    }

    private static <T> BinaryTree<T> commonAncestorOrElseNode(BinaryTree<T> root, BinaryTree<T> node1, BinaryTree<T> node2) {
        BinaryTree<T> commonAncestorInLeft = null;
        BinaryTree<T> commonAncestorInRight = null;

        if (root == node1 || root == node2) {
            //if root is one of the nodes, there could be no common ancestor so we return the node itself
            return root;
        }
        if (root.getLeft() != null) {
            commonAncestorInLeft = commonAncestorOrElseNode(root.getLeft(), node1, node2);
        }
        if (root.getRight() != null) {
            commonAncestorInRight = commonAncestorOrElseNode(root.getRight(), node1, node2);
        }
        if(commonAncestorInLeft==null && commonAncestorInRight==null){
            return null;
        }
        if(commonAncestorInLeft!=null && commonAncestorInRight==null){
            return commonAncestorInLeft;
        }
        if(commonAncestorInRight!=null && commonAncestorInLeft==null){
            return commonAncestorInRight;
        }
        //if both common ancestor in left and right are not null then they must be each of the nodes so root is the common ancestor
        return root;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(54);
        BinaryTree<Integer> left = new BinaryTree<>(4);
        BinaryTree<Integer> right = new BinaryTree<>(6);
        BinaryTree<Integer> ll = new BinaryTree<>(45);
        BinaryTree<Integer> lr = new BinaryTree<>(46);
        BinaryTree<Integer> rr = new BinaryTree<>(47);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(ll);
        left.setRight(lr);
        right.setRight(rr);

        System.out.println(findCommonAncestor(root, ll, lr)); //4
        System.out.println(findCommonAncestor(root, ll, rr)); //54
    }
}
