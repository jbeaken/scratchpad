package org.mzuri.leetcode;


/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 */
public class IPAddress {
    @Test
    public void test() {

        int[] a1 = IntStream.of(0,1,2,4,5,7).toArray();

        int[] a2 = IntStream.of(0,2,3,4,6,8,9).toArray();

        summaryRanges(a1);
        summaryRanges(a2);
    }

}

