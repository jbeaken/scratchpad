package org.mzuri.scratchpad.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class RomanNumerals {

    public int calculate(String numeral) {

        int result = 0;
        int pos = 0;

        while (pos < numeral.length()) {
            NumeralCharacter numeralCharacter = NumeralCharacter.valueOf(numeral.substring(pos, pos + 1));
            final NumeralCharacter[] precedersArray = numeralCharacter.getPreceders();

            if (pos == numeral.length() - 1 || precedersArray.length == 0) {
                result += numeralCharacter.getValue();
            } else  {
                NumeralCharacter nextCharacter =  NumeralCharacter.valueOf(numeral.substring(pos + 1, pos + 2));
                final boolean precederMatched = Arrays.asList(precedersArray).contains(nextCharacter);
                if(precederMatched) {
                    result += (nextCharacter.getValue() - numeralCharacter.getValue());
                    pos++;
                } else {
                    result += numeralCharacter.getValue();
                }
            }
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
    C(100, new NumeralCharacter[]{M, D}),
    X(10, new NumeralCharacter[]{L, C}),
    I(1, new NumeralCharacter[]{V, X});

    private final int value;

    private final NumeralCharacter[] empty = new NumeralCharacter[]{};

    private NumeralCharacter[] preceders;

    public int getValue() {
        return value;
    }

    public NumeralCharacter[] getPreceders() {
        return preceders;
    }

    NumeralCharacter(int value, NumeralCharacter[] preceders) {
        this.value = value;
        if(preceders == null) preceders = empty;
        this.preceders = preceders;
    }
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
