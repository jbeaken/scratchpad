package org.mzuri.scratchpad.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanNumerals {

    public int calculate(String numeral) {

        int result = 0;
        int pos = 0;

        while (pos < numeral.length()) {
            char ch = numeral.charAt(pos);

            if (ch == 'D') result += 500;
            if (ch == 'C') {
                if (pos == numeral.length() - 1) {
                    result += 100;
                    pos++;
                } else if (numeral.charAt(pos + 1) == 'D') {
                    result += 400;
                    pos++;
                } else if (numeral.charAt(pos + 1) == 'M') {
                    result += 900;
                    pos++;
                } else {
                    result += 100;
                }
            }
            if (ch == 'X') {
                if (pos == numeral.length() - 1) {
                    result += 10;
                    pos++;
                } else if (numeral.charAt(pos + 1) == 'L') {
                    result += 40;
                    pos++;
                } else if (numeral.charAt(pos + 1) == 'C') {
                    result += 90;
                    pos++;
                } else {
                    result += 10;
                }
            }
            if (ch == 'L') result += 50;
            if (ch == 'V') result += 5;
            if (ch == 'I') {
                if (pos == numeral.length() - 1) {
                    result += 1;
                    pos++;
                } else if (numeral.charAt(pos + 1) == 'V') {
                    result += 4;
                    pos++;
                } else if (numeral.charAt(pos + 1) == 'X') {
                    result += 9;
                    pos++;
                } else {
                    result += 1;
                }
            }
            if (ch == 'M') result += 1000;
            pos++;
        }

        return result;
    }
}

enum NumeralCharacter {
    M(1000, null),
    D(500, null),
    L(50, null),
    V(5, null),
    C(100, new NumeralCharacter[]{D, M}),
    X(10, new NumeralCharacter[]{L, C}),
    I(1, new NumeralCharacter[]{V, X});

    private final int value;

    private NumeralCharacter[] preceders;

    NumeralCharacter(int value, NumeralCharacter[] preceders) {
        this.value = value;
        this.preceders = preceders;
    }
}

class Numeral {
    NumeralCharacter numeralCharacter;
    int value;
}

class RomanNumeralsTest {

    @ParameterizedTest
    @CsvSource({ "DCLVII, 657", "IV, 4", "VI, 6", "X, 10", "IX, 9", "XI, 11", "LVIII, 58", "MCMXCIV, 1994", "MMMCC, 3200"})
    void test(String numeral, int expected) {
        final RomanNumerals romanNumerals = new RomanNumerals();

        final int result = romanNumerals.calculate(numeral);

        Assertions.assertEquals(expected, result);
    }
}
