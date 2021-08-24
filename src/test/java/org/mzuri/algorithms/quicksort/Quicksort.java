package org.mzuri.algorithms.quicksort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * Sort algorithms order the elements of an array according to a predefined order.
 * Quicksort is a divide and conquer algorithm.
 * In a divide and conquer sorting algorithm the original data is separated into two parts "divide"
 * which are individually sorted and "conquered" and then combined.
 *
 * Think PIVOT
 *
 */
@Slf4j
public class Quicksort {

    int[] array;

    @Test
    public void test() {

        array = new int[]{3, 6 ,4, 87, 6, 4, 33, 5, 6};

        log.info( Arrays.toString( array ) );

        sort( array );

        log.info( Arrays.toString( array ) );

        Assert.assertArrayEquals( array, new int[] {3, 4, 4, 5, 6, 6, 6, 33, 87 });

    }
    public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }

        quicksort( 0, values.length - 1);
    }

    private void quicksort(int low, int high) {

        int pivot = array[low + (high-low) / 2];

        int i = low, j = high;

        while(i < j) {

            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}

