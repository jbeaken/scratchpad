package org.mzuri.scratchpad.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (i == j) continue;

                for (int k = 0; k < nums.length; k++) {

                    if (k == j || k == i) continue;

                    int kValue = nums[k];
                    int jValue = nums[j];
                    int iValue = nums[i];

                    if (iValue + kValue + jValue == 0) {
                        List match = List.of(kValue, iValue, jValue);

                        final List<List<Integer>> collect = result.stream()
                                .filter(it -> it.contains(kValue) && it.contains(jValue) && it.contains(iValue))
                                .collect(Collectors.toList());

                        if(collect.isEmpty()) result.add(match);
                    }
                }
            }
        }
        return result;
    }
}

class Solution {


    @Test
    void solution() {
        final ThreeSum threeSum = new ThreeSum();

        var input = List.of(-1, 0, 1, 2, -1, -4);

        final List<List<Integer>> lists = threeSum.threeSum(input.stream().mapToInt(Integer::intValue).toArray());

        System.out.println(lists);

    }
}
