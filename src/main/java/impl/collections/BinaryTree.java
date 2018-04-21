package impl.collections;

import java.util.Optional;

public class BinaryTree<T> {
    private T value;

    private int height = 0;

    private BinaryTree<T> left;
    private BinaryTree<T> right;

    private BinaryTree<T> parent;

    public BinaryTree(T value) {
        this.value = value;
        updateHeight();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
        updateHeight();
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
        updateHeight();
    }

    private void updateHeight() {
        int leftHeight = Optional.ofNullable(left)
                .map(BinaryTree::getHeight)
                .orElse(0);
        int rightHeight = Optional.ofNullable(right)
                .map(BinaryTree::getHeight)
                .orElse(0);
        this.height = Math.max(leftHeight, rightHeight) + 1;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BinaryTree<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTree<T> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "value=" + value +
                '}';
    }
}
