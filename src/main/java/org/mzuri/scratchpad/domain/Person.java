package org.mzuri.scratchpad.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

        private String name;
        private Integer age;
        private Integer id;
}
