package org.mzuri.scratchpad.hackerrank;

import java.time.LocalDate;

public class DayOfWeek {

    public static void main(String[] args) {
        String dayOfWeek = dayOfTheWeek(1, 3, 2019);

        System.out.println(dayOfWeek);
    }


    public static String dayOfTheWeek(int dayOfMonth, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);

        return localDate.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.UK);
    }
}
