package org.mzuri.scratchpad.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthPalindrome {


    public int[] initializePalindrome(int palindromeLength) {

        //the tail/head with ones and filled with zeros
        int[] palindrome = new int[palindromeLength];

        palindrome[0] = 1;
        palindrome[palindromeLength - 1] = 1;

        return palindrome;
    }

    public int[] findPalindromes(int[] queries, int palindromeLength) {
        final int[] palindrome = initializePalindrome(palindromeLength);

        final int[] answers = generatePalindrome(queries, palindrome);

        return answers;
    }

    public int[] generatePalindrome(int[] queries, int[] palindrome) {
        int position = 0;
        int[] answers = new int[queries.length];

        int nextSequence = queries[position];
        int sequenceNumber = 0;

        while(true) {
            int pos = palindrome.length / 2;

            if(sequenceNumber == nextSequence) {
                if(palindrome[0] == 0) {
                    answers[position++] = -1;
                } else {
                    answers[position++] = getPalindromeAsInteger(palindrome);
                }
                if(position == queries.length) break;
                nextSequence = queries[position];
            }

            incrementPalindrome(palindrome, pos);
            sequenceNumber++;
        }

        return answers;
    }

    private int getPalindromeAsInteger(int[] palindrome) {

        final StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < palindrome.length; i++) {
            stringBuffer.append( palindrome[i] );
        }

        return Integer.valueOf(stringBuffer.toString());
    }

    private void incrementPalindrome(int[] palindrome, int pos) {
        int length = palindrome.length;

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
                incrementPalindrome(palindrome, pos -1);
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

        final List<Integer> queries = List.of(1, 2, 3, 4, 5, 89);
        int palindromeLength = 3;

        final int[] palindrome = kthPalindrome.findPalindromes(queries.stream().mapToInt(Integer::intValue).toArray(), palindromeLength);

        System.out.println(Arrays.toString( palindrome ));

        //assert [101,111,121,131,141,999]

    }
}