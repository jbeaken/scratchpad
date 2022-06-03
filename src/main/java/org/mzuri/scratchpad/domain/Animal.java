package org.mzuri.scratchpad.domain;

import lombok.*;

@Data
@EqualsAndHashCode(of = "name")
public abstract class Animal implements Comparable<Animal> {


    public abstract boolean hasTail();

    private String name;

    protected void breathe() {
        System.out.println("Taking a breath");
    }

    @Override
    public int compareTo(Animal o) {
        return name.compareTo( o.getName() );
    }

}
