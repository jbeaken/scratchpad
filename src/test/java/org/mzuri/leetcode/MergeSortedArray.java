package org.mzuri.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {

    @Test
    void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        Assertions.assertTrue(Arrays.equals(nums1, new int[]{1, 2, 2, 3, 5, 6}));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int x = 0;
        int y = 0;

        while (x < (m + n -1)) {

            int left = nums1[x];
            int right = nums2[y];

            if (right < left ) {
                for (int j = nums1.length - 2; j >= x; j--) {
                    nums1[j + 1] = nums1[j];
                }

                nums1[x] = right;
                y++;
            } else if(x + y > m) {
                nums1[++x] = right;
                y++;
            } else {
                x++;
            }
        }
    }
}

