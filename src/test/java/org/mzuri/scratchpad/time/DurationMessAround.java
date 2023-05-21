package org.mzuri.scratchpad.time;

import java.time.*;

public class DurationMessAround {

    public static void main(String[] args) {
        Duration duration = Duration.ofDays(3);
        System.out.println(duration.toHours());

        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        LocalTime localTime = LocalTime.ofSecondOfDay(340);
        System.out.println(localTime);

        LocalDate d1 = LocalDate.of(2021, 1, 31);
        LocalDate d2 = d1.plusMonths(1);
        LocalDate d3 = d2.minusMonths(1);
        System.out.println(d1.getDayOfYear() + " " + d2.getDayOfYear() + " " +
                d3.getDayOfYear());

        LocalDate d4 = LocalDate.of(2021, 1, 1);
        d4 = d4.withDayOfMonth(d4.lengthOfMonth()).withMonth(2);
        System.out.println(d4);
gst
    }
}
