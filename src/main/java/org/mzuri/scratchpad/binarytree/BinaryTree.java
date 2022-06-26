package org.mzuri.scratchpad.binarytree;


public class BinaryTree {
    Node root;

    BinaryTree() { root = null; }

    /* Given a binary tree, print its nodes according to the "bottom-up" postorder traversal. */
    //4,5,2,3,1
    void printPostorder(Node node)	{
        if (node == null) return;

        printPostorder(node.left);
        printPostorder(node.right);
        print(node);
    }

    /* Given a binary tree, print its nodes in inorder*/
    //4,2,5,1,3
    void printInorder(Node node) {
        if (node == null) return;

        printInorder(node.left);
        print(node);
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    //1,2,4,5,3
    void printPreorder(Node node) {
        if (node == null) return;

        print(node);
        printPreorder(node.left);
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
