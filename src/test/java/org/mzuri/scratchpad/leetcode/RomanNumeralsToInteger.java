package org.mzuri.scratchpad.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsToInteger {

    public int calculate(String numeral) {

        int result = 0;
        int pos = 0;

        while (pos < numeral.length()) {
            NumeralCharacter numeralCharacter = NumeralCharacter.valueOf(numeral.substring(pos, pos + 1));
            final NumeralCharacter[] precedersArray = numeralCharacter.preceders;

            if (pos == numeral.length() - 1 || precedersArray.length == 0) {
                result += numeralCharacter.value;
            } else  {
                NumeralCharacter potentialPreceder =  NumeralCharacter.valueOf(numeral.substring(pos + 1, pos + 2));

                if(numeralCharacter.hasPreceder( potentialPreceder )) {
                    result += (potentialPreceder.value - numeralCharacter.value);
                    pos++;  //skip next character, already been taken into account
                } else {
                    result += numeralCharacter.value;
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

    public final int value;

    private final NumeralCharacter[] empty = new NumeralCharacter[]{};

    public final NumeralCharacter[] preceders;

    public boolean hasPreceder(NumeralCharacter potentialPreceder) {
        return Arrays.asList(preceders).contains(potentialPreceder);
    }

    NumeralCharacter(int value, NumeralCharacter[] preceders) {
        this.value = value;
        if(preceders == null) preceders = empty;
        this.preceders = preceders;
    }
}

class RomanNumeralsToIntTest {

    @ParameterizedTest
    @CsvSource({ "DCLVII, 657", "IV, 4", "VI, 6", "X, 10", "IX, 9", "XI, 11", "LVIII, 58", "MCMXCIV, 1994", "MMMCC, 3200"})
    void testRomanNumeral(String numeral, int expected) {
        final RomanNumeralsToInteger romanNumerals = new RomanNumeralsToInteger();

        final int result = romanNumerals.calculate(numeral);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({ "DCLVII, 657", "IV, 4", "VI, 6", "X, 10", "IX, 9", "XI, 11", "LVIII, 58", "MCMXCIV, 1994", "MMMCC, 3200"})
    void testRomanNumeralLegacy(String numeral, int expected) {
        final RomanNumeralLegacy romanNumeralLegacy = new RomanNumeralLegacy();

        final int result = romanNumeralLegacy.romanToInt(numeral);

        Assertions.assertEquals(expected, result);
    }
}


class RomanNumeralLegacy {
    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int pos = 0, sum = 0;

        char[] array = s.toCharArray();

        while(pos < array.length) {

            char c = array[ pos ];

            if( c == 'I' || c == 'X' || c == 'C') {
                if( pos + 1 == array.length) {
                    sum += map.get( c );
                } else {
                    int local = getSubtraction( pos, array );
                    if(local != -1) {
                        sum += local;
                        pos++;
                    } else {
                        sum += map.get( c );
                    }
                }
            } else {
                sum += map.get( c );
            }

            pos++;
        }

        return sum;
    }

    int getSubtraction( int pos, char[] array ) {

        char c = array[pos];
        char d = array[pos + 1];

        if( c == 'I' && d == 'V' ) return 4;
        if( c == 'I' && d == 'X' ) return 9;

        if( c == 'X' && d == 'L' ) return 40;
        if( c == 'X' && d == 'C' ) return 90;

        if( c == 'C' && d == 'D' ) return 400;
        if( c == 'C' && d == 'M' ) return 900;

        return  -1;
    }
}
