package ctci.treesgraphs;

import impl.collections.GraphNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q4_1_CheckRoute {

    public static <T> boolean checkRoute(GraphNode<T> start, GraphNode<T> end) {
        start.setVisited(true);
        Queue<GraphNode<T>> bfsQueue = new LinkedList<>();
        bfsQueue.add(start);
        while (!bfsQueue.isEmpty()) {
            GraphNode<T> currentNode = bfsQueue.poll();
            if (currentNode == end) {
                return true;
            }
            currentNode.getChildren().stream()
                    .filter(child -> !child.isVisited())
                    .peek(child -> child.setVisited(true))
                    .forEach(child -> bfsQueue.add(child));
        }
        return false;
    }
}
