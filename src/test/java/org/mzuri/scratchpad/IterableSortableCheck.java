package org.mzuri.scratchpad;

import org.mzuri.scratchpad.domain.Animal;
import org.mzuri.scratchpad.domain.Cat;
import org.mzuri.scratchpad.domain.Dog;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

public class  IterableSortableCheck {

    public static <T extends Comparable<? super T>> boolean isSorted( final Iterable<? extends T> iterable, final boolean natural) {

        return isSorted(iterable, natural ? naturalOrder() : reverseOrder());
    }

    public static <T> boolean isSorted( final Iterable<? extends T> iterable, final Comparator<? super T> comparator) {

        T previous = null;

        for (final T current : iterable) { // iterable produces
            if (previous != null // comparator consumes
                    && comparator.compare(previous, current) > 0) {
                return false;
            }
            previous = current;
        }

        return true;
    }


    @Test
    public void test() {

        final Iterable<Animal> animals = Arrays.asList( new Dog(  "Harry" ), new Cat(  "Sarah" ) );
        List<Dog> dogs = Arrays.asList( new Dog(  "Harry" ), new Dog(  "Sarah" ) );
        List<Cat> cats = Arrays.asList( new Cat(  "Fred" ), new Cat(  "Tom" ) );


        Comparator<Dog> doggieComparator =  Comparator.comparing(Dog::getName);

        Comparator<Animal> animalComparator = Comparator.comparing(Animal::getName);

        Comparator<Cat> kittyComparator = Comparator.comparing(Cat::getName);

//        isSorted( animals, doggieComparator );

        //T = Dog
        isSorted( dogs, doggieComparator );

        isSorted( cats, animalComparator );

    }
}
