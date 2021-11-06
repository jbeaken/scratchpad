package org.mzuri.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SummaryRanges {


    @Test
    public void test() {

        int[] a1 = IntStream.of(0,1,2,4,5,7).toArray();

        int[] a2 = IntStream.of(0,2,3,4,6,8,9).toArray();

        summaryRanges(a1);
        summaryRanges(a2);


    }

    public List<String> summaryRanges(int[] nums) {

        ArrayList<String> result = new ArrayList<>();

        int lower= nums[0], higher= nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == higher + 1) {
                higher = nums[i];
                continue;
            }
            addToRange(result, lower, higher);

            lower = nums[i];
            higher = lower;
        }

        addToRange(result, lower, higher);

        System.out.println(result);

        return result;
    }

    private void addToRange(ArrayList<String> result, int lower, int higher) {

        String range = "";
        if(lower == higher) {
            range =  "" + lower;
        } else {
            range = lower + "->" + higher;
        }


        result.add(range);
    }
}

