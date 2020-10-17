package org.mzuri.scratchpad;

/*
Run-length encoding is a fast and simple method of encoding strings.
The basic idea is to represent repeated successive characters as a single count and character.
For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
 */


import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RunLengthEncoding {

    String decodedText = "AAAABBBCCDAA";
    String encodedText = "4A3B2C1D2A";

    @Test
    void encode() {

        int count = 0;
        StringBuilder encoded = new StringBuilder();

        char previous = decodedText.charAt(0);

        for (char c : decodedText.toCharArray()) {
            if(c == previous) {
                count++;
                continue;
            }

            encoded.append(count);
            encoded.append(previous);
            previous = c;
            count = 1;
        }

        //last one
        encoded.append(count);
        encoded.append(previous);

        assertThat(encoded.toString()).isEqualTo(encodedText);
    }

    @Test
    void decode() {
        final var decoded = new StringBuilder();
        int numberOfChars = -1;

        for(char c : encodedText.toCharArray()) {

            if(numberOfChars == -1) {
                numberOfChars = Character.getNumericValue( c );
            } else {
                IntStream.range(0, numberOfChars).forEach(i -> {
                       decoded.append(c);
                });

                numberOfChars = -1;  //reset
            }
        }

        assertThat(decoded.toString()).as("Decoded is equal to %s", decodedText).isEqualTo(decodedText);
    }
}
