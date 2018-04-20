package ctci.treesgraphs;

import impl.collections.BinaryTree;
import impl.collections.GraphNode;

public class Q4_2_MinimalTree {

    public static BinaryTree<Integer> createMinBST(int[] arr){
        if(arr.length==1){
            return new BinaryTree<>(arr[0]);
        }
        if(arr.length==2){
            BinaryTree<Integer> root = new BinaryTree<>(arr[1]);
            root.setLeft(createMinBST(new int[]{arr[0]}));
            return root;
        }
        int middleIdx = arr.length / 2;
        BinaryTree<Integer> root = new BinaryTree<>(arr[middleIdx]);
        //if arr length is odd, then dividing by 2 will give us the size of both sides
        // for example for 3, arr.length/2 will give 1 for each size

        //if arr length is even, then dividing by 2 will give the size of left but the size of right should be one less
        // because we used one element for middle.
        // for example for 4, arr.lenght/2 will give 2, so left should be [0, 1] middle is [2] and right should be [3]
        int[] leftSubTree = new int[arr.length/2];
        int[] rightSubTree = new int[arr.length - leftSubTree.length - 1];
        System.arraycopy(arr, 0, leftSubTree, 0, leftSubTree.length);
        System.arraycopy(arr, middleIdx+1, rightSubTree, 0, rightSubTree.length);
        root.setLeft(createMinBST(leftSubTree));
        root.setRight(createMinBST(rightSubTree));
        return root;
    }
}
