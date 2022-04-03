package org.mzuri.scratchpad.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class IntToRomanNumeral {
    public String convert(int numberToConvert) {

        final StringBuffer result = new StringBuffer();

        int thousands = numberToConvert / 1000;
        int hundreds = (numberToConvert - 1000 * thousands) / 100;
        int tens = (numberToConvert - (1000 * thousands) - 100 * hundreds) / 10;
        int singles = numberToConvert % 10;

        //Thousands
        IntStream.range(0, thousands).forEach(it -> result.append("M"));

        String hundredsInRomanNumerals = getPartial(hundreds, List.of("M", "D", "C"));
        String tensInRomanNumerals = getPartial(tens, List.of("C", "L", "X"));
        String singlesInRomanNumerals = getPartial(singles, List.of("X", "V", "I"));


        result.append(hundredsInRomanNumerals);
        result.append(tensInRomanNumerals);
        result.append(singlesInRomanNumerals);

        return result.toString();
    }

    private String getPartial(int quantity, List<String> characters) {
        if(quantity == 0) return "";

        final StringBuffer result = new StringBuffer();

        switch (quantity) {
            case 9:
                return characters.get(2) + characters.get(0);
            case 8:
            case 7:
            case 6:
            case 5:
               return characters.get(1);
            case 4:
                return characters.get(2) + characters.get(1);
            default:
                IntStream.range(0, quantity).forEach(it -> result.append(characters.get(2)));
                return result.toString();
        }
    }
}


class IntToRomanNumeralTest {

    @Test
    void test() {

        int numberToConvert = 2354;

        final IntToRomanNumeral intToRomanNumeral = new IntToRomanNumeral();

        final String romanNumeral = intToRomanNumeral.convert(numberToConvert);
    }
}
