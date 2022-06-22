package org.mzuri.scratchpad;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CovariantReturnTypeTest {

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