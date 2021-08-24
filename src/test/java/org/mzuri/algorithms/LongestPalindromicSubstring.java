package org.mzuri.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class LongestPalindromicSubstring {


    @Test
    public void test() {

        Assert.assertEquals(longestPalindrome("babad"), "bab");
        Assert.assertEquals(longestPalindrome("cbbd"), "bb");
        Assert.assertEquals(longestPalindrome("a"), "a");
        Assert.assertEquals(longestPalindrome("bb"), "bb");

    }

    public String longestPalindrome(String s) {

        String result = "";

        for(int i = 0; i < s.length(); i++) {

            String res = extendString(s, i, i);
            String res1 = extendString(s, i, i + 1);

            String local = res.length() > res1.length() ? res : res1;

            if(local.length() > result.length()) result = local;

        }

        return result;
    }

    private String extendString(String s, int i, int j) {

        while( i >= 0 && j < s.length()) {

            char l = s.charAt(i);
            char r = s.charAt(j);

            if( l != r ) {
                break;
            }

            i--;
            j++;
        }

        return s.substring(++i, j);
    }
}
