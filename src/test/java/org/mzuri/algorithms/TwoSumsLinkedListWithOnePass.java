package org.mzuri.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TwoSumsLinkedListWithOnePass {


    @Test
    public void twoSumsProblemWithOnePassHash() {
        int[] nums = {1,5,7,9};
        int target = 12;

        int result[] = new int[2];


        Assert.assertArrayEquals(result, new int[]{1, 2});
    }




    @Test
    public void twoSumsProblemWithOnePassHashSolution() {
        int[] nums = {1,5,7,9};
        int target = 12;

        int result[] = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if(map.containsKey( complement )) {
                result = new int[]{ map.get(complement), i };
                break;
            }
            map.put( nums[i], i);
        }

        Assert.assertArrayEquals(result, new int[]{1, 2});
    }
}
