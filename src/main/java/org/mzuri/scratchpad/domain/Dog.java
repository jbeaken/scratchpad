package org.mzuri.scratchpad.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    @Override
    public boolean hasTail() {
        return true;
    }
}
