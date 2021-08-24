package org.mzuri.scratchpad.streams;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public static void main(String[] args) {

        String start = "dog";
        String end = "cat";
        String current = start;


        String[] dictionary = {"dot", "dop", "dat", "cat"};


        List<String> trail = new ArrayList<>();

        trail.add(start);

        int count = 0;
        String next ="";

    }

    private static String getNext(String[] dictionary, List<String> trail, String current) {

        for (String s : dictionary) {
            if(s.equals( current)) continue;
            if(trail.contains(s)) continue;

            if(isValidProgression( current, s)) {
                trail.add(s);
                return s;
            }
        }

        return null;
    }

    private static boolean isValidProgression(String current, String s) {
        int match = 0;

        if(s.charAt(0) == current.charAt(0)) {
            match++;
        }
        if(s.charAt(1) == current.charAt(1)) {
            match++;
        }
        if(s.charAt(2) == current.charAt(2)) {
            match++;
        }

        if(match == 2) return true;
        return false;
    }
}
