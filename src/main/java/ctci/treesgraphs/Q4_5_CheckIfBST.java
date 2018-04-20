package ctci.treesgraphs;

import impl.collections.BinaryTree;

import java.util.Optional;

public class Q4_5_CheckIfBST {

    public static <T extends Comparable> boolean isBST(BinaryTree<T> tree){
        if(tree == null || (tree.getLeft()==null && tree.getRight()==null)){
            return true;
        }

        boolean isLeftBST = isBST(tree.getLeft());
        boolean isRightBST = isBST(tree.getRight());

        if(!isLeftBST || !isRightBST){
            return false;
        }

        boolean isGTELeft = Optional.ofNullable(tree.getLeft())
                .map(x->tree.getValue().compareTo(x.getValue())>=0)
                .orElse(true);

        boolean isLTRight = Optional.ofNullable(tree.getRight())
                .map(x->tree.getValue().compareTo(x.getValue())<0)
                .orElse(true);

        return isGTELeft && isLTRight;
    }
}
