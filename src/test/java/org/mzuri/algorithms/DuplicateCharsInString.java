package org.mzuri.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DuplicateCharsInString {

    @Test
    public void test() {

        String str = "abterekkehdlleeef3da";

        Map<Character, Integer>  duplicates = getDuplicateChars( str );



        duplicates.forEach( (k, v) ->
            { if( v > 1) log.info( "{} : {}", k, v );
        });

    }

    private Map<Character, Integer> getDuplicateChars(final String str) {

        Map<Character, Integer>  duplicates = new HashMap<>();

        for( char c : str.toCharArray()) {

            duplicates.compute(c, (k, v)  -> (v == null) ? 1 : ++v );
        }


        return duplicates;

    }
}
