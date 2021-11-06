package org.mzuri.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MajorityElementII {


    @Test
    public void test() {

        int[] a1 = IntStream.of(3,2,3).toArray();

        int[] a2 = IntStream.of(1,1,1,3,3,2,2,2).toArray();

        Assert.assertEquals(3, majorityElementII(a1));
        Assert.assertEquals(2, majorityElementII(a2));

    }

    public List<Integer> majorityElementII(int[] nums) {

        int cutOf = nums.length / 3;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.compute(num, (k, v) -> (v == null) ? 1 : ++v);
        }



        List<Integer> result = map.entrySet().stream().filter(entry -> entry.getValue() > cutOf).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(map);
        System.out.println(result);

        return result;
//        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}
