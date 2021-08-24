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
public class MergesortProblem {

    private int[] array;
    private int[] helper;

    @Test
    public void test() {

        array = new int[] {3, 6 ,4, 87, 6, 4, 33, 5};

        helper = new int[array.length];

        log.info( Arrays.toString( array ) );

        mergesort( 0, array.length -1 );

        log.info( Arrays.toString( array ) );

        Assert.assertArrayEquals( array, new int[] {3, 4, 4, 5, 6, 6, 33, 87 });

    }

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }
    /**
     * merge two sorted arrays, use helper to form 2nd array
     */
    private void merge(int low, int middle, int high) {

        for(int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int i = low, j = middle + 1, k = low;

        while(i <= middle && j <= high) {

            if(helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }

            k++;
        }

        while (i <= middle) {
            array[k] = helper[i];
            k++;
            i++;
        }


    }
}


