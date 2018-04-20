package impl.algo;

import impl.collections.GraphNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BFS {

    public <T> GraphNode<T> find(GraphNode<T> root, T valueToFind){
        Queue<GraphNode<T>> bfsQueue = new LinkedList<>();
        GraphNode<T> currentNode;
        bfsQueue.add(root);
        root.setVisited(true);
        while(!bfsQueue.isEmpty()){
            currentNode = bfsQueue.poll();
            if(currentNode!=null){
                if(currentNode.getValue().equals(valueToFind)){
                    return currentNode;
                }
                currentNode.setVisited(true);
                List<GraphNode<T>> childrenToVisit = currentNode.getChildren().stream()
                        .filter(x->!x.isVisited())
                        .peek(x->x.setVisited(true))
                        .collect(Collectors.toList());
                bfsQueue.addAll(childrenToVisit);
            }
        }
        return null;
    }
}
