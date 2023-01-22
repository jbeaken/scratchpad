package org.mzuri.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

/**
 Given an integer array nums, find the
 subarray
 with the largest sum, and return its sum.



 Example 1:

 Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 Output: 6
 Explanation: The subarray [4,-1,2,1] has the largest sum 6.

 */
public class MaxSubArray {

    @Test
    void test() {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};

        int maxSubArray = maxSubArray(array);

        Assertions.assertEquals(6, maxSubArray);
    }


    public int maxSubArray(int[] nums) {


//      We will need two variables. One will store current sub-array sum.
//      Other will store maximum sub-array sum.

        int curSum = nums[0];
        int maxSum = nums[0];   // consider 1st element to be greatest sub-array.

        for(int i = 1; i < nums.length; i++){

            // If the cur sub-array sum is negative then reset is to 0.
            if(curSum < 0)
            {
                curSum = 0;
            }

            // Iterate over the array and calculate sub-array sum.
            curSum += nums[i];

            // maxSum will be greater of curSum and maxSum.
            maxSum = Math.max(maxSum, curSum);

        }

        // finally, return the maxSum.
        return maxSum;
    }
}

