package impl.algo;


import impl.collections.GraphNode;

public class DFS {

    public <T> GraphNode<T> find(GraphNode<T> root, T valueToFind) {
        root.setVisited(true);
        if (root.getValue().equals(valueToFind)) {
            return root;
        }

        for (GraphNode<T> child : root.getChildren()) {
            if(child.isVisited()){
                continue;
            }
            GraphNode<T> found = find(child, valueToFind);
            if(found!=null){
                return found;
            }
        }
        return null;
    }
}