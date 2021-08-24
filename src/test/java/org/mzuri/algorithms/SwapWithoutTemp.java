package org.mzuri.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class SwapWithoutTemp {


    @Test
    public void test() {

        int x = 18;

        int y = 72;

        x = y + x;

        y = x - y;

        x = x - y;


        Assert.assertTrue(x == 72 );
        Assert.assertTrue(y == 18);
    }
}
