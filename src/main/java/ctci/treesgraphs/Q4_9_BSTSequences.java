package ctci.treesgraphs;

import impl.collections.BinaryTree;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q4_9_BSTSequences {

    public static List<Integer[]> buildSequences(BinaryTree<Integer> tree) {
        List<List<Integer>> sequences = new LinkedList<>();
        sequences = buildSubSequences(tree);
        return sequences.stream()
                .map(x -> x.toArray(new Integer[0]))
                .collect(Collectors.toList());
    }

    private static List<List<Integer>> buildSubSequences(BinaryTree<Integer> tree) {
        List<List<Integer>> subSequences = new LinkedList<>();
        List<List<Integer>> leftSubtreeSequences = new LinkedList<>();
        List<List<Integer>> rightSubtreeSequences = new LinkedList<>();
        if (tree.getLeft() != null) {
            leftSubtreeSequences = buildSubSequences(tree.getLeft());
        }
        if (tree.getRight() != null) {
            rightSubtreeSequences = buildSubSequences(tree.getRight());
        }
        if (leftSubtreeSequences.isEmpty() && rightSubtreeSequences.isEmpty()) {
            subSequences.add(new LinkedList<>());
        } else if (leftSubtreeSequences.isEmpty()) {
            subSequences.addAll(rightSubtreeSequences);
        } else if (rightSubtreeSequences.isEmpty()) {
            subSequences.addAll(leftSubtreeSequences);
        } else {
            subSequences.addAll(carteseLists(leftSubtreeSequences, rightSubtreeSequences));
        }

        for (List<Integer> subseq : subSequences) {
            subseq.add(0, tree.getValue());
        }
        return subSequences;
    }

    private static List<List<Integer>> carteseLists(List<List<Integer>> leftSubtreeSequences, List<List<Integer>> rightSubtreeSequences) {
        List<List<Integer>> cartese = new LinkedList<>();
        for (List<Integer> left : leftSubtreeSequences) {
            for (List<Integer> right : rightSubtreeSequences) {
                List<Integer> combined = new LinkedList<>();
                combined.addAll(left);
                combined.addAll(right);
                cartese.add(combined);
                combined = new LinkedList<>();
                combined.addAll(right);
                combined.addAll(left);
                cartese.add(combined);
            }
        }
        return cartese;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(2);
        tree.setLeft(new BinaryTree<>(1));
        tree.setRight(new BinaryTree<>(10));
        buildSequences(tree).stream().map(Arrays::toString).forEach(System.out::println);

        tree.getRight().setRight(new BinaryTree<>(12));
        buildSequences(tree).stream().map(Arrays::toString).forEach(System.out::println);
    }
}
