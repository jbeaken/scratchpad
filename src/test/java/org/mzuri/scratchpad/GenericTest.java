package org.mzuri.scratchpad;

import java.io.IOException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mzuri.scratchpad.domain.Animal;
import org.mzuri.scratchpad.domain.Dog;
import org.mzuri.scratchpad.generics.Generics;

@Slf4j
public class GenericTest {

	List<Animal> animals = List.of(new Dog("woof"));
	List<Dog> dogs = List.of(new Dog("woof"));

	Generics generics = new Generics();

	@Test
	public void test() throws IOException {
		generics.coAnimals(animals);
		generics.coAnimals(dogs);
	}
}