package com.prometheus.learning.utils.datetime;

public class ClockClass {

    public void methods() {

        /** boolean	equals(Object obj) */
        // Checks if this clock is equal to another clock.

        /** static Clock	fixed(Instant fixedInstant, ZoneId zone) */
        // Obtains a clock that always returns the same instant.

        /** abstract ZoneId	getZone() */
        // Gets the time-zone being used to create dates and times.

        /** int	hashCode() */
        // A hash code for this clock.

        /** abstract Instant	instant() */
        // Gets the current instant of the clock.

        /** long	millis() */
        // Gets the current millisecond instant of the clock.

        /** static Clock	offset(Clock baseClock, Duration offsetDuration) */
        // Obtains a clock that returns instants from the specified clock with the specified duration added

        /** static Clock	system(ZoneId zone) */
        // Obtains a clock that returns the current instant using best available system clock.

        /** static Clock	systemDefaultZone() */
        /* Obtains a clock that returns the current instant using the best available
           system clock, converting to date and time using the default time-zone. */

        /** static Clock	systemUTC() */
        /* Obtains a clock that returns the current instant using the best available system clock,
           converting to date and time using the UTC time-zone. */

        /** static Clock	tick(Clock baseClock, Duration tickDuration) */
        /* Obtains a clock that returns instants from the specified clock truncated to
           the nearest occurrence of the specified duration. */

        /** static Clock	tickMinutes(ZoneId zone) */
        /* Obtains a clock that returns the current instant ticking in whole minutes using
           best available system clock. */

        /** static Clock	tickSeconds(ZoneId zone) */
        /* Obtains a clock that returns the current instant ticking in whole seconds using
           best available system clock. */

        /** abstract Clock	withZone(ZoneId zone) */
        // Returns a copy of this clock with a different time-zone.


    }

}
