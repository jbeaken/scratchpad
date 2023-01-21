package org.mzuri.leetcode;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 */
public class IPAddress {
    @ParameterizedTest
    @ValueSource(strings = { "25525511135", "101023", "0000"})
    public void test(String ip) {
        List<String> ipList = resolveIP(ip);
        System.out.println(ipList);
    }

    private List<String> resolveIP(String ip) {
        List<String> results = new ArrayList<>();

        getIP(1, ip, results, "");

        return results;
    }

    private void getIP(int i, String ip, List<String> results, String partial) {
        if(i == 5) {
            if(ip.length() == 0) {
                results.add(new String(partial));
            }
            i--;
            return; //no more to do, have 4 octets
        }

        if(!partial.isEmpty()) partial += ".";

        //three options x, xx and xxx
        if(ip.length() < 1) return;
        String single = ip.substring(0, 1);
        getIP(i + 1, ip.substring(1), results, partial + single);

        //fast fail
        if(ip.charAt(0) == '0') return;

        if(ip.length() < 2) return;
        String dble = ip.substring(0, 2);
        getIP(i + 1, ip.substring(2), results, partial + dble);

        if(ip.length() < 3) return;
        String triple = ip.substring(0, 3);
        if(Integer.parseInt(triple) <= 255) {
            getIP(i + 1, ip.substring(3), results, partial + triple);
        }
    }
}

