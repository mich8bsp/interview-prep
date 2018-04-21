package ctci.treesgraphs;

import java.util.Optional;

public class Q4_11_RandomNode {

    class BinarySearchTree {
        /* Class containing left and right child of current node and key value*/
        class Node {
            int key;
            Node left, right;
            int subTreeSize = 1;

            public Node(int item) {
                key = item;
                left = right = null;
            }
        }

        // Root of BST
        Node root;

        // Constructor
        BinarySearchTree() {
            root = null;
        }

        // This method mainly calls deleteRec()
        void deleteKey(int key) {
            root = deleteRec(root, key);
        }

        /* A recursive function to delete key in BST */
        Node deleteRec(Node root, int key) {
            /* Base Case: If the tree is empty */
            if (root == null) {
                return null;
            }

            /* Otherwise, recur down the tree */
            if (key < root.key) {
                root.left = deleteRec(root.left, key);
                if (root.left != null) {
                    root.left.subTreeSize--;
                }
            } else if (key > root.key) {
                root.right = deleteRec(root.right, key);
                if (root.right != null) {
                    root.right.subTreeSize--;
                }
            }
            // if key is same as root's key, then This is the node
            // to be deleted
            else {
                // node with only one child or no child
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                root.key = minValue(root.right);

                // Delete the inorder successor
                root.right = deleteRec(root.right, root.key);
                if (root.right != null) {
                    root.right.subTreeSize--;
                }
            }

            return root;
        }

        int minValue(Node root) {
            int minv = root.key;
            while (root.left != null) {
                minv = root.left.key;
                root = root.left;
            }
            return minv;
        }

        void insert(int key) {
            root = insertRec(root, key);
        }

        /* A recursive function to insert a new key in BST */
        Node insertRec(Node root, int key) {

            if (root == null) {
                root = new Node(key);
                return root;
            }

            /* Otherwise, recur down the tree */
            if (key < root.key) {
                root.left = insertRec(root.left, key);
                root.left.subTreeSize++;
            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
                root.right.subTreeSize++;
            }

            return root;
        }

        public Node getRandomNode() {
            if (root == null) {
                return null;
            }
            int treeSize = root.subTreeSize + 1;

            //index of node to return in-order
            int nodeIndex = (int) (Math.random() * treeSize);
            return getNodeAtIndex(root, nodeIndex);
        }

        public Node getNodeAtIndex(Node currNode, int index) {
            int leftSubTreeSize = Optional.ofNullable(currNode.left).map(x -> x.subTreeSize).orElse(0);
            if (leftSubTreeSize == index) {
                return currNode;
            } else if (leftSubTreeSize > index) {
                return getNodeAtIndex(currNode.left, index - 1);
            }else{
                return getNodeAtIndex(currNode.right, index - leftSubTreeSize - 1);
            }
        }
    }
}