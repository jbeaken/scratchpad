package org.mzuri.scratchpad.binarytree;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class BinaryTreeRecursionTest {

    BinaryTreeRecursion tree = new BinaryTreeRecursion();

    @BeforeEach
    void beforeAll() {
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
    }

    @Test
    void testDepthFirstInOrderRecursion() {
        tree.inOrder(tree.root);
        assertEquals(tree.getResult(),"4 2 5 1 3");
    }

    @Test
    void testDepthFirstPreOrderRecursion() {
        tree.preOrder(tree.root);
//        assertEquals(tree.result.toString(),"4 2 5 1 3");
    }

    @Test
    void testDepthFirstPostOrderRecursion() {
        tree.preOrder(tree.root);
//        assertEquals(tree.result.toString(),"4 2 5 1 3");
    }

//    @Test
//    void testDepthFirstStack() {
//        log.info("Preorder traversal of binary tree is ");
//        tree.traversePreOrderWithoutRecursion();
//
//        log.info("\nInorder traversal of binary tree is ");
//        tree.traverseInOrderWithoutRecursion();
//
//        log.info("\nPostorder traversal of binary tree is ");
//        tree.traversePostOrderWithoutRecursion();
//    }
}
