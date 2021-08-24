package org.mzuri.scratchpad;

public class OverridenExceptions {


    public void overrideMe() {

    }
    public class Override extends  OverridenExceptions {
        public void overrideMe() throws RuntimeException {

        }
    }


    public static void main(String[] args) {
        OverridenExceptions ov = new OverridenExceptions();

        ov.overrideMe();
    }
}
