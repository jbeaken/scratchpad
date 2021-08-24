package org.mzuri.algorithms.binarytree;

import org.junit.Assert;
import org.junit.Test;

public class MinimumDepthBinaryTree {

    @Test
    public void test() {

        TreeNode left = new TreeNode( 9 );
        TreeNode right = new TreeNode( 20 );

        TreeNode rightleft = new TreeNode( 15 );
        TreeNode rightright = new TreeNode( 7 );

        right.left = rightleft;
        right.right = rightright;

        TreeNode root = new TreeNode( 3);
        root.left = left;
        root.right = right;

        Assert.assertEquals(2, minDepth( root ));
    }


        public int minDepth(TreeNode root) {

            if(root == null) return 0;

            int min = getMinDepth(root, 1);

            return min;
        }

        private int getMinDepth(TreeNode node, int depth) {


            if(node.left == null && node.right == null) return depth;

            int left = node.left == null ? 100 : getMinDepth( node.left, depth + 1);
            int right = node.right == null ? 100 : getMinDepth( node.right, depth + 1);

            return Math.min( left, right );
        }
    }
