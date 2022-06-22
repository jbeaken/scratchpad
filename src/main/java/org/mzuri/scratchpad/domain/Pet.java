package org.mzuri.scratchpad.domain;

import lombok.*;

@Data
@NoArgsConstructor
public class Pet extends Animal {
    public Pet(String name) {
        super(name);
    }

    @Override
    public boolean hasTail() {
        return false;
    }
}
