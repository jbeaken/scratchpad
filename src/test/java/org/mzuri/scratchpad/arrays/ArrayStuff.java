package org.mzuri.scratchpad.arrays;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class ArrayStuff {


    @Test(expected = ArrayStoreException.class)
    public void covariants() {

        Object[] objects = new String[10];

        objects[0] = 10;
    }

    @Test
    public void covariantNotInvariant() {

        String[] strings = new String[3];

        Object[] objects = strings;
    }

    @Test
    public void test() {

        int[] dinosaurs = new int[5];
        dinosaurs[0] = 0;

        int[] dinosaurs2 = dinosaurs;


        increment( dinosaurs );
        increment( dinosaurs2 );


        log.info( dinosaurs.toString() );
        log.info( Arrays.toString( dinosaurs ) );

        log.info( Arrays.toString(  dinosaurs ) );

        Assert.assertArrayEquals(dinosaurs, new int[] {4, 4, 4, 4, 4});

    }

    private void increment(int[] d2) {

        log.info( d2.toString() );

        for(int i = 0; i < d2.length; i ++) {
            d2[i] = d2[i] + 2;
        }
    }
}
