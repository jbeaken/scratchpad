package org.mzuri.scratchpad.generics;

import lombok.extern.slf4j.Slf4j;
import org.mzuri.scratchpad.domain.Cat;
import org.mzuri.scratchpad.domain.Dog;
import org.mzuri.scratchpad.domain.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Generics {


    public void coAnimals(List<? extends Animal> animals) {

        animals.forEach( a ->
                log.info( a.toString() )
        );

        //Compile error
        //animals.add( new Dog(true, "test"));

        Animal animal = new Dog(  "test" );

        //Compile error
        //animals.add( animal );
    }

    public void biVariantAnimals(List<?> things) {
        things.forEach( a ->
                log.info( a.toString() )
        );

    }

    public void invariantAnimals(List<Animal> animals) {
        animals.forEach( a ->
                log.info( a.toString() )
        );

    }

    public void contraAnimals(List<? super Dog> dogs) {

        //Compile error
        //Animal a = dogs.get(0);

        //Can only be sure elements are of type Object
        Object obj = dogs.get( 0 );

        //Compile error
//        Dog dog = dogs.get(0);

        //Treats as object ref
        dogs.forEach( a ->
                log.info( a.toString() )
        );

    }

    public static void main(String[] args) {
        Generics main = new Generics();

        List<Animal> animals = Arrays.asList( new Dog(  "Harry" ), new Cat(  "Sarah" ) );
        List<Dog> dogs = Arrays.asList( new Dog(  "Harry" ), new Dog(  "Sarah" ) );
        List<Cat> cats = Arrays.asList( new Cat( "Fred" ), new Cat( "Tom" ) );

        main.coAnimals( cats );
        main.coAnimals( animals );
        main.coAnimals( dogs );

        main.contraAnimals( animals );
        main.contraAnimals( dogs );
        //main.contraAnimals( cats );

        main.biVariantAnimals( animals );
        main.biVariantAnimals( dogs );
        main.biVariantAnimals( cats );

        main.invariantAnimals( animals );
//        main.invariantAnimals( dogs );

        //List<Object> objectList = new ArrayList<String>(); // Compilation error
        List<? extends Object> objectList = new ArrayList<String>();

        // objectList.add( new Object() ); // Compilation error


    }
}

