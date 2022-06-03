package org.mzuri.scratchpad.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@AllArgsConstructor
public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    @Override
    public boolean hasTail() {
        return true;
    }
}
