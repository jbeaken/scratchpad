package org.mzuri.algorithms;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ListOfStringsToIntegers {

    @Test
    public void test() {

        List<String> strings = Arrays.asList("2", "5", "55", "67", "64");

        List<Integer> integers = strings
                .stream()
                .map( Integer::parseInt )
                .collect(Collectors.toList());

        assertThat(integers, CoreMatchers.hasItems( 2, 5, 55, 67, 64));

    }
}


