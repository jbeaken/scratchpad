package org.mzuri.scratchpad;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StaticBindingTest {

    class OverridenClass {

        public String callMe(String s) {
            return "String";
        }

        public String callMe(Integer s) {
            return "Integer";
        }

        public String callMe(int s) {
            return "int";
        }

        public String callMe(Float s) {
            return "Float";
        }

        public String callMe(double s) {
            return "double";
        }

        public String callMe(Short s) {
            return "Short";
        }
    }

    @Test
    void testShort() {
        OverridenClass overridenClass = new OverridenClass();

        String result = overridenClass.callMe((short) 3);

        Assertions.assertThat(result).isEqualTo("int");
    }

    @Test
    void testInt() {
        OverridenClass overridenClass = new OverridenClass();

        String result = overridenClass.callMe(3);

        Assertions.assertThat(result).isEqualTo("int");
    }
}
