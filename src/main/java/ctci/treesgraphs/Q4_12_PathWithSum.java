package ctci.treesgraphs;

import impl.collections.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Q4_12_PathWithSum {

    public static int countPathsWithSum(BinaryTree<Integer> root, int sum){
        List<Integer> paths = new LinkedList<>();
        final int[] sumsCount = new int[1];
        sumsCount[0]=0;
        Runnable onSumFound = () -> sumsCount[0]++;
        countPathsWithSum(root, sum, paths, onSumFound);
        return sumsCount[0];
    }

    private static void countPathsWithSum(BinaryTree<Integer> currNode, int sum, List<Integer> intermediateSums, Runnable onSumFound) {
        if(currNode==null){
            return;
        }
        List<Integer> updatedSums = new LinkedList<>();
        //for path starting from currentNode
        updatedSums.add(0);
        for(Integer prevSum : intermediateSums){
            int newSum = prevSum + currNode.getValue();
            updatedSums.add(newSum);
            if(newSum==sum){
                onSumFound.run();
            }
        }
        countPathsWithSum(currNode.getLeft(), sum, updatedSums, onSumFound);
        countPathsWithSum(currNode.getRight(), sum, updatedSums, onSumFound);
    }
}
