package org.mzuri.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ModifyArray {


    @Test
    public void test() {

        int[] a1 = IntStream.of(0,1,2,2,3,0,4,2).toArray();

        System.out.println(Arrays.toString(a1));

        removeElement(a1, 2);

        System.out.println(Arrays.toString(a1));

    }

    public int removeElement(int[] nums, int val) {

        int count = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == val) {
                System.out.println("At " + i);
                count++;
                for(int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[nums.length - 1] = 0;
                System.out.println(Arrays.toString(nums));
            }

        }

        return count;
    }
}

