package com.prometheus.learning.utils.datetime;

public class LocalDate {

    public void methods() {

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have the same date as this object.

        /** LocalDateTime	atStartOfDay() */
        // Combines this date with the time of midnight to create a LocalDateTime at the start of this date.

        /** ZonedDateTime	atStartOfDay(ZoneId zone) */
        /* Returns a zoned date-time from this date at the earliest valid time according
           to the rules in the time-zone. */




        /** LocalDateTime	atTime(int hour, int minute) */
        // Combines this date with a time to create a LocalDateTime.

        /** LocalDateTime	atTime(int hour, int minute, int second) */
        // Combines this date with a time to create a LocalDateTime.

        /** LocalDateTime	atTime(int hour, int minute, int second, int nanoOfSecond) */
        // Combines this date with a time to create a LocalDateTime.

        /** LocalDateTime	atTime(LocalTime time) */
        // Combines this date with a time to create a LocalDateTime.

        /** OffsetDateTime	atTime(OffsetTime time) */
        // Combines this date with an offset time to create an OffsetDateTime.




        /** int	compareTo(ChronoLocalDate other) */
        // Compares this date to another date.

        /** boolean	equals(Object obj) */
        // Checks if this date is equal to another date.

        /** String	format(DateTimeFormatter formatter) */
        // Formats this date using the specified formatter.

        /** static LocalDate	from(TemporalAccessor temporal) */
        // Obtains an instance of LocalDate from a temporal object.

        /** int	get(TemporalField field) */
        // Gets the value of the specified field from this date as an int.

        /** IsoChronology	getChronology() */
        // Gets the chronology of this date, which is the ISO calendar system.




        /** int	getDayOfMonth() */
        // Gets the day-of-month field.

        /** DayOfWeek	getDayOfWeek() */
        // Gets the day-of-week field, which is an enum DayOfWeek.

        /** int	getDayOfYear() */
        // Gets the day-of-year field.

        /** Era	getEra() */
        // Gets the era applicable at this date.

        /** long	getLong(TemporalField field) */
        // Gets the value of the specified field from this date as a long.

        /** Month	getMonth() */
        // Gets the month-of-year field using the Month enum.

        /** int	getMonthValue() */
        // Gets the month-of-year field from 1 to 12.

        /** int	getYear() */
        // Gets the year field.




        /** int	hashCode() */
        // A hash code for this date.




        /** boolean	isAfter(ChronoLocalDate other) */
        // Checks if this date is after the specified date.

        /** boolean	isBefore(ChronoLocalDate other) */
        // Checks if this date is before the specified date.

        /** boolean	isEqual(ChronoLocalDate other) */
        // Checks if this date is equal to the specified date.

        /** boolean	isLeapYear() */
        // Checks if the year is a leap year, according to the ISO proleptic calendar system rules.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** boolean	isSupported(TemporalUnit unit) */
        // Checks if the specified unit is supported.




        /** int	lengthOfMonth() */
        // Returns the length of the month represented by this date.

        /** int	lengthOfYear() */
        // Returns the length of the year represented by this date.




        /** LocalDate	minus(long amountToSubtract, TemporalUnit unit) */
        // Returns a copy of this date with the specified amount subtracted.

        /** LocalDate	minus(TemporalAmount amountToSubtract) */
        // Returns a copy of this date with the specified amount subtracted.

        /** LocalDate	minusDays(long daysToSubtract) */
        // Returns a copy of this LocalDate with the specified number of days subtracted.

        /** LocalDate	minusMonths(long monthsToSubtract) */
        // Returns a copy of this LocalDate with the specified number of months subtracted.

        /** LocalDate	minusWeeks(long weeksToSubtract) */
        // Returns a copy of this LocalDate with the specified number of weeks subtracted.

        /** LocalDate	minusYears(long yearsToSubtract) */
        // Returns a copy of this LocalDate with the specified number of years subtracted.




        /** static LocalDate	now() */
        // Obtains the current date from the system clock in the default time-zone.

        /** static LocalDate	now(Clock clock) */
        // Obtains the current date from the specified clock.

        /** static LocalDate	now(ZoneId zone) */
        // Obtains the current date from the system clock in the specified time-zone.




        /** static LocalDate	of(int year, int month, int dayOfMonth) */
        // Obtains an instance of LocalDate from a year, month and day.

        /** static LocalDate	of(int year, Month month, int dayOfMonth) */
        // Obtains an instance of LocalDate from a year, month and day.

        /** static LocalDate	ofEpochDay(long epochDay) */
        // Obtains an instance of LocalDate from the epoch day count.

        /** static LocalDate	ofYearDay(int year, int dayOfYear) */
        // Obtains an instance of LocalDate from a year and day-of-year.




        /** static LocalDate	parse(CharSequence text) */
        // Obtains an instance of LocalDate from a text string such as 2007-12-03.

        /** static LocalDate	parse(CharSequence text, DateTimeFormatter formatter) */
        // Obtains an instance of LocalDate from a text string using a specific formatter.




        /** LocalDate	plus(long amountToAdd, TemporalUnit unit) */
        // Returns a copy of this date with the specified amount added.

        /** LocalDate	plus(TemporalAmount amountToAdd) */
        // Returns a copy of this date with the specified amount added.

        /** LocalDate	plusDays(long daysToAdd) */
        // Returns a copy of this LocalDate with the specified number of days added.

        /** LocalDate	plusMonths(long monthsToAdd) */
        // Returns a copy of this LocalDate with the specified number of months added.

        /** LocalDate	plusWeeks(long weeksToAdd) */
        // Returns a copy of this LocalDate with the specified number of weeks added.

        /** LocalDate	plusYears(long yearsToAdd) */
        // Returns a copy of this LocalDate with the specified number of years added.




        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this date using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** long	toEpochDay() */
        // Converts this date to the Epoch Day.

        /** String	toString() */
        // Outputs this date as a String, such as 2007-12-03.

        /** Period	until(ChronoLocalDate endDateExclusive) */
        // Calculates the period between this date and another date as a Period.

        /** long	until(Temporal endExclusive, TemporalUnit unit) */
        // Calculates the amount of time until another date in terms of the specified unit.




        /** LocalDate	with(TemporalAdjuster adjuster) */
        // Returns an adjusted copy of this date.

        /** LocalDate	with(TemporalField field, long newValue) */
        // Returns a copy of this date with the specified field set to a new value.

        /** LocalDate	withDayOfMonth(int dayOfMonth) */
        // Returns a copy of this LocalDate with the day-of-month altered.

        /** LocalDate	withDayOfYear(int dayOfYear) */
        // Returns a copy of this LocalDate with the day-of-year altered.

        /** LocalDate	withMonth(int month) */
        // Returns a copy of this LocalDate with the month-of-year altered.

        /** LocalDate	withYear(int year) */
        // Returns a copy of this LocalDate with the year altered.

    }

}
