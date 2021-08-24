package org.mzuri.algorithms.mergesort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * Mergesort is a divide and conquer algorithm.
 *
 * Merge two sorted lists. Split into smaller arrays then merge back into full-sized array
 *
 */
@Slf4j
public class MergesortSolution {

    int[] array;
    int[] helper;

    @Test
    public void test() {

        array = new int[] {3, 6 ,4, 87, 6, 4, 33, 5, 6};

        helper = new int[array.length];

        log.info( Arrays.toString( array ) );

        mergesort( 0, array.length -1 );

        log.info( Arrays.toString( array ) );

        Assert.assertArrayEquals( array, new int[] {3, 4, 4, 5, 6, 6, 6, 33, 87 });

    }

    private void mergesort(int low, int high) {

        if(low < high) return;
        
        int middle = low + (high - low) / 2;
        
        mergesort(low, middle );
        mergesort(middle + 1, high);
        
        
        merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {




    }


}

