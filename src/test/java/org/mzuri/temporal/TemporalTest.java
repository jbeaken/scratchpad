package org.mzuri.temporal;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

class TemporalTest {

    @Test
    void testBetweenZonedDateTime() {
        LocalDateTime dt = LocalDate.of(2021, 4, 1).atStartOfDay();

        //one hour between paris and london
        ZonedDateTime zdt1 = dt.atZone(ZoneId.of("Europe/Paris"));
        ZonedDateTime zdt2 = dt.atZone(ZoneId.of("Europe/London"));
        Duration d1 = Duration.between(zdt1.minusMinutes(30), zdt2.plusMinutes(30));
        Duration d2 = Duration.between(zdt1, zdt2);
        System.out.println(d1);
        System.out.println(d2);
    }

    @Test
    void testInstant() {
        Instant instant = Instant.ofEpochSecond(800000);

        LocalDate localDate = LocalDate.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDate);
    }

    @Test
    void testInstantTimezone() {
        LocalDateTime d1 = LocalDate.of(2021, 4, 1).atStartOfDay();
        ZonedDateTime zonedDateTime = d1.atZone(ZoneOffset.of("+18:00"));
        Instant i1 = zonedDateTime.toInstant();

        LocalDate d2 = LocalDate.ofInstant(i1, ZoneId.of("UTC"));

        System.out.println(d2);
        System.out.println(i1);
    }

    @Test
    void testFlight() {
        try {
            // Departure from New York at 8:30pm on July 4, 2021.                  (1)
            LocalDateTime departure = LocalDateTime.of(2021, Month.JULY, 4, 20, 30);
            ZoneId departureZone = ZoneId.of("America/New_York");
            ZonedDateTime departureZDT = ZonedDateTime.of(departure, departureZone);

            // Flight time is 7 hours and 30 minutes.
            // Calculate local arrival time at London:                             (2)
            ZoneId arrivalZone = ZoneId.of("Europe/London");
            ZonedDateTime arrivalZDT
                    = departureZDT.withZoneSameInstant(arrivalZone)
                    .plusMinutes(7 * 60 + 30);
            System.out.printf("DEPARTURE:  %s%n", departureZDT);
            System.out.printf("ARRIVAL:    %s%n", arrivalZDT);

            // Flight time as a Duration:                                          (3)
            Duration flightduration = Duration.between(departureZDT, arrivalZDT);
            System.out.println("Flight duration:     " + flightduration);

            // Flight time in minutes:                                             (4)
            long flightTime = departureZDT.until(arrivalZDT, ChronoUnit.MINUTES);
            System.out.println("Flight time (mins.): " + flightTime);

            System.out.printf(                                                  // (5)
                    "Time at departure airport on arrival: %s%n",
                    departureZDT.plusMinutes(7 * 60 + 30));

            System.out.printf(                                                  // (6)
                    "Time at departure airport on arrival: %s%n",
                    arrivalZDT.withZoneSameInstant(departureZone));

        } catch (DateTimeException e) {
            e.printStackTrace();
        }
    }
}


