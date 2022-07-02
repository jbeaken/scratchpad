package org.mzuri.algorithms.binarytree;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class DepthOfBinaryTreeRecursion {

    @Test
    public void test() {

        TreeNode left = new TreeNode( 4 );
        TreeNode right = new TreeNode( 6 );

        TreeNode left2 = new TreeNode( 4 );
        TreeNode right2 = new TreeNode( 6 );

        left.left = left2;
        left.right = right2;

        TreeNode root = new TreeNode( 4);
        root.left = left;
        root.right = right;

        Assert.assertEquals(maxDepth( root ), 3);

    }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int bigger = Math.max(leftDepth, rightDepth);

        return bigger+1;
    }
}
