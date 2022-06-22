package org.mzuri.scratchpad.domain;

import lombok.*;

@Data
@EqualsAndHashCode(of = "name")
@NoArgsConstructor
public class Animal implements Comparable<Animal> {

    public Animal(String name) {
        super();
        this.name = name;
    }

    public boolean hasTail() {
        return false;
    }

    private String name;

    protected void breathe() {
        System.out.println("Taking a breath");
    }

    @Override
    public int compareTo(Animal o) {
        return name.compareTo( o.getName() );
    }

}
