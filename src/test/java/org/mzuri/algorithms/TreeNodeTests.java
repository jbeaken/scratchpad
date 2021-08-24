package org.mzuri.algorithms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeTests {

    TreeNode root;

    private Logger logger = LoggerFactory.getLogger(TreeNodeTests.class);

    @Before
    public void setup() {
        TreeNode leaf1 = new TreeNode(1);
        TreeNode leaf2 = new TreeNode(3);
        TreeNode leaf3 = new TreeNode(6);
        TreeNode leaf4 = new TreeNode(9);

        TreeNode nodeRight = new TreeNode(7, leaf3, leaf4);
        TreeNode nodeLeft = new TreeNode(2, leaf1, leaf2);

        root = new TreeNode(4, nodeLeft, nodeRight);
    }

    @Test
    public void reverseWithRecursion() {

        logger.info("Original Root");
        recursivePrint( root );

        reverseWithRecursion( root );

        logger.info("Reversed Root");
        recursivePrint( root );
    }

    @Test
    public void reverseWithIteration() {

        logger.info("Original Root");
        recursivePrint( root );

        reverseWithIteration( root );

        logger.info("Reversed Root");
        recursivePrint( root );
    }

    private void reverseWithRecursion(TreeNode node) {

        TreeNode temp = node.getLeftChild();
        node.setLeftChild(node.getRightChild());
        node.setRightChild(temp);

        if(node.getLeftChild() != null) {
            reverseWithRecursion(node.getLeftChild());
        }

        if(node.getRightChild() != null) {
            reverseWithRecursion(node.getRightChild());
        }
    }

    private void reverseWithIteration(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add( root );

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.getRightChild() != null) queue.add(node.getRightChild());

            if(node.getLeftChild() != null) queue.add(node.getLeftChild());

            TreeNode temp = node.getLeftChild();
            node.setLeftChild(node.getRightChild());
            node.setRightChild(temp);
        }


    }

    private void recursivePrint(TreeNode node) {

        if(node == null) return;

        if(node.getLeftChild() != null) {
            recursivePrint( node.getLeftChild() );
        }

        if(node.getRightChild() != null) {
            recursivePrint( node.getRightChild() );
        }

        logger.info("Node : " + node.getValue());

    }
}


@Data
@AllArgsConstructor
class TreeNode {

    private int value;
    private TreeNode rightChild;
    private TreeNode leftChild;


    public TreeNode(int value) {
        this.value = value;
    }
}