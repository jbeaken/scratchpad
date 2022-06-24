package org.mzuri.scratchpad;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mzuri.scratchpad.domain.Animal;
import org.mzuri.scratchpad.domain.Cat;
import org.mzuri.scratchpad.domain.Dog;
import org.mzuri.scratchpad.domain.Pet;
import org.mzuri.scratchpad.generics.Generics;

@Slf4j
public class GenericTest {

    List<Animal> animals = List.of(new Dog("woof"));
    List<Dog> dogs = List.of(new Dog("woof"));

    List<? extends Animal> animalDogs = dogs;

    Generics generics = new Generics();

    @Test
    public void test() throws IOException {
        generics.coAnimals(animalDogs);
        generics.coAnimals(animals);
        generics.coAnimals(dogs);

        generics.contraAnimals(animals);
        generics.contraAnimals(dogs);
    }

    @Test
    public void testAppend() {
        List<Number> integers = new ArrayList<>(List.of(2, 3, 4));

        integers.add(3);

        log.info(Arrays.toString(integers.toArray()));

        //<R> Stream<R> map(Function<? super T, ? extends R> mapper);
        List<Integer> list = List.of(1, 2, 3, 4);
        Function<Integer, String> stringMapper = (i) -> String.valueOf(i);
        final List<String> collect2 = list.stream().map(stringMapper).collect(Collectors.toList());


        //<R> Stream<R> map(Function<? super T, ? extends R> mapper);
        List<Float> doubleList = List.of(1f, 2f, 3f, 4f);
        Function<Float, Integer> mapper = (i) -> i.intValue();
        final List<Integer> collect3 = doubleList.stream().map(mapper).collect(Collectors.toList());


    }

    @Test
    void arraysReified() {
        Assertions.assertThrows(ArrayStoreException.class, () -> {
            String[] arrayOfStrings = new String[10];
            Object[] arrayOfObjects = new String[10]; // compiles fine
            arrayOfObjects[0] = "2";
            arrayOfObjects[0] = 2; // throws a runtime exception (ArrayStoreException IIRC)
        });
    }

    @Test
    void testContravariance() {
        List<? extends Animal> extendsAnimals = new ArrayList<>(List.of(new Dog("woof")));
        List<? super Pet> superAnimals = new ArrayList<>(List.of(new Dog("woof")));
        List<? super Dog> superDogs = new ArrayList<>(List.of(new Pet("woof")));

        superAnimals.add(new Dog());
        superAnimals.add(new Cat());
    }

    @Test
    void testArgumentsProcessor() {
        ArgumentsProcessor<Integer> argumentsProcessor = (arg1, arg2) -> arg1 + arg2;

        argumentsProcessor.process(1, 2);
    }

    @Test
    void testAlgorithmMax() {
        List<Integer> integers = List.of(2, 5, 7, 4, 66, 7, 8, 9);

        List<String> strings = List.of("this", "is", "a", "list", "of", "strings");

        final String max = Algorithm.max(strings, 0, 6);
        final Integer maxInteger = Algorithm.max(integers, 0, 6);

        log.info(max);
        log.info("" + maxInteger);
    }

    @Test
    void testAlgorithCountIf() {
        Collection<Integer> ci = Arrays.asList(1, 2, 3, 4, 5, 7, 9);
        long count = Algorithm.countIf(ci, i -> i % 2 != 0);

        log.info("count: {}", count);
    }

    @Test
    void testNode() {
        Node<Circle> nc = new Node<>();
        Node<? extends Shape>  ns = nc;

        Node<Integer> node = new Node<Integer>();

        Node<?> nodey = node;
    }

    @Test
    void testInvariance() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Pet());
        animals.add(new Cat());
    }

    @Test
    void testCollectionsCopy() {
        List<Pet> pets = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();

        Collections.<Pet>copy(pets, dogs);

        Collections.<Pet>sort(pets);

    }
}

class Node2<T extends Comparable<T>> {
    public int compareTo(T obj) { return 0; }
}

@FunctionalInterface
interface ArgumentsProcessor<X extends Number> {
    X process(X arg1, X arg2);
}

@FunctionalInterface
interface ArgumentsProcessor2<X extends Number> {
    X process(X arg1, X arg2);
}

//Write a generic method to countIf the number of elements in a collection that have a specific property (for example, odd integers, prime numbers, palindromes).
final class Algorithm<V extends Animal> {

    public static <T> void swap(T[] array, int first, int second) {
        T elementFirst = array[first];
        T elementSecond = array[second];

        array[first] = elementSecond;
        array[second] = elementFirst;
    }

    public static <T extends Number> long countIf(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().filter(predicate).count();
    }

    public static <T extends Object & Comparable<T>> T max(List<T> list, int begin, int end) {
        T maxElem = list.get(0);

        for(++begin; begin < end; ++begin) {
            if (maxElem.compareTo(list.get(begin)) < 0) {
                maxElem = list.get(begin);
            }
        }

        return maxElem;
    }


}
class Shape { /* ... */ }
class Circle extends Shape { /* ... */ }

class Node<T> { /* ... */ }

