package ctci.treesgraphs;

import impl.collections.BinaryTree;

public class Q4_6_FindSuccessor {

    public static <T> BinaryTree<T> findSuccessor(BinaryTree<T> node){
        if(node==null){
            return null;
        }
        BinaryTree<T> leftMostFromRight = findLeftMostFromRightSubtree(node);
        if(node!=leftMostFromRight){
            return leftMostFromRight;
        }
        if(node.getParent()==null){
            return null;
        }

        if(node.getParent().getLeft()==node){
            return node.getParent();
        }else{
            while(node.getParent()!=null && node.getParent().getRight()==node){
                node = node.getParent();
            }
            if(node.getParent()==null){
                return null;
            }
            return findLeftMostFromRightSubtree(node.getParent());
        }
    }

    private static <T> BinaryTree<T> findLeftMostFromRightSubtree(BinaryTree<T> node){
        if(node.getRight()!=null){
            BinaryTree<T> leftMost = node.getRight();
            while(leftMost.getLeft()!=null){
                leftMost = leftMost.getLeft();
            }
            return leftMost;
        }else{
            return node;
        }
    }
}
