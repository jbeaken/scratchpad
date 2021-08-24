package org.mzuri.scratchpad.streams;

import org.mzuri.scratchpad.domain.Person;

import java.util.Arrays;
import java.util.List;

public class Streams {

    public static void main(String[] args) {

    	List<Person> persons = Arrays.asList(
                new Person("mkyong", 30, 1),
                new Person("jack", 26,2),
				new Person("john", 28,3),
				new Person("jane", 26,4),
				new Person("fred", 70,5),
				new Person("harry", 25,6),
				new Person("sarah", 24,7),
				new Person("peter", 30,8),
                new Person("lawrence", 40,9)
        );

        Person result1 = persons.stream()                        // Convert to steam
                .filter( x -> "jack".equals(x.getName()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null

        System.out.println(result1);

    }

}



