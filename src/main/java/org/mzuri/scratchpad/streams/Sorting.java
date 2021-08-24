package org.mzuri.scratchpad.streams;

import org.mzuri.scratchpad.domain.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsFirst;

public class Sorting {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30, 1),
                new Person("jack", 26, 2),
                new Person("john", 28, 3),
                new Person("jane", 26, 4),
                new Person("fred", 70, 5),
                new Person("harry", 25, 6),
                new Person("sarah", 24, 7),
                new Person("peter", 30, 8),
                new Person("lawrence", 40, 9)
        );

        System.out.println(persons);

        Collections.sort(persons, Comparator.comparing(Person::getAge, nullsFirst(naturalOrder())).thenComparing(Person::getName));

        System.out.println(persons);
	}
}



