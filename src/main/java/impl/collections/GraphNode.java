package impl.collections;

import java.util.LinkedList;
import java.util.List;

public class GraphNode<T> {
    private T value;
    private List<GraphNode<T>> children;
    private boolean visited = false;

    public GraphNode(T value) {
        this.value = value;
        this.children = new LinkedList<>();
    }

    public GraphNode(T value, List<GraphNode<T>> children){
        this.value = value;
        this.children = children;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<GraphNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<GraphNode<T>> children) {
        this.children = children;
    }
}
