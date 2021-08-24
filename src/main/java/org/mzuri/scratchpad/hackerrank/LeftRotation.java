package org.mzuri.scratchpad.hackerrank;

public class LeftRotation {


    public static void main(String[] args) {

        int[] arr = new int[8];
        System.out.println( rotLeft(arr, 0));
    }

        // Complete the rotLeft function below.
        static int rotLeft(int[] a, int d) {

            int length = a.length;
            int newShift = Math.abs(length - (d % length));

            int[] newArray = new int[length];

            return newShift;

        }


}
