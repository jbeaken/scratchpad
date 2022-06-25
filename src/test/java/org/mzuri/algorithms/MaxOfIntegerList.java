package org.mzuri.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class MaxOfIntegerList {

    List<Integer> integers = List.of(2, 3, 4, 56, 77, 657, 4);


    @Test
    void testMaxOfIntegerList() {

        Comparator<Number> comparator = (i1, i2) -> i1.intValue();

        final Integer integer = integers.stream().mapToInt(Integer::valueOf).max().orElse(-1);
        final int i = integers.stream().flatMapToInt(IntStream::of).max().orElse(-1);
        final int ii = integers.stream().max((i1, i2) -> i1.compareTo(i2)).orElse(-1);
        final int i3 = integers.stream().max(Comparator.naturalOrder()).orElse(-1);
        final int i4 = integers.stream().max(comparator).orElse(-1);

        log.info("result : {}", integer);
    }

//    <T, R> Stream<R> map(Function<? super T, ? extends R> mapper) {
//        return mapper.apply();
//    }

    <T, R> void printResult(Function<T, R> function, T t) {
        final var result = function.apply(t);

        log.info("result : {}", t);
    }
}
