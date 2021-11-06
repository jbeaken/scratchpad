package org.mzuri.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfArrays {


    @Test
    public void test() {

        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};


        Assert.assertArrayEquals(intersection(nums1, nums2), new int[]{2});
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        Set<Integer> result = new HashSet<>();

        for (int i : nums2) {
            if(set1.contains(i)) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(i -> i.intValue()).toArray();
    }
}
