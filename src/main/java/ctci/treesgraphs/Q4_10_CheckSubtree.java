package ctci.treesgraphs;

import impl.collections.BinaryTree;

public class Q4_10_CheckSubtree {

    public static boolean checkSubtree(BinaryTree<Integer> t1, BinaryTree<Integer> t2){
        return compareTrees(t1, t2) || checkSubtree(t1.getLeft(), t2) || checkSubtree(t1.getRight(), t2);
    }

    private static boolean compareTrees(BinaryTree<Integer> subTree, BinaryTree<Integer> t2) {
        if(subTree==t2){
            return true;
        }
        if(subTree == null || t2 == null){
            return false;
        }
        if(!subTree.getValue().equals(t2.getValue())){
            return false;
        }
        return compareTrees(subTree.getLeft(), t2.getLeft()) && compareTrees(subTree.getRight(), t2.getRight());
    }
}
