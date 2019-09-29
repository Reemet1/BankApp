package com.prometheus.learning.utils.datetime;

public class InstantClass {

    public void methods() {

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have this instant.

        /** OffsetDateTime	atOffset(ZoneOffset offset) */
        // Combines this instant with an offset to create an OffsetDateTime.

        /** ZonedDateTime	atZone(ZoneId zone) */
        // Combines this instant with a time-zone to create a ZonedDateTime.

        /** int	compareTo(Instant otherInstant) */
        // Compares this instant to the specified instant.

        /** boolean	equals(Object otherInstant) */
        // Checks if this instant is equal to the specified instant.

        /** static Instant	from(TemporalAccessor temporal) */
        // Obtains an instance of Instant from a temporal object.

        /** int	get(TemporalField field) */
        // Gets the value of the specified field from this instant as an int.

        /** long	getEpochSecond() */
        // Gets the number of seconds from the Java epoch of 1970-01-01T00:00:00Z.

        /** long	getLong(TemporalField field) */
        // Gets the value of the specified field from this instant as a long.

        /** int	getNano() */
        // Gets the number of nanoseconds, later along the time-line, from the start of the second.

        /** int	hashCode() */
        // Returns a hash code for this instant.

        /** boolean	isAfter(Instant otherInstant) */
        // Checks if this instant is after the specified instant.

        /** boolean	isBefore(Instant otherInstant) */
        // Checks if this instant is before the specified instant.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** boolean	isSupported(TemporalUnit unit) */
        // Checks if the specified unit is supported.

        /** Instant	minus(long amountToSubtract, TemporalUnit unit) */
        // Returns a copy of this instant with the specified amount subtracted.

        /** Instant	minus(TemporalAmount amountToSubtract) */
        // Returns a copy of this instant with the specified amount subtracted.

        /** Instant	minusMillis(long millisToSubtract) */
        // Returns a copy of this instant with the specified duration in milliseconds subtracted.

        /** Instant	minusNanos(long nanosToSubtract) */
        // Returns a copy of this instant with the specified duration in nanoseconds subtracted.

        /** Instant	minusSeconds(long secondsToSubtract) */
        // Returns a copy of this instant with the specified duration in seconds subtracted.

        /** static Instant	now() */
        // Obtains the current instant from the system clock.

        /** static Instant	now(Clock clock) */
        // Obtains the current instant from the specified clock.

        /** static Instant	ofEpochMilli(long epochMilli) */
        // Obtains an instance of Instant using milliseconds from the epoch of 1970-01-01T00:00:00Z.

        /** static Instant	ofEpochSecond(long epochSecond) */
        // Obtains an instance of Instant using seconds from the epoch of 1970-01-01T00:00:00Z.

        /** static Instant	ofEpochSecond(long epochSecond, long nanoAdjustment) */
        /* Obtains an instance of Instant using seconds from the epoch of 1970-01-01T00:00:00Z
           and nanosecond fraction of second. */

        /** static Instant	parse(CharSequence text) */
        // Obtains an instance of Instant from a text string such as 2007-12-03T10:15:30.00Z.

        /** Instant	plus(long amountToAdd, TemporalUnit unit) */
        // Returns a copy of this instant with the specified amount added.

        /** Instant	plus(TemporalAmount amountToAdd) */
        // Returns a copy of this instant with the specified amount added.

        /** Instant	plusMillis(long millisToAdd) */
        // Returns a copy of this instant with the specified duration in milliseconds added.

        /** Instant	plusNanos(long nanosToAdd) */
        // Returns a copy of this instant with the specified duration in nanoseconds added.

        /** Instant	plusSeconds(long secondsToAdd) */
        // Returns a copy of this instant with the specified duration in seconds added.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this instant using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** long	toEpochMilli() */
        // Converts this instant to the number of milliseconds from the epoch of 1970-01-01T00:00:00Z.

        /** String	toString() */
        // A string representation of this instant using ISO-8601 representation.

        /** Instant	truncatedTo(TemporalUnit unit) */
        // Returns a copy of this Instant truncated to the specified unit.

        /** long	until(Temporal endExclusive, TemporalUnit unit) */
        // Calculates the amount of time until another instant in terms of the specified unit.

        /** Instant	with(TemporalAdjuster adjuster) */
        // Returns an adjusted copy of this instant.

        /**Instant	with(TemporalField field, long newValue) */
        // Returns a copy of this instant with the specified field set to a new value.

    }

}
