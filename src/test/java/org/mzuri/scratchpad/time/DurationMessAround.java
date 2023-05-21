package org.mzuri.scratchpad.time;

import java.time.Duration;

public class DurationMessAround {

    public static void main(String[] args) {
        Duration duration = Duration.ofDays(3);
        System.out.println(duration.toHours());
    }
}
