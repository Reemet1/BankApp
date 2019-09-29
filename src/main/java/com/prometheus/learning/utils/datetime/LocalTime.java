package com.prometheus.learning.utils.datetime;

public class LocalTime {

    public void method() {

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have the same time as this object.

        /** LocalDateTime	atDate(LocalDate date) */
        // Combines this time with a date to create a LocalDateTime.

        /** OffsetTime	atOffset(ZoneOffset offset) */
        // Combines this time with an offset to create an OffsetTime.

        /** int	compareTo(LocalTime other) */
        // Compares this time to another time.

        /** boolean	equals(Object obj) */
        // Checks if this time is equal to another time.

        /** String	format(DateTimeFormatter formatter) */
        // Formats this time using the specified formatter.

        /** static LocalTime	from(TemporalAccessor temporal) */
        // Obtains an instance of LocalTime from a temporal object.

        /** int	get(TemporalField field) */
        // Gets the value of the specified field from this time as an int.

        /** int	getHour() */
        // Gets the hour-of-day field.

        /** long	getLong(TemporalField field) */
        // Gets the value of the specified field from this time as a long.

        /** int	getMinute() */
        // Gets the minute-of-hour field.

        /** int	getNano() */
        // Gets the nano-of-second field.

        /** int	getSecond() */
        // Gets the second-of-minute field.

        /** int	hashCode() */
        // A hash code for this time.

        /** boolean	isAfter(LocalTime other) */
        // Checks if this time is after the specified time.

        /** boolean	isBefore(LocalTime other) */
        // Checks if this time is before the specified time.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** boolean	isSupported(TemporalUnit unit) */
        // Checks if the specified unit is supported.

        /** LocalTime	minus(long amountToSubtract, TemporalUnit unit) */
        // Returns a copy of this time with the specified amount subtracted.

        /** LocalTime	minus(TemporalAmount amountToSubtract) */
        // Returns a copy of this time with the specified amount subtracted.

        /** LocalTime	minusHours(long hoursToSubtract) */
        // Returns a copy of this LocalTime with the specified number of hours subtracted.

        /** LocalTime	minusMinutes(long minutesToSubtract) */
        // Returns a copy of this LocalTime with the specified number of minutes subtracted.

        /** LocalTime	minusNanos(long nanosToSubtract) */
        // Returns a copy of this LocalTime with the specified number of nanoseconds subtracted.

        /** LocalTime	minusSeconds(long secondsToSubtract) */
        // Returns a copy of this LocalTime with the specified number of seconds subtracted.

        /** static LocalTime	now() */
        // Obtains the current time from the system clock in the default time-zone.

        /** static LocalTime	now(Clock clock) */
        // Obtains the current time from the specified clock.

        /** static LocalTime	now(ZoneId zone) */
        // Obtains the current time from the system clock in the specified time-zone.

        /** static LocalTime	of(int hour, int minute) */
        // Obtains an instance of LocalTime from an hour and minute.

        /** static LocalTime	of(int hour, int minute, int second) */
        // Obtains an instance of LocalTime from an hour, minute and second.

        /** static LocalTime	of(int hour, int minute, int second, int nanoOfSecond) */
        // Obtains an instance of LocalTime from an hour, minute, second and nanosecond.

        /** static LocalTime	ofNanoOfDay(long nanoOfDay) */
        // Obtains an instance of LocalTime from a nanos-of-day value.

        /** static LocalTime	ofSecondOfDay(long secondOfDay) */
        // Obtains an instance of LocalTime from a second-of-day value.

        /** static LocalTime	parse(CharSequence text) */
        // Obtains an instance of LocalTime from a text string such as 10:15.

        /** static LocalTime	parse(CharSequence text, DateTimeFormatter formatter) */
        // Obtains an instance of LocalTime from a text string using a specific formatter.

        /** LocalTime	plus(long amountToAdd, TemporalUnit unit) */
        // Returns a copy of this time with the specified amount added.

        /** LocalTime	plus(TemporalAmount amountToAdd) */
        // Returns a copy of this time with the specified amount added.

        /** LocalTime	plusHours(long hoursToAdd) */
        // Returns a copy of this LocalTime with the specified number of hours added.

        /** LocalTime	plusMinutes(long minutesToAdd) */
        // Returns a copy of this LocalTime with the specified number of minutes added.

        /** LocalTime	plusNanos(long nanosToAdd) */
        // Returns a copy of this LocalTime with the specified number of nanoseconds added.

        /** LocalTime	plusSeconds(long secondstoAdd) */
        // Returns a copy of this LocalTime with the specified number of seconds added.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this time using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** long	toNanoOfDay() */
        // Extracts the time as nanos of day, from 0 to 24 * 60 * 60 * 1,000,000,000 - 1.

        /** int	toSecondOfDay() */
        // Extracts the time as seconds of day, from 0 to 24 * 60 * 60 - 1.

        /** String	toString() */
        // Outputs this time as a String, such as 10:15.

        /** LocalTime	truncatedTo(TemporalUnit unit) */
        // Returns a copy of this LocalTime with the time truncated.

        /** long	until(Temporal endExclusive, TemporalUnit unit) */
        // Calculates the amount of time until another time in terms of the specified unit.

        /** LocalTime	with(TemporalAdjuster adjuster) */
        // Returns an adjusted copy of this time.

        /** LocalTime	with(TemporalField field, long newValue) */
        // Returns a copy of this time with the specified field set to a new value.

        /** LocalTime	withHour(int hour) */
        // Returns a copy of this LocalTime with the hour-of-day altered.

        /** LocalTime	withMinute(int minute) */
        // Returns a copy of this LocalTime with the minute-of-hour altered.

        /** LocalTime	withNano(int nanoOfSecond) */
        // Returns a copy of this LocalTime with the nano-of-second altered.

        /** LocalTime	withSecond(int second) */
        // Returns a copy of this LocalTime with the second-of-minute altered.

    }
}
