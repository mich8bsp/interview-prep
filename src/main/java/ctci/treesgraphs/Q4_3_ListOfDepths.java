package ctci.treesgraphs;

import impl.collections.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q4_3_ListOfDepths {

    private static <T> void addNodesToDepthList(BinaryTree<T> tree, int level, List<List<T>> depthsList){
        if(depthsList.get(level)==null){
            depthsList.set(level, new LinkedList<>());
        }
        List<T> nodesAtCurrentDepth = depthsList.get(level);
        nodesAtCurrentDepth.add(tree.getValue());
        if(tree.getLeft()!=null){
            addNodesToDepthList(tree.getLeft(), level+1, depthsList);
        }
        if(tree.getRight()!=null){
            addNodesToDepthList(tree.getRight(), level+1, depthsList);
        }
    }

    public static <T> List<List<T>> createListOfDepths(BinaryTree<T> tree){
        int depth = getDepth(tree);
        if(depth==0){
            return Collections.emptyList();
        }
        List<List<T>> depthsList = new ArrayList<>(depth);
        addNodesToDepthList(tree, 0, depthsList);
        return depthsList;
    }

    private static <T> int getDepth(BinaryTree<T> tree) {
        if(tree==null){
            return 0;
        }
        return 1 + Math.max(getDepth(tree.getLeft()), getDepth(tree.getRight()));
    }
}
