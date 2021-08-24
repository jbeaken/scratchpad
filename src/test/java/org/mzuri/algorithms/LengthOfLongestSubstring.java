package org.mzuri.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    int lengthOfLongestSubstring(String s) {

        int ans = 1;

        if (s.isEmpty()) return 0;

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (hasUniqueCharacters(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }

        return ans;
    }

    private boolean hasUniqueCharacters(String s, int i, int j) {
        Set<Character> set = new HashSet<>();

        for (int k = i; k < j; k++) {
            Character ch = s.charAt(k);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }


    @Test
    public void testBruteForce() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbb"));
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void testMine() {
        Assert.assertEquals("abcabcbb",3, lengthOfLongestSubstringMine("abcabcbb"));
        Assert.assertEquals("bbbb",1, lengthOfLongestSubstringMine("bbbb"));
        Assert.assertEquals("pwwkew", 3, lengthOfLongestSubstringMine("pwwkew"));
        Assert.assertEquals("aab", 2, lengthOfLongestSubstringMine("aab"));
    }

    @Test
    public void testTheirs() {
        Assert.assertEquals("abcabcbb",3, lengthOfLongestSubstringTheirs("abcabcbb"));
        Assert.assertEquals("bbbb",1, lengthOfLongestSubstringTheirs("bbbb"));
        Assert.assertEquals("pwwkew", 3, lengthOfLongestSubstringTheirs("pwwkew"));
        Assert.assertEquals("aab", 2, lengthOfLongestSubstringTheirs("aab"));
    }
    private int lengthOfLongestSubstringMine(String s) {


        int currentIndex = 0, left = 0, ans = 0, l = s.length();

        Set<Character> characters = new HashSet<>();

        while(currentIndex < l) {

            char c = s.charAt( currentIndex );

            if(characters.contains( c )) {
                ans = Math.max( currentIndex - left, ans );
                characters.clear();
                currentIndex = ++left;
            } else {
                currentIndex++;
                characters.add( c );
            }
        }

        ans = Math.max( currentIndex - left, ans );

        return ans;
    }

    private int lengthOfLongestSubstringTheirs(String s) {

        int n = s.length();

        Set<Character> set = new HashSet<>();

        int ans = 0, i = 0, j = 0;

        while (i < n && j < n) {
            // try to extend the range [i, j]

            if (!set.contains(s.charAt(j))){

                set.add(s.charAt(j++));

                ans = Math.max(ans, j - i);
            }
            else {

                set.remove(s.charAt(i++));

            }
        }

        return ans;
    }
}
