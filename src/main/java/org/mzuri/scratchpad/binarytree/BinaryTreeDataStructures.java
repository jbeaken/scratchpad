package org.mzuri.scratchpad.binarytree;

import java.util.Stack;

public class BinaryTreeDataStructures {

    Node root;

    private StringBuilder result = new StringBuilder();

    public String getResult() {
        return result.toString().trim();
    }

    BinaryTreeDataStructures() { root = null; }

    private void visit(Node node) {
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
            visit(top);
            current = top.right;
        }
    }

    public void traversePreOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node current;
        stack.push(root);
        while(! stack.isEmpty()) {
            current = stack.pop();
            visit(current);

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
                visit(current);
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
