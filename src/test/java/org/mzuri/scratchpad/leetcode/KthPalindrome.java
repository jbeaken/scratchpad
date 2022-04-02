package org.mzuri.scratchpad.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class KthPalindrome {

    public long[] kthPalindrome(int[] queries, int intLength) {

        long[] answers = new long[queries.length];

        for (int i = 0; i < queries.length; i++) {
            final int[] initialPalindrome = initializePalindrome(intLength);
            long answer = getAnswer(queries[i], initialPalindrome, intLength);
            answers[i] = answer;
        }

        return answers;
    }

    private int[] initializePalindrome(int palindromeLength) {

        //the tail/head with ones and filled with zeros
        int[] palindrome = new int[palindromeLength];

        palindrome[0] = 1;
        palindrome[palindromeLength - 1] = 1;

        return palindrome;
    }

    private long getAnswer(long sequence, int[] palindrome, int intLength) {

        //quick escape
//        System.out.println(intLength / 2);
//        System.out.println(  Math.pow(10, intLength / 2 + 1) );
        if(sequence > Math.pow(10, intLength / 2 + 1)) return -1;
        int sequenceNumber = 1;

        while(true) {

            if(palindrome[0] == 0) {
                return -1;
            }

            int pos = palindrome.length / 2;

            if(sequenceNumber == sequence) {
                if(palindrome[0] == 0) {
                    return -1;
                } else {
                    return getPalindromeAsInteger(palindrome);
                }
            }

            incrementPalindrome(palindrome, pos);
            sequenceNumber++;
        }
    }

    private long getPalindromeAsInteger(int[] palindrome) {

        final StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < palindrome.length; i++) {
            stringBuffer.append( palindrome[i] );
        }

        return Long.valueOf(stringBuffer.toString());
    }

    private void incrementPalindrome(int[] palindrome, int pos) {
        int length = palindrome.length;

        if(palindrome[0] == 0) return;

        //is pos in the middle?
        if(length % 2 != 0 && pos == length / 2) {
            if(palindrome[pos] == 9) {
                palindrome[pos] = 0;
                incrementPalindrome(palindrome, pos -1);
            }  else {
                palindrome[pos] = palindrome[pos] + 1;
            }
        } else {
            if(palindrome[pos] == 9) {
                palindrome[pos] = 0;
                palindrome[length - 1 - pos] = 0;
                if(pos == 0) {
                    //end of line
                    return;
                }
                incrementPalindrome(palindrome, pos -2);
            }  else {
                palindrome[pos] = palindrome[pos] + 1;
                palindrome[length - 1 - pos] = palindrome[length - 1 - pos] + 1;
            }
        }
    }
}


class KthPalindromeTest {

    @Test
    void test() {
        final KthPalindrome kthPalindrome = new KthPalindrome();

//        final List<Integer> queriesAsList = List.of(1, 2, 3, 4, 5, 90);
//        int palindromeLength = 3;

//        final List<Integer> queriesAsList = List.of(2,201429812,8,520498110,492711727,339882032,462074369,9,7,6);
//        int palindromeLength = 3;

//        final List<Integer> queriesAsList = List.of(696771750,62,47,14,17,192356691,209793716,23,220935614,447911113,5,4,72);
//        int palindromeLength = 4;

        final List<Integer> queriesAsList = List.of(31, 119983340, 494857782, 48, 904409366, 65626832, 610586467);
        int palindromeLength = 15;
        final List<Long> expectedAsList = List.of(100000303000001l,-1l,-1l,100000474000001l,-1l,756268313862657l,-1l);


        final int[] queries = queriesAsList.stream().mapToInt(Integer::intValue).toArray();

        //execute
        final long[] answers = kthPalindrome.kthPalindrome(queries, palindromeLength);

        System.out.println(Arrays.toString( answers ));

        //assert
        final long[] expected = expectedAsList.stream().mapToLong(Long::longValue).toArray();

        assert Arrays.compare(answers, expected) == 0;
    }
}