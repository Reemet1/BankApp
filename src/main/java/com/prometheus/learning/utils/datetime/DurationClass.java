package com.prometheus.learning.utils.datetime;

public class DurationClass {

    public void methods() {

        /** Duration	abs() */
        // Returns a copy of this duration with a positive length.

        /** Temporal	addTo(Temporal temporal) */
        // Adds this duration to the specified temporal object.

        /** static Duration	between(Temporal startInclusive, Temporal endExclusive) */
        // Obtains a Duration representing the duration between two temporal objects.

        /** int	compareTo(Duration otherDuration) */
        // Compares this duration to the specified Duration.

        /** Duration	dividedBy(long divisor) */
        // Returns a copy of this duration divided by the specified value.

        /** boolean	equals(Object otherDuration) */
        // Checks if this duration is equal to the specified Duration.

        /** static Duration	from(TemporalAmount amount) */
        // Obtains an instance of Duration from a temporal amount.

        /** long	get(TemporalUnit unit) */
        // Gets the value of the requested unit.

        /** int	getNano() */
        // Gets the number of nanoseconds within the second in this duration.

        /** long	getSeconds() */
        // Gets the number of seconds in this duration.

        /** List<TemporalUnit>	getUnits() */
        // Gets the set of units supported by this duration.

        /** int	hashCode() */
        // A hash code for this duration.

        /** boolean	isNegative() */
        // Checks if this duration is negative, excluding zero.

        /** boolean	isZero() */
        // Checks if this duration is zero length.

        /** Duration	minus(Duration duration) */
        // Returns a copy of this duration with the specified duration subtracted.

        /** Duration	minus(long amountToSubtract, TemporalUnit unit) */
        // Returns a copy of this duration with the specified duration subtracted.

        /** Duration	minusDays(long daysToSubtract) */
        // Returns a copy of this duration with the specified duration in standard 24 hour days subtracted.

        /** Duration	minusHours(long hoursToSubtract) */
        // Returns a copy of this duration with the specified duration in hours subtracted.

        /** Duration	minusMillis(long millisToSubtract) */
        // Returns a copy of this duration with the specified duration in milliseconds subtracted.

        /** Duration	minusMinutes(long minutesToSubtract) */
        // Returns a copy of this duration with the specified duration in minutes subtracted.

        /** Duration	minusNanos(long nanosToSubtract) */
        // Returns a copy of this duration with the specified duration in nanoseconds subtracted.

        /** Duration	minusSeconds(long secondsToSubtract) */
        // Returns a copy of this duration with the specified duration in seconds subtracted.

        /** Duration	multipliedBy(long multiplicand) */
        /** Returns a copy of this duration multiplied by the scalar. */

        /** Duration	negated() */
        // Returns a copy of this duration with the length negated.

        /** static Duration	of(long amount, TemporalUnit unit) */
        // Obtains a Duration representing an amount in the specified unit.

        /** static Duration	ofDays(long days) */
        // Obtains a Duration representing a number of standard 24 hour days.

        /** static Duration	ofHours(long hours) */
        // Obtains a Duration representing a number of standard hours.

        /** static Duration	ofMillis(long millis) */
        // Obtains a Duration representing a number of milliseconds.

        /** static Duration	ofMinutes(long minutes) */
        // Obtains a Duration representing a number of standard minutes.

        /** static Duration	ofNanos(long nanos) */
        // Obtains a Duration representing a number of nanoseconds.

        /** static Duration	ofSeconds(long seconds) */
        // Obtains a Duration representing a number of seconds.

        /** static Duration	ofSeconds(long seconds, long nanoAdjustment) */
        // Obtains a Duration representing a number of seconds and an adjustment in nanoseconds.

        /** static Duration	parse(CharSequence text) */
        // Obtains a Duration from a text string such as PnDTnHnMn.nS.

        /** Duration	plus(Duration duration) */
        // Returns a copy of this duration with the specified duration added.

        /** Duration	plus(long amountToAdd, TemporalUnit unit) */
        // Returns a copy of this duration with the specified duration added. */

        /** Duration	plusDays(long daysToAdd) */
        // Returns a copy of this duration with the specified duration in standard 24 hour days added.

        /** Duration	plusHours(long hoursToAdd) */
        // Returns a copy of this duration with the specified duration in hours added.

        /** Duration	plusMillis(long millisToAdd) */
        // Returns a copy of this duration with the specified duration in milliseconds added.

        /** Duration	plusMinutes(long minutesToAdd) */
        // Returns a copy of this duration with the specified duration in minutes added.

        /** Duration	plusNanos(long nanosToAdd) */
        // Returns a copy of this duration with the specified duration in nanoseconds added.

        /** Duration	plusSeconds(long secondsToAdd) */
        // Returns a copy of this duration with the specified duration in seconds added.

        /** Temporal	subtractFrom(Temporal temporal) */
        // Subtracts this duration from the specified temporal object.

        /** long	toDays() */
        // Gets the number of days in this duration.

        /** long	toHours() */
        // Gets the number of hours in this duration.

        /** long	toMillis() */
        // Converts this duration to the total length in milliseconds.

        /** long	toMinutes() */
        // Gets the number of minutes in this duration.

        /** long	toNanos() */
        // Converts this duration to the total length in nanoseconds expressed as a long.

        /** String	toString() */
        /* A string representation of this duration using ISO-8601 seconds based representation,
           such as PT8H6M12.345S. */

        /** Duration	withNanos(int nanoOfSecond) */
        // Returns a copy of this duration with the specified nano-of-second.

        /** Duration	withSeconds(long seconds) */
        // Returns a copy of this duration with the specified amount of seconds.

    }

}
