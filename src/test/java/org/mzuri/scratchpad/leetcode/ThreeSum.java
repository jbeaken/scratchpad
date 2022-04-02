package org.mzuri.scratchpad.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

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

                        final List<List<Integer>> collect = result.stream().map(ArrayList::new)
                                .filter(it -> it.remove(Integer.valueOf(kValue)) && it.remove(Integer.valueOf(jValue)) && it.remove(Integer.valueOf(iValue)))
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


    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void solution(List<Integer> input) {
        final ThreeSum threeSum = new ThreeSum();

        final List<List<Integer>> lists = threeSum.threeSum(input.stream().mapToInt(Integer::intValue).toArray());

        System.out.println(lists);

    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of( List.of(-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0) ),
                Arguments.of( List.of(5,-9,-11,9,9,-4,14,10,-11,1,-13,11,10,14,-3,-3,-4,6,-15,6,6,-13,7,-11,-15,10,-8,13,-14,-12,12,6,-6,8,0,10,-11,-8,-2,-6,8,0,12,3,-9,-6,8,3,-15,0,-6,-1,3,9,-5,-5,4,2,-15,-3,5,13,-11,7,6,-4,2,11,-5,7,12,-11,-15,1,-1,-9,10,-8,1,2,8,11,-14,-4,-3,-12,-2,8,5,-1,-9,-4,-3,-13,-12,-12,-10,-3,6,1,12,3,-3,12,11,11,10) ),
                Arguments.of( List.of(-1, 0, 1, 2, -1, -4) )
        );
    }
}
