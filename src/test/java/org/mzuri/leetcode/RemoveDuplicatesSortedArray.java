package org.mzuri.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */

@Slf4j
public class RemoveDuplicatesSortedArray {


    @Test
    public void test() {

        int[] nums = new int[]{1,2,2};
        int[] expectedNums = new int[]{1,2};

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;

        for(int j = 1; j < nums.length; j++) {

            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return  i + 1;
    }
}
