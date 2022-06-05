package org.mzuri.scratchpad.domain;

import lombok.*;

@Data
public abstract class Pet extends Animal {
    public Pet(String name) {
        super(name);
    }
}
