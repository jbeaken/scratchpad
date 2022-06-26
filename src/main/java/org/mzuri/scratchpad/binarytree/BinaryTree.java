package org.mzuri.scratchpad.binarytree;


public class BinaryTree {
    // Root of Binary Tree
    Node root;

    BinaryTree() { root = null; }

    /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal. */
    void printPostorder(Node node)	{
        if (node == null) return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        print(node);
    }

    // at 1, at 2, at 4, at 5, at null, at null
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node) {
        if (node == null) return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        print(node);

        /* now recur on right child */
        printInorder(node.right);
    }



    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) {
        if (node == null) return;

        /* first print data of node */
        print(node);

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder() { printPostorder(root); }
    void printInorder() { printInorder(root); }
    void printPreorder() { printPreorder(root); }

    private void print(Node node) {
        System.out.print(node.key + " ");
    }
}
