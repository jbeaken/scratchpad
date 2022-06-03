package org.mzuri.scratchpad.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Dog extends Pet {


    public Dog(String name) {
        super(name);
    }

    @Override
    public boolean hasTail() {
        return true;
    }
}
