package org.mzuri.scratchpad.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    @Override
    public boolean hasTail() {
        return true;
    }
}
