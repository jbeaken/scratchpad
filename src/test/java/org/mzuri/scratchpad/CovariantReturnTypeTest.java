package org.mzuri.scratchpad;

import lombok.extern.slf4j.Slf4j;
import org.mzuri.scratchpad.domain.Animal;
import org.mzuri.scratchpad.domain.Cat;
import org.mzuri.scratchpad.domain.Dog;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CovariantReturnTypeTest {

    public static void addDogs(List<? super Animal> list) {
        list.add(new Dog("tom"));
    }

    public static void test() {
        ArrayList<Cat> objects = new ArrayList<>();
        addDogs(objects);
    }

}


abstract class A {
    protected abstract Number getNumber(Number n);
}

class B extends A {

    protected Number getNumber(Integer n) {
        return null;
    }

    @Override
    protected Integer getNumber(Number n) {
        return null;
    }

}