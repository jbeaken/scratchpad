package org.mzuri.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class ThreeSumProblem {

    @Test
    public void test() {

        int[] ints = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = getResult( ints );

        log.info( result.toString() );
    }

    private List<List<Integer>> getResult(int[] ints) {

        List<List<Integer>> result = new ArrayList<>();

        for( int i = 0 ; i < ints.length - 2; i++) {

            for(int j = i + 1; j < ints.length - 1; j++) {

                for(int k = i + 2; k < ints.length; k++) {

                    if( k == j) continue;

                    if( ints[i] + ints[j] + ints[k] == 0) {

                        List<Integer> triplet = new ArrayList<>();

                        triplet.add( ints[i] );
                        triplet.add( ints[j] );
                        triplet.add( ints[k] );

                        result.add(triplet);
                    }
                }
            }
        }

        return result;
    }
}
