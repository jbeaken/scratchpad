package org.mzuri.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MajorityElement {


    @Test
    public void test() {

        int[] a1 = IntStream.of(3,2,3).toArray();

        int[] a2 = IntStream.of(2,2,2,1,1,1,2,2).toArray();

        Assert.assertEquals(3, majorityElement(a1));
        Assert.assertEquals(2,majorityElement(a2));

    }

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.compute(num, (k, v) -> (v == null) ? 1 : ++v);
        }

        System.out.println(map);

        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}
