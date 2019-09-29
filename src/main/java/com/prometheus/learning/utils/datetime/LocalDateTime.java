package com.prometheus.learning.utils.datetime;

public class LocalDateTime {

    public void methods() {

        /**Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have the same date and time as this object.

        /** OffsetDateTime	atOffset(ZoneOffset offset) */
        // Combines this date-time with an offset to create an OffsetDateTime.

        /** ZonedDateTime	atZone(ZoneId zone) */
        // Combines this date-time with a time-zone to create a ZonedDateTime.

        /** int	compareTo(ChronoLocalDateTime<?> other) */
        // Compares this date-time to another date-time.

        /** boolean	equals(Object obj) */
        // Checks if this date-time is equal to another date-time.

        /** String	format(DateTimeFormatter formatter) */
        // Formats this date-time using the specified formatter.

        /** static LocalDateTime	from(TemporalAccessor temporal) */
        // Obtains an instance of LocalDateTime from a temporal object.

        /** int	get(TemporalField field) */
        // Gets the value of the specified field from this date-time as an int.

        /** int	getDayOfMonth() */
        // Gets the day-of-month field.

        /** DayOfWeek	getDayOfWeek() */
        // Gets the day-of-week field, which is an enum DayOfWeek.

        /** int	getDayOfYear() */
        // Gets the day-of-year field.

        /** int	getHour() */
        // Gets the hour-of-day field.

        /** long	getLong(TemporalField field) */
        // Gets the value of the specified field from this date-time as a long.

        /** int	getMinute() */
        // Gets the minute-of-hour field.

        /** Month	getMonth() */
        // Gets the month-of-year field using the Month enum.

        /** int	getMonthValue() */
        // Gets the month-of-year field from 1 to 12.

        /** int	getNano() */
        // Gets the nano-of-second field.

        /** int	getSecond() */
        // Gets the second-of-minute field.

        /** int	getYear() */
        // Gets the year field.

        /** int	hashCode() */
        // A hash code for this date-time.

        /** boolean	isAfter(ChronoLocalDateTime<?> other) */
        // Checks if this date-time is after the specified date-time.

        /** boolean	isBefore(ChronoLocalDateTime<?> other) */
        // Checks if this date-time is before the specified date-time.

        /** boolean	isEqual(ChronoLocalDateTime<?> other) */
        // Checks if this date-time is equal to the specified date-time.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** boolean	isSupported(TemporalUnit unit) */
        // Checks if the specified unit is supported.

        /** LocalDateTime	minus(long amountToSubtract, TemporalUnit unit) */
        // Returns a copy of this date-time with the specified amount subtracted.

        /** LocalDateTime	minus(TemporalAmount amountToSubtract) */
        // Returns a copy of this date-time with the specified amount subtracted.

        /** LocalDateTime	minusDays(long days) */
        // Returns a copy of this LocalDateTime with the specified number of days subtracted.

        /** LocalDateTime	minusHours(long hours) */
        // Returns a copy of this LocalDateTime with the specified number of hours subtracted.

        /** LocalDateTime	minusMinutes(long minutes) */
        // Returns a copy of this LocalDateTime with the specified number of minutes subtracted.

        /** LocalDateTime	minusMonths(long months) */
        // Returns a copy of this LocalDateTime with the specified number of months subtracted.

        /** LocalDateTime	minusNanos(long nanos) */
        // Returns a copy of this LocalDateTime with the specified number of nanoseconds subtracted.

        /** LocalDateTime	minusSeconds(long seconds) */
        // Returns a copy of this LocalDateTime with the specified number of seconds subtracted.

        /** LocalDateTime	minusWeeks(long weeks) */
        // Returns a copy of this LocalDateTime with the specified number of weeks subtracted.

        /** LocalDateTime	minusYears(long years) */
        // Returns a copy of this LocalDateTime with the specified number of years subtracted.

        /** static LocalDateTime	now() */
        // Obtains the current date-time from the system clock in the default time-zone.

        /** static LocalDateTime	now(Clock clock) */
        // Obtains the current date-time from the specified clock.

        /** static LocalDateTime	now(ZoneId zone) */
        // Obtains the current date-time from the system clock in the specified time-zone.

        /** static LocalDateTime	of(int year, int month, int dayOfMonth, int hour, int minute) */
        /* Obtains an instance of LocalDateTime from year, month, day, hour and minute, setting
           the second and nanosecond to zero. */

        /** static LocalDateTime	of(int year, int month, int dayOfMonth, int hour, int minute, int second) */
        /* Obtains an instance of LocalDateTime from year, month, day, hour, minute and second,
           setting the nanosecond to zero. */

        /** static LocalDateTime	of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) */
        // Obtains an instance of LocalDateTime from year, month, day, hour, minute, second and nanosecond.

        /** static LocalDateTime	of(int year, Month month, int dayOfMonth, int hour, int minute) */
        /* Obtains an instance of LocalDateTime from year, month, day, hour and minute, setting the second
           and nanosecond to zero. */

        /** static LocalDateTime	of(int year, Month month, int dayOfMonth, int hour, int minute, int second) */
        // Obtains an instance of LocalDateTime from year, month, day, hour, minute and second, setting the nanosecond to zero.

        /** static LocalDateTime	of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) */
        // Obtains an instance of LocalDateTime from year, month, day, hour, minute, second and nanosecond.

        /** static LocalDateTime	of(LocalDate date, LocalTime time) */
        // Obtains an instance of LocalDateTime from a date and time.

        /** static LocalDateTime	ofEpochSecond(long epochSecond, int nanoOfSecond, ZoneOffset offset) */
        // Obtains an instance of LocalDateTime using seconds from the epoch of 1970-01-01T00:00:00Z.

        /** static LocalDateTime	ofInstant(Instant instant, ZoneId zone) */
        // Obtains an instance of LocalDateTime from an Instant and zone ID.

        /** static LocalDateTime	parse(CharSequence text) */
        // Obtains an instance of LocalDateTime from a text string such as 2007-12-03T10:15:30.

        /** static LocalDateTime	parse(CharSequence text, DateTimeFormatter formatter) */
        // Obtains an instance of LocalDateTime from a text string using a specific formatter.

        /** LocalDateTime	plus(long amountToAdd, TemporalUnit unit) */
        // Returns a copy of this date-time with the specified amount added.

        /** LocalDateTime	plus(TemporalAmount amountToAdd) */
        //Returns a copy of this date-time with the specified amount added.

        /** LocalDateTime	plusDays(long days) */
        // Returns a copy of this LocalDateTime with the specified number of days added.

        /** LocalDateTime	plusHours(long hours) */
        // Returns a copy of this LocalDateTime with the specified number of hours added.

        /** LocalDateTime	plusMinutes(long minutes) */
        // Returns a copy of this LocalDateTime with the specified number of minutes added.

        /** LocalDateTime	plusMonths(long months) */
        // Returns a copy of this LocalDateTime with the specified number of months added.

        /** LocalDateTime	plusNanos(long nanos) */
        // Returns a copy of this LocalDateTime with the specified number of nanoseconds added.

        /** LocalDateTime	plusSeconds(long seconds) */
        // Returns a copy of this LocalDateTime with the specified number of seconds added.

        /** LocalDateTime	plusWeeks(long weeks) */
        // Returns a copy of this LocalDateTime with the specified number of weeks added.

        /** LocalDateTime	plusYears(long years) */
        // Returns a copy of this LocalDateTime with the specified number of years added.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this date-time using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** LocalDate	toLocalDate() */
        // Gets the LocalDate part of this date-time.

        /** LocalTime	toLocalTime() */
        // Gets the LocalTime part of this date-time.

        /** String	toString() */
        // Outputs this date-time as a String, such as 2007-12-03T10:15:30.

        /** LocalDateTime	truncatedTo(TemporalUnit unit) */
        // Returns a copy of this LocalDateTime with the time truncated.

        /** long	until(Temporal endExclusive, TemporalUnit unit) */
        // Calculates the amount of time until another date-time in terms of the specified unit.

        /** LocalDateTime	with(TemporalAdjuster adjuster) */
        // Returns an adjusted copy of this date-time.

        /** LocalDateTime	with(TemporalField field, long newValue) */
        // Returns a copy of this date-time with the specified field set to a new value.

        /** LocalDateTime	withDayOfMonth(int dayOfMonth) */
        // Returns a copy of this LocalDateTime with the day-of-month altered.

        /** LocalDateTime	withDayOfYear(int dayOfYear) */
        // Returns a copy of this LocalDateTime with the day-of-year altered.

        /** LocalDateTime	withHour(int hour) */
        // Returns a copy of this LocalDateTime with the hour-of-day altered.

        /** LocalDateTime	withMinute(int minute) */
        // Returns a copy of this LocalDateTime with the minute-of-hour altered.

        /** LocalDateTime	withMonth(int month) */
        // Returns a copy of this LocalDateTime with the month-of-year altered.

        /** LocalDateTime	withNano(int nanoOfSecond) */
        // Returns a copy of this LocalDateTime with the nano-of-second altered.

        /** LocalDateTime	withSecond(int second) */
        // Returns a copy of this LocalDateTime with the second-of-minute altered.

        /** LocalDateTime	withYear(int year) */
        // Returns a copy of this LocalDateTime with the year altered.

    }

}
