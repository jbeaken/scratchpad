package org.mzuri.scratchpad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
}


@FunctionalInterface
interface ArgumentsProcessor<X extends Number> {
    X process(X arg1, X arg2);
}

@FunctionalInterface
interface ArgumentsProcessor2<X extends Number> {
    X  process(X arg1, X arg2);
}

public final class Algorithm {

    public static <T> T max(T[] array, int first, int second) {
        T elementFirst = array[first];
        T elementSecond = array[second];

        array[first] = elementSecond;
        array[second] = elementFirst;
    }
}
