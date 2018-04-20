package ctci.treesgraphs;

import impl.collections.BinaryTree;

import java.util.Optional;

public class Q4_4_CheckBalanced {

    public static <T> boolean checkIfBalanced(BinaryTree<T> tree){
        if(tree==null || (tree.getLeft() == null && tree.getRight()==null)){
            return true;
        }

        boolean isBalancedLeft= checkIfBalanced(tree.getLeft());
        boolean isBalancedRight = checkIfBalanced(tree.getRight());

        if(!isBalancedLeft || !isBalancedRight){
            return false;
        }

        int leftHeight = Optional.ofNullable(tree.getLeft())
                .map(BinaryTree::getHeight)
                .orElse(0);

        int rightHeight = Optional.ofNullable(tree.getRight())
                .map(BinaryTree::getHeight)
                .orElse(0);
        int diff = Math.abs(leftHeight - rightHeight);
        return diff<=1;
    }
}
