package org.mzuri.scratchpad.binarytree;


import java.util.Stack;

public class BinaryTree {
    Node root;
    StringBuilder result = new StringBuilder();

    BinaryTree() { root = null; }

    /* Given a binary tree, record its nodes according to the "bottom-up" postorder traversal. */
    //4,5,2,3,1
    void postOrder(Node node)	{
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        record(node);
    }

    /* Given a binary tree, record its nodes in inorder*/
    //4,2,5,1,3
    void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        record(node);
        inOrder(node.right);
    }

    /* Given a binary tree, record its nodes in preorder*/
    //1,2,4,5,3
    void preOrder(Node node) {
        if (node == null) return;

        record(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    // Wrappers over above recursive functions
    void postOrder() { postOrder(root); }
    void inOrder() { inOrder(root); }
    void preOrder() { preOrder(root); }

    private void record(Node node) {
        result.append(node.key + " ");
    }

    public void traverseInOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Node top = stack.pop();
            record(top);
            current = top.right;
        }
    }

    public void traversePreOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node current;
        stack.push(root);
        while(! stack.isEmpty()) {
            current = stack.pop();
            record(current);

            if(current.right != null)
                stack.push(current.right);

            if(current.left != null)
                stack.push(current.left);
        }
    }

    public void traversePostOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node prev = root;
        Node current;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
//                visit(current.value);
                record(current);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

}
