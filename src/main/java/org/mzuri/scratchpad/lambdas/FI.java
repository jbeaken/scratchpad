package org.mzuri.scratchpad.lambdas;

import java.util.function.BiFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.UnaryOperator;

public class FI {



    BiFunction<Integer, Double, Double> function = (s,p) -> s + p;

    ToDoubleBiFunction<Double, Double> local = (s,p) -> s + p;

    UnaryOperator<String> toUpperCaseAnonymousClass = new UnaryOperator<String>() {
        @Override
        public String apply(String s) {
            return s.toUpperCase();
        }
    };

    UnaryOperator<String> toUpperCase = s -> s.toUpperCase();

    UnaryOperator<String> toUpperCaseMethodReference = String::toUpperCase;

    public static void main(String[] args) {
//        Double d = 3;   //requires double, cannot autobox int
        double df = 5f;
        float f = 343;
        double d5 = 343;
        Double d1 = 35.0;
        double d2 = d1 + d1;

        int Integer = 0;
        //Integer int = 0;  crazy

        int i = new Integer(4);

        int a, b[], c;
        //String cat, String dog = "animal";





        byte b1 = 1;
        byte b2 = ++b1; //result of ++b1 will be a byte
        b2 = b1--; //r

    }
}
