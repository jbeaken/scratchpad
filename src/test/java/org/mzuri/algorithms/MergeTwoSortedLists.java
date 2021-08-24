package org.mzuri.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists {

    @Test
    public void mergeTwoSortedLists() {

        List<Integer> sortedList = Arrays.asList(1, 4, 5, 6, 7, 10);
        List<Integer> anotherSortedList = Arrays.asList(2, 5, 5, 6, 7, 8, 9);

        int pointer = 0, anotherPointer = 0;

        int size = sortedList.size() + anotherSortedList.size();

        List<Integer> mergedList = new ArrayList<>(size);

        while( mergedList.size() < size) {
            if(anotherPointer == anotherSortedList.size() || (pointer != sortedList.size() && sortedList.get(pointer) <= anotherSortedList.get(anotherPointer)) ) {
                mergedList.add( sortedList.get(pointer++) );
            } else {
                mergedList.add( anotherSortedList.get( anotherPointer++ ));
            }
        }

        Assert.assertEquals(mergedList, Arrays.asList(1, 2, 4, 5, 5, 5, 6, 6, 7, 7, 8, 9, 10));
    }



    @Test
    public void mergeTwoSortedArrays() {

        int[] a1 = {1, 3, 5, 6, 7, 8, 8, 9};
        int[] a2 = {2, 3, 5, 5, 6, 6, 7, 7, 7, 8, 10};

        int j = a1.length, k = a2.length;

        int[] result = new int[j + k];

        int p1 = 0, p2 = 0;


        while(p1 < j && p2 < k) {

            if( a1[ p1 ] < a2[ p2 ] ) {

                result[p1 + p2] = a1[ p1++ ];
            } else {
                result[p1 + p2] = a2[ p2++ ];
            }
        }

        while(p1 < j) {
            result[p1 + p2] = a1[ p1++ ];
        }

        while(p2 < k) {
            result[p1 + p2] = a2[ p2++ ];
        }


        Assert.assertArrayEquals(result, new int[]{1, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 10});

    }


















        @Test
    public void mergeTwoSortedArraysSolution() {

        int[] a1 = {1, 3, 5, 6, 7, 8, 8, 9};
        int[] a2 = {2, 3, 5, 5, 6, 6, 7, 7, 7, 8, 10};

        int p1 = 0, p2 = 0, f = 0;

        int j = a1.length;
        int k = a2.length;

        int[] result = new int[j + k];

        while( p1 < j && p2 < k) {
            if(a1[p1] < a2[p2]) result[f++] = a1[p1++]; else result[f++] = a2[p2++];
        }

        while( p1 < j) {
            result[f++] = a1[p1++];
        }

        while( p2 < k) {
            result[f++] = a2[p2++];
        }

        Assert.assertArrayEquals(result, new int[]{1, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 10});
    }
}
