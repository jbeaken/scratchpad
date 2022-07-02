package org.mzuri.scratchpad.binarytree;

public class BinaryTreeRecursion {

    Node root;

    private StringBuilder result = new StringBuilder();

    public String getResult() {
        return result.toString().trim();
    }

    BinaryTreeRecursion() { root = null; }

    /* Given a binary tree, visit its nodes according to the "bottom-up" postorder traversal. */
    void postOrder(Node node)	{
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        visit(node);
    }

    /* Given a binary tree, visit its nodes in inorder*/
    void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        visit(node);
        inOrder(node.right);
    }

    /* Given a binary tree, visit its nodes in preorder*/
    void preOrder(Node node) {
        if (node == null) return;

        visit(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    // Wrappers over above recursive functions
    void postOrder() { postOrder(root); }
    void inOrder() { inOrder(root); }
    void preOrder() { preOrder(root); }

    private void visit(Node node) {
        result.append(node.key + " ");
    }
}
