package org.mzuri.scratchpad.binarytree;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class BinaryTreeDataStrucuturesTest {

    BinaryTreeDataStructures tree = new BinaryTreeDataStructures();

    @BeforeEach
    void beforeAll() {
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
    }

    @Test
    void testDepthFirstStack() {
        log.info("Preorder traversal of binary tree is ");
        tree.traversePreOrderWithoutRecursion();

        log.info("\nInorder traversal of binary tree is ");
        tree.traverseInOrderWithoutRecursion();

        log.info("\nPostorder traversal of binary tree is ");
        tree.traversePostOrderWithoutRecursion();
    }
}
