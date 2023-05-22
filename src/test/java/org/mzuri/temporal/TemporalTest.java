package org.mzuri.temporal;

import org.junit.jupiter.api.Test;

import java.time.*;

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
            Instant i1 = d1.toInstant(ZoneOffset.of("+18:00"));
            LocalDate d2 = LocalDate.ofInstant(i1, ZoneId.of("UTC"));

            System.out.println(d2);
    }

}
