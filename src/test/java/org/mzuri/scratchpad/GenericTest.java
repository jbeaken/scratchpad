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
import org.mzuri.scratchpad.domain.Dog;
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
}