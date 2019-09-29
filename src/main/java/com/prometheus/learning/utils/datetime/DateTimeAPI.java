package com.prometheus.learning.utils.datetime;


import java.time.DayOfWeek;
import java.time.Month;

public class DateTimeAPI {


    public void MonthDay() {

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have this month-day.

        /** LocalDate	atYear(int year) */
        // Combines this month-day with a year to create a LocalDate.

        /** int	compareTo(MonthDay other) */
        // Compares this month-day to another month-day.

        /** boolean	equals(Object obj) */
        // Checks if this month-day is equal to another month-day.

        /** String	format(DateTimeFormatter formatter) */
        // Formats this month-day using the specified formatter.

        /** static MonthDay	from(TemporalAccessor temporal) */
        // Obtains an instance of MonthDay from a temporal object.

        /** int	get(TemporalField field) */
        // Gets the value of the specified field from this month-day as an int.

        /** int	getDayOfMonth() */
        // Gets the day-of-month field.

        /** long	getLong(TemporalField field) */
        // Gets the value of the specified field from this month-day as a long.

        /** Month	getMonth() */
        // Gets the month-of-year field using the Month enum.

        /** int	getMonthValue() */
        // Gets the month-of-year field from 1 to 12.

        /** int	hashCode() */
        // A hash code for this month-day.

        /** boolean	isAfter(MonthDay other) */
        // Checks if this month-day is after the specified month-day.

        /** boolean	isBefore(MonthDay other) */
        // Checks if this month-day is before the specified month-day.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** boolean	isValidYear(int year) */
        // Checks if the year is valid for this month-day.

        /** static MonthDay	now() */
        // Obtains the current month-day from the system clock in the default time-zone.

        /** static MonthDay	now(Clock clock) */
        // Obtains the current month-day from the specified clock.

        /** static MonthDay	now(ZoneId zone) */
        // Obtains the current month-day from the system clock in the specified time-zone.

        /** static MonthDay	of(int month, int dayOfMonth) */
        // Obtains an instance of MonthDay.

        /** static MonthDay	of(Month month, int dayOfMonth) */
        // Obtains an instance of MonthDay.

        /** static MonthDay	parse(CharSequence text) */
        // Obtains an instance of MonthDay from a text string such as --12-03.

        /** static MonthDay	parse(CharSequence text, DateTimeFormatter formatter) */
        // Obtains an instance of MonthDay from a text string using a specific formatter.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this month-day using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** String	toString() */
        // Outputs this month-day as a String, such as --12-03.

        /** MonthDay	with(Month month) */
        // Returns a copy of this MonthDay with the month-of-year altered.

        /** MonthDay	withDayOfMonth(int dayOfMonth) */
        // Returns a copy of this MonthDay with the day-of-month altered.

        /** MonthDay	withMonth(int month) */
        // Returns a copy of this MonthDay with the month-of-year altered.

    }


    public void OffsetDateTime() {

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have the same offset, date and time as this object.

        /** ZonedDateTime	atZoneSameInstant(ZoneId zone) */
        // Combines this date-time with a time-zone to create a ZonedDateTime ensuring that the result has the same instant.

        /** ZonedDateTime	atZoneSimilarLocal(ZoneId zone) */
        // Combines this date-time with a time-zone to create a ZonedDateTime trying to keep the same local date and time.

        /** int	compareTo(OffsetDateTime other) */
        // Compares this date-time to another date-time.

        /** boolean	equals(Object obj) */
        // Checks if this date-time is equal to another date-time.

        /** String	format(DateTimeFormatter formatter) */
        // Formats this date-time using the specified formatter.

        /** static OffsetDateTime	from(TemporalAccessor temporal) */
        // Obtains an instance of OffsetDateTime from a temporal object.

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

        /** ZoneOffset	getOffset() */
        // Gets the zone offset, such as '+01:00'.

        /** int	getSecond() */
        // Gets the second-of-minute field.

        /** int	getYear() */
        // Gets the year field.

        /** int	hashCode() */
        // A hash code for this date-time.

        /** boolean	isAfter(OffsetDateTime other) */
        // Checks if the instant of this date-time is after that of the specified date-time.

        /** boolean	isBefore(OffsetDateTime other) */
        // Checks if the instant of this date-time is before that of the specified date-time.

        /** boolean	isEqual(OffsetDateTime other) */
        // Checks if the instant of this date-time is equal to that of the specified date-time.

        /** boolean	isSupported(TemporalField field) */
        /** Checks if the specified field is supported. */

        /** boolean	isSupported(TemporalUnit unit) */
        // Checks if the specified unit is supported.

        /** OffsetDateTime	minus(long amountToSubtract, TemporalUnit unit) */
        // Returns a copy of this date-time with the specified amount subtracted.

        /** OffsetDateTime	minus(TemporalAmount amountToSubtract) */
        // Returns a copy of this date-time with the specified amount subtracted.

        /** OffsetDateTime	minusDays(long days) */
        // Returns a copy of this OffsetDateTime with the specified number of days subtracted.

        /** OffsetDateTime	minusHours(long hours) */
        // Returns a copy of this OffsetDateTime with the specified number of hours subtracted.

        /** OffsetDateTime	minusMinutes(long minutes) */
        // Returns a copy of this OffsetDateTime with the specified number of minutes subtracted.

        /** OffsetDateTime	minusMonths(long months) */
        // Returns a copy of this OffsetDateTime with the specified number of months subtracted.

        /** OffsetDateTime	minusNanos(long nanos) */
        // Returns a copy of this OffsetDateTime with the specified number of nanoseconds subtracted.

        /** OffsetDateTime	minusSeconds(long seconds) */
        // Returns a copy of this OffsetDateTime with the specified number of seconds subtracted.

        /** OffsetDateTime	minusWeeks(long weeks) */
        // Returns a copy of this OffsetDateTime with the specified number of weeks subtracted.

        /** OffsetDateTime	minusYears(long years) */
        // Returns a copy of this OffsetDateTime with the specified number of years subtracted.

        /** static OffsetDateTime	now() */
        /** Obtains the current date-time from the system clock in the default time-zone. */

        /** static OffsetDateTime	now(Clock clock) */
        // Obtains the current date-time from the specified clock.

        /** static OffsetDateTime	now(ZoneId zone) */
        // Obtains the current date-time from the system clock in the specified time-zone.

        /** static OffsetDateTime	of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond, ZoneOffset offset) */
        // Obtains an instance of OffsetDateTime from a year, month, day, hour, minute, second, nanosecond and offset.

        /** static OffsetDateTime	of(LocalDate date, LocalTime time, ZoneOffset offset) */
        // Obtains an instance of OffsetDateTime from a date, time and offset.

        /** static OffsetDateTime	of(LocalDateTime dateTime, ZoneOffset offset) */
        // Obtains an instance of OffsetDateTime from a date-time and offset.

        /** static OffsetDateTime	ofInstant(Instant instant, ZoneId zone) */
        // Obtains an instance of OffsetDateTime from an Instant and zone ID.

        /** static OffsetDateTime	parse(CharSequence text) */
        // Obtains an instance of OffsetDateTime from a text string such as 2007-12-03T10:15:30+01:00.

        /** static OffsetDateTime	parse(CharSequence text, DateTimeFormatter formatter) */
        // Obtains an instance of OffsetDateTime from a text string using a specific formatter.

        /** OffsetDateTime	plus(long amountToAdd, TemporalUnit unit) */
        // Returns a copy of this date-time with the specified amount added.

        /** OffsetDateTime	plus(TemporalAmount amountToAdd) */
        // Returns a copy of this date-time with the specified amount added.

        /** OffsetDateTime	plusDays(long days) */
        // Returns a copy of this OffsetDateTime with the specified number of days added.

        /** OffsetDateTime	plusHours(long hours) */
        // Returns a copy of this OffsetDateTime with the specified number of hours added.

        /** OffsetDateTime	plusMinutes(long minutes) */
        // Returns a copy of this OffsetDateTime with the specified number of minutes added.

        /** OffsetDateTime	plusMonths(long months) */
        // Returns a copy of this OffsetDateTime with the specified number of months added.

        /** OffsetDateTime	plusNanos(long nanos) */
        // Returns a copy of this OffsetDateTime with the specified number of nanoseconds added.

        /** OffsetDateTime	plusSeconds(long seconds) */
        // Returns a copy of this OffsetDateTime with the specified number of seconds added.

        /** OffsetDateTime	plusWeeks(long weeks) */
        // Returns a copy of this OffsetDateTime with the specified number of weeks added.

        /** OffsetDateTime	plusYears(long years) */
        // Returns a copy of this OffsetDateTime with the specified number of years added.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this date-time using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** static Comparator<OffsetDateTime>	timeLineOrder() */
        // Gets a comparator that compares two OffsetDateTime instances based solely on the instant.

        /** long	toEpochSecond() */
        // Converts this date-time to the number of seconds from the epoch of 1970-01-01T00:00:00Z.

        /** Instant	toInstant() */
        // Converts this date-time to an Instant.

        /** LocalDate	toLocalDate() */
        // Gets the LocalDate part of this date-time.

        /** LocalDateTime	toLocalDateTime() */
        // Gets the LocalDateTime part of this date-time.

        /** LocalTime	toLocalTime() */
        // Gets the LocalTime part of this date-time.

        /** OffsetTime	toOffsetTime() */
        // Converts this date-time to an OffsetTime.

        /** String	toString() */
        // Outputs this date-time as a String, such as 2007-12-03T10:15:30+01:00.

        /** ZonedDateTime	toZonedDateTime() */
        // Converts this date-time to a ZonedDateTime using the offset as the zone ID.

        /** OffsetDateTime	truncatedTo(TemporalUnit unit) */
        // Returns a copy of this OffsetDateTime with the time truncated.

        /** long	until(Temporal endExclusive, TemporalUnit unit) */
        // Calculates the amount of time until another date-time in terms of the specified unit.

        /** OffsetDateTime	with(TemporalAdjuster adjuster) */
        // Returns an adjusted copy of this date-time.

        /** OffsetDateTime	with(TemporalField field, long newValue) */
        // Returns a copy of this date-time with the specified field set to a new value.

        /** OffsetDateTime	withDayOfMonth(int dayOfMonth) */
        // Returns a copy of this OffsetDateTime with the day-of-month altered.

        /** OffsetDateTime	withDayOfYear(int dayOfYear) */
        // Returns a copy of this OffsetDateTime with the day-of-year altered.

        /** OffsetDateTime	withHour(int hour) */
        // Returns a copy of this OffsetDateTime with the hour-of-day altered.

        /** OffsetDateTime	withMinute(int minute) */
        // Returns a copy of this OffsetDateTime with the minute-of-hour altered.

        /** OffsetDateTime	withMonth(int month) */
        // Returns a copy of this OffsetDateTime with the month-of-year altered.

        /** OffsetDateTime	withNano(int nanoOfSecond) */
        // Returns a copy of this OffsetDateTime with the nano-of-second altered.

        /** OffsetDateTime	withOffsetSameInstant(ZoneOffset offset) */
        // Returns a copy of this OffsetDateTime with the specified offset ensuring that the result is at the same instant.

        /** OffsetDateTime	withOffsetSameLocal(ZoneOffset offset) */
        // Returns a copy of this OffsetDateTime with the specified offset ensuring that the result has the same local date-time.

        /** OffsetDateTime	withSecond(int second) */
        // Returns a copy of this OffsetDateTime with the second-of-minute altered.

        /** OffsetDateTime	withYear(int year) */
        // Returns a copy of this OffsetDateTime with the year altered.

    }

    public void OffsetTime() {

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have the same offset and time as this object.

        /** OffsetDateTime	atDate(LocalDate date) */
        // Combines this time with a date to create an OffsetDateTime.

        /** int	compareTo(OffsetTime other) */
        // Compares this OffsetTime to another time.

        /** boolean	equals(Object obj) */
        // Checks if this time is equal to another time.

        /** String	format(DateTimeFormatter formatter) */
        // Formats this time using the specified formatter.

        /** static OffsetTime	from(TemporalAccessor temporal) */
        // Obtains an instance of OffsetTime from a temporal object.

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

        /** ZoneOffset	getOffset() */
        // Gets the zone offset, such as '+01:00'.

        /** int	getSecond() */
        // Gets the second-of-minute field.

        /** int	hashCode() */
        // A hash code for this time.

        /** boolean	isAfter(OffsetTime other) */
        // Checks if the instant of this OffsetTime is after that of the specified time applying both times to a common date.

        /** boolean	isBefore(OffsetTime other) */
        // Checks if the instant of this OffsetTime is before that of the specified time applying both times to a common date.

        /** boolean	isEqual(OffsetTime other) */
        // Checks if the instant of this OffsetTime is equal to that of the specified time applying both times to a common date.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** boolean	isSupported(TemporalUnit unit) */
        // Checks if the specified unit is supported.

        /** OffsetTime	minus(long amountToSubtract, TemporalUnit unit) */
        // Returns a copy of this time with the specified amount subtracted.

        /** OffsetTime	minus(TemporalAmount amountToSubtract) */
        // Returns a copy of this time with the specified amount subtracted.

        /** OffsetTime	minusHours(long hours) */
        // Returns a copy of this OffsetTime with the specified number of hours subtracted.

        /** OffsetTime	minusMinutes(long minutes) */
        // Returns a copy of this OffsetTime with the specified number of minutes subtracted.

        /** OffsetTime	minusNanos(long nanos) */
        // Returns a copy of this OffsetTime with the specified number of nanoseconds subtracted.

        /** OffsetTime	minusSeconds(long seconds) */
        // Returns a copy of this OffsetTime with the specified number of seconds subtracted.

        /** static OffsetTime	now() */
        // Obtains the current time from the system clock in the default time-zone.

        /** static OffsetTime	now(Clock clock) */
        // Obtains the current time from the specified clock.

        /** static OffsetTime	now(ZoneId zone) */
        // Obtains the current time from the system clock in the specified time-zone.

        /** static OffsetTime	of(int hour, int minute, int second, int nanoOfSecond, ZoneOffset offset) */
        // Obtains an instance of OffsetTime from an hour, minute, second and nanosecond.

        /** static OffsetTime	of(LocalTime time, ZoneOffset offset) */
        // Obtains an instance of OffsetTime from a local time and an offset.

        /** static OffsetTime	ofInstant(Instant instant, ZoneId zone) */
        // Obtains an instance of OffsetTime from an Instant and zone ID.

        /** static OffsetTime	parse(CharSequence text) */
        // Obtains an instance of OffsetTime from a text string such as 10:15:30+01:00.

        /** static OffsetTime	parse(CharSequence text, DateTimeFormatter formatter) */
        // Obtains an instance of OffsetTime from a text string using a specific formatter.

        /** OffsetTime	plus(long amountToAdd, TemporalUnit unit) */
        // Returns a copy of this time with the specified amount added.

        /** OffsetTime	plus(TemporalAmount amountToAdd) */
        // Returns a copy of this time with the specified amount added.

        /** OffsetTime	plusHours(long hours) */
        // Returns a copy of this OffsetTime with the specified number of hours added.

        /** OffsetTime	plusMinutes(long minutes) */
        // Returns a copy of this OffsetTime with the specified number of minutes added.

        /** OffsetTime	plusNanos(long nanos) */
        // Returns a copy of this OffsetTime with the specified number of nanoseconds added.

        /** OffsetTime	plusSeconds(long seconds) */
        // Returns a copy of this OffsetTime with the specified number of seconds added.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this time using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** LocalTime	toLocalTime() */
        // Gets the LocalTime part of this date-time.

        /** String	toString() */
        // Outputs this time as a String, such as 10:15:30+01:00.

        /** OffsetTime	truncatedTo(TemporalUnit unit) */
        // Returns a copy of this OffsetTime with the time truncated.

        /** long	until(Temporal endExclusive, TemporalUnit unit) */
        // Calculates the amount of time until another time in terms of the specified unit.

        /** OffsetTime	with(TemporalAdjuster adjuster) */
        // Returns an adjusted copy of this time.

        /** OffsetTime	with(TemporalField field, long newValue) */
        // Returns a copy of this time with the specified field set to a new value.

        /** OffsetTime	withHour(int hour) */
        // Returns a copy of this OffsetTime with the hour-of-day altered.

        /** OffsetTime	withMinute(int minute) */
        // Returns a copy of this OffsetTime with the minute-of-hour altered.

        /** OffsetTime	withNano(int nanoOfSecond) */
        // Returns a copy of this OffsetTime with the nano-of-second altered.

        /** OffsetTime	withOffsetSameInstant(ZoneOffset offset) */
        // Returns a copy of this OffsetTime with the specified offset ensuring that the result is at the same instant on an implied day.

        /** OffsetTime	withOffsetSameLocal(ZoneOffset offset) */
        // Returns a copy of this OffsetTime with the specified offset ensuring that the result has the same local time.

        /** OffsetTime	withSecond(int second) */
        // Returns a copy of this OffsetTime with the second-of-minute altered.

    }

    public void Period() {

        /** Temporal	addTo(Temporal temporal) */
        // Adds this period to the specified temporal object.

        /** static Period	between(LocalDate startDateInclusive, LocalDate endDateExclusive) */
        // Obtains a Period consisting of the number of years, months, and days between two dates.

        /** boolean	equals(Object obj) */
        // Checks if this period is equal to another period.

        /** static Period	from(TemporalAmount amount) */
        // Obtains an instance of Period from a temporal amount.

        /** long	get(TemporalUnit unit) */
        // Gets the value of the requested unit.

        /** IsoChronology	getChronology() */
        // Gets the chronology of this period, which is the ISO calendar system.

        /** int	getDays() */
        // Gets the amount of days of this period.

        /** int	getMonths() */
        // Gets the amount of months of this period.

        /** List<TemporalUnit>	getUnits() */
        // Gets the set of units supported by this period.

        /** int	getYears() */
        // Gets the amount of years of this period.

        /** int	hashCode() */
        // A hash code for this period.

        /** boolean	isNegative() */
        // Checks if any of the three units of this period are negative.

        /** boolean	isZero() */
        // Checks if all three units of this period are zero.

        /** Period	minus(TemporalAmount amountToSubtract) */
        // Returns a copy of this period with the specified period subtracted.

        /** Period	minusDays(long daysToSubtract) */
        // Returns a copy of this period with the specified days subtracted.

        /** Period	minusMonths(long monthsToSubtract) */
        // Returns a copy of this period with the specified months subtracted.

        /** Period	minusYears(long yearsToSubtract) */
        // Returns a copy of this period with the specified years subtracted.

        /** Period	multipliedBy(int scalar) */
        // Returns a new instance with each element in this period multiplied by the specified scalar.

        /** Period	negated() */
        // Returns a new instance with each amount in this period negated.

        /** Period	normalized() */
        // Returns a copy of this period with the years and months normalized.

        /** static Period	of(int years, int months, int days) */
        // Obtains a Period representing a number of years, months and days.

        /** static Period	ofDays(int days) */
        // Obtains a Period representing a number of days.

        /** static Period	ofMonths(int months) */
        // Obtains a Period representing a number of months.

        /** static Period	ofWeeks(int weeks) */
        // Obtains a Period representing a number of weeks.

        /** static Period	ofYears(int years) */
        // Obtains a Period representing a number of years.

        /** static Period	parse(CharSequence text) */
        // Obtains a Period from a text string such as PnYnMnD.

        /** Period	plus(TemporalAmount amountToAdd) */
        // Returns a copy of this period with the specified period added.

        /** Period	plusDays(long daysToAdd) */
        // Returns a copy of this period with the specified days added.

        /** Period	plusMonths(long monthsToAdd) */
        // Returns a copy of this period with the specified months added.

        /** Period	plusYears(long yearsToAdd) */
        // Returns a copy of this period with the specified years added.

        /** Temporal	subtractFrom(Temporal temporal) */
        // Subtracts this period from the specified temporal object.

        /** String	toString() */
        // Outputs this period as a String, such as P6Y3M1D.

        /** long	toTotalMonths() */
        // Gets the total number of months in this period.

        /** Period	withDays(int days) */
        // Returns a copy of this period with the specified amount of days.

        /** Period	withMonths(int months) */
        //Returns a copy of this period with the specified amount of months.

        /** Period	withYears(int years) */
        // Returns a copy of this period with the specified amount of years.

    }

    public void Year() {

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have this year.

        /** LocalDate	atDay(int dayOfYear) */
        // Combines this year with a day-of-year to create a LocalDate.

        /** YearMonth	atMonth(int month) */
        // Combines this year with a month to create a YearMonth.

        /** YearMonth	atMonth(Month month) */
        // Combines this year with a month to create a YearMonth.

        /** LocalDate	atMonthDay(MonthDay monthDay) */
        // Combines this year with a month-day to create a LocalDate.

        /** int	compareTo(Year other) */
        // Compares this year to another year.

        /** boolean	equals(Object obj) */
        // Checks if this year is equal to another year.

        /** String	format(DateTimeFormatter formatter) */
        // Formats this year using the specified formatter.

        /** static Year	from(TemporalAccessor temporal) */
        // Obtains an instance of Year from a temporal object.

        /** int	get(TemporalField field) */
        // Gets the value of the specified field from this year as an int.

        /** long	getLong(TemporalField field) */
        // Gets the value of the specified field from this year as a long.

        /** int	getValue() */
        // Gets the year value.

        /** int	hashCode() */
        // A hash code for this year.

        /** boolean	isAfter(Year other) */
        // Checks if this year is after the specified year.

        /** boolean	isBefore(Year other) */
        // Checks if this year is before the specified year.

        /** boolean	isLeap() */
        // Checks if the year is a leap year, according to the ISO proleptic calendar system rules.

        /** static boolean	isLeap(long year) */
        // Checks if the year is a leap year, according to the ISO proleptic calendar system rules.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** boolean	isSupported(TemporalUnit unit) */
        // Checks if the specified unit is supported.

        /** boolean	isValidMonthDay(MonthDay monthDay) */
        // Checks if the month-day is valid for this year.

        /** int	length() */
        // Gets the length of this year in days.

        /** Year	minus(long amountToSubtract, TemporalUnit unit) */
        // Returns a copy of this year with the specified amount subtracted.

        /** Year	minus(TemporalAmount amountToSubtract) */
        // Returns a copy of this year with the specified amount subtracted.

        /** Year	minusYears(long yearsToSubtract) */
        // Returns a copy of this Year with the specified number of years subtracted.

        /** static Year	now() */
        // Obtains the current year from the system clock in the default time-zone.

        /** static Year	now(Clock clock) */
        // Obtains the current year from the specified clock.

        /** static Year	now(ZoneId zone) */
        // Obtains the current year from the system clock in the specified time-zone.

        /** static Year	of(int isoYear) */
        // Obtains an instance of Year.

        /** static Year	parse(CharSequence text) */
        // Obtains an instance of Year from a text string such as 2007.

        /** static Year	parse(CharSequence text, DateTimeFormatter formatter) */
        // Obtains an instance of Year from a text string using a specific formatter.

        /** Year	plus(long amountToAdd, TemporalUnit unit) */
        // Returns a copy of this year with the specified amount added.

        /** Year	plus(TemporalAmount amountToAdd) */
        // Returns a copy of this year with the specified amount added.

        /** Year	plusYears(long yearsToAdd) */
        // Returns a copy of this Year with the specified number of years added.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this year using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** String	toString() */
        // Outputs this year as a String.

        /** long	until(Temporal endExclusive, TemporalUnit unit) */
        // Calculates the amount of time until another year in terms of the specified unit.

        /** Year	with(TemporalAdjuster adjuster) */
        // Returns an adjusted copy of this year.

        /** Year	with(TemporalField field, long newValue) */
        // Returns a copy of this year with the specified field set to a new value.

    }

    public void YearMonth() {

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have this year-month.

        /** LocalDate	atDay(int dayOfMonth) */
        // Combines this year-month with a day-of-month to create a LocalDate.

        /** LocalDate	atEndOfMonth() */
        // Returns a LocalDate at the end of the month.

        /** int	compareTo(YearMonth other) */
        // Compares this year-month to another year-month.

        /** boolean	equals(Object obj) */
        // Checks if this year-month is equal to another year-month.

        /** String	format(DateTimeFormatter formatter) */
        // Formats this year-month using the specified formatter.

        /** static YearMonth	from(TemporalAccessor temporal) */
        // Obtains an instance of YearMonth from a temporal object.

        /** int	get(TemporalField field) */
        // Gets the value of the specified field from this year-month as an int.

        /** long	getLong(TemporalField field) */
        // Gets the value of the specified field from this year-month as a long.

        /** Month	getMonth() */
        // Gets the month-of-year field using the Month enum.

        /** int	getMonthValue() */
        // Gets the month-of-year field from 1 to 12.

        /** int	getYear() */
        // Gets the year field.

        /** int	hashCode() */
        // A hash code for this year-month.

        /** boolean	isAfter(YearMonth other) */
        // Checks if this year-month is after the specified year-month.

        /** boolean	isBefore(YearMonth other) */
        // Checks if this year-month is before the specified year-month.

        /** boolean	isLeapYear() */
        // Checks if the year is a leap year, according to the ISO proleptic calendar system rules.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** boolean	isSupported(TemporalUnit unit) */
        // Checks if the specified unit is supported.

        /** boolean	isValidDay(int dayOfMonth) */
        // Checks if the day-of-month is valid for this year-month.

        /** int	lengthOfMonth() */
        // Returns the length of the month, taking account of the year.

        /** int	lengthOfYear() */
        // Returns the length of the year.

        /** YearMonth	minus(long amountToSubtract, TemporalUnit unit) */
        // Returns a copy of this year-month with the specified amount subtracted.

        /** YearMonth	minus(TemporalAmount amountToSubtract) */
        // Returns a copy of this year-month with the specified amount subtracted.

        /** YearMonth	minusMonths(long monthsToSubtract) */
        // Returns a copy of this YearMonth with the specified number of months subtracted.

        /** YearMonth	minusYears(long yearsToSubtract) */
        // Returns a copy of this YearMonth with the specified number of years subtracted.

        /** static YearMonth	now() */
        // Obtains the current year-month from the system clock in the default time-zone.

        /** static YearMonth	now(Clock clock) */
        // Obtains the current year-month from the specified clock.

        /** static YearMonth	now(ZoneId zone) */
        // Obtains the current year-month from the system clock in the specified time-zone.

        /** static YearMonth	of(int year, int month) */
        // Obtains an instance of YearMonth from a year and month.

        /** static YearMonth	of(int year, Month month) */
        // Obtains an instance of YearMonth from a year and month.

        /** static YearMonth	parse(CharSequence text) */
        // Obtains an instance of YearMonth from a text string such as 2007-12.

        /** static YearMonth	parse(CharSequence text, DateTimeFormatter formatter) */
        // Obtains an instance of YearMonth from a text string using a specific formatter.

        /** YearMonth	plus(long amountToAdd, TemporalUnit unit) */
        // Returns a copy of this year-month with the specified amount added.

        /** YearMonth	plus(TemporalAmount amountToAdd) */
        // Returns a copy of this year-month with the specified amount added.

        /** YearMonth	plusMonths(long monthsToAdd) */
        // Returns a copy of this YearMonth with the specified number of months added.

        /** YearMonth	plusYears(long yearsToAdd) */
        // Returns a copy of this YearMonth with the specified number of years added.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this year-month using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** String	toString() */
        // Outputs this year-month as a String, such as 2007-12.

        /** long	until(Temporal endExclusive, TemporalUnit unit) */
        // Calculates the amount of time until another year-month in terms of the specified unit.

        /** YearMonth	with(TemporalAdjuster adjuster) */
        // Returns an adjusted copy of this year-month.

        /** YearMonth	with(TemporalField field, long newValue) */
        // Returns a copy of this year-month with the specified field set to a new value.

        /** YearMonth	withMonth(int month) */
        // Returns a copy of this YearMonth with the month-of-year altered.

        /** YearMonth	withYear(int year) */
        // Returns a copy of this YearMonth with the year altered.

    }

    public void ZonedDateTime() {

        /** boolean	equals(Object obj) */
        // Checks if this date-time is equal to another date-time.

        /** String	format(DateTimeFormatter formatter) */
        // Formats this date-time using the specified formatter.

        /** static ZonedDateTime	from(TemporalAccessor temporal) */
        // Obtains an instance of ZonedDateTime from a temporal object.

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

        /** ZoneOffset	getOffset() */
        // Gets the zone offset, such as '+01:00'.

        /** int	getSecond() */
        // Gets the second-of-minute field.

        /** int	getYear() */
        // Gets the year field.

        /** ZoneId	getZone() */
        // Gets the time-zone, such as 'Europe/Paris'.

        /** int	hashCode() */
        // A hash code for this date-time.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** boolean	isSupported(TemporalUnit unit) */
        // Checks if the specified unit is supported.

        /** ZonedDateTime	minus(long amountToSubtract, TemporalUnit unit) */
        // Returns a copy of this date-time with the specified amount subtracted.

        /** ZonedDateTime	minus(TemporalAmount amountToSubtract) */
        // Returns a copy of this date-time with the specified amount subtracted.

        /** ZonedDateTime	minusDays(long days) */
        // Returns a copy of this ZonedDateTime with the specified number of days subtracted.

        /** ZonedDateTime	minusHours(long hours) */
        // Returns a copy of this ZonedDateTime with the specified number of hours subtracted.

        /** ZonedDateTime	minusMinutes(long minutes) */
        // Returns a copy of this ZonedDateTime with the specified number of minutes subtracted.

        /** ZonedDateTime	minusMonths(long months) */
        // Returns a copy of this ZonedDateTime with the specified number of months subtracted.

        /** ZonedDateTime	minusNanos(long nanos) */
        // Returns a copy of this ZonedDateTime with the specified number of nanoseconds subtracted.

        /** ZonedDateTime	minusSeconds(long seconds) */
        // Returns a copy of this ZonedDateTime with the specified number of seconds subtracted.

        /** ZonedDateTime	minusWeeks(long weeks) */
        // Returns a copy of this ZonedDateTime with the specified number of weeks subtracted.

        /** ZonedDateTime	minusYears(long years) */
        // Returns a copy of this ZonedDateTime with the specified number of years subtracted.

        /** static ZonedDateTime	now() */
        // Obtains the current date-time from the system clock in the default time-zone.

        /** static ZonedDateTime	now(Clock clock) */
        // Obtains the current date-time from the specified clock.

        /** static ZonedDateTime	now(ZoneId zone) */
        // Obtains the current date-time from the system clock in the specified time-zone.

        /** static ZonedDateTime	of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond, ZoneId zone) */
        // Obtains an instance of ZonedDateTime from a year, month, day, hour, minute, second, nanosecond and time-zone.

        /** static ZonedDateTime	of(LocalDate date, LocalTime time, ZoneId zone) */
        // Obtains an instance of ZonedDateTime from a local date and time.

        /** static ZonedDateTime	of(LocalDateTime localDateTime, ZoneId zone) */
        // Obtains an instance of ZonedDateTime from a local date-time.

        /** static ZonedDateTime	ofInstant(Instant instant, ZoneId zone) */
        // Obtains an instance of ZonedDateTime from an Instant.

        /** static ZonedDateTime	ofInstant(LocalDateTime localDateTime, ZoneOffset offset, ZoneId zone) */
        // Obtains an instance of ZonedDateTime from the instant formed by combining the local date-time and offset.

        /** static ZonedDateTime	ofLocal(LocalDateTime localDateTime, ZoneId zone, ZoneOffset preferredOffset) */
        // Obtains an instance of ZonedDateTime from a local date-time using the preferred offset if possible.

        /** static ZonedDateTime	ofStrict(LocalDateTime localDateTime, ZoneOffset offset, ZoneId zone) */
        // Obtains an instance of ZonedDateTime strictly validating the combination of local date-time, offset and zone ID.

        /** static ZonedDateTime	parse(CharSequence text) */
        // Obtains an instance of ZonedDateTime from a text string such as 2007-12-03T10:15:30+01:00[Europe/Paris].

        /** static ZonedDateTime	parse(CharSequence text, DateTimeFormatter formatter) */
        // Obtains an instance of ZonedDateTime from a text string using a specific formatter.

        /** ZonedDateTime	plus(long amountToAdd, TemporalUnit unit) */
        // Returns a copy of this date-time with the specified amount added.

        /** ZonedDateTime	plus(TemporalAmount amountToAdd) */
        // Returns a copy of this date-time with the specified amount added.

        /** ZonedDateTime	plusDays(long days) */
        // Returns a copy of this ZonedDateTime with the specified number of days added.

        /** ZonedDateTime	plusHours(long hours) */
        // Returns a copy of this ZonedDateTime with the specified number of hours added.

        /** ZonedDateTime	plusMinutes(long minutes) */
        // Returns a copy of this ZonedDateTime with the specified number of minutes added.

        /** ZonedDateTime	plusMonths(long months) */
        // Returns a copy of this ZonedDateTime with the specified number of months added.

        /** ZonedDateTime	plusNanos(long nanos) */
        // Returns a copy of this ZonedDateTime with the specified number of nanoseconds added.

        /** ZonedDateTime	plusSeconds(long seconds) */
        // Returns a copy of this ZonedDateTime with the specified number of seconds added.

        /** ZonedDateTime	plusWeeks(long weeks) */
        // Returns a copy of this ZonedDateTime with the specified number of weeks added.

        /** ZonedDateTime	plusYears(long years) */
        // Returns a copy of this ZonedDateTime with the specified number of years added.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this date-time using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** LocalDate	toLocalDate() */
        // Gets the LocalDate part of this date-time.

        /** LocalDateTime	toLocalDateTime() */
        // Gets the LocalDateTime part of this date-time.

        /** LocalTime	toLocalTime() */
        // Gets the LocalTime part of this date-time.

        /** OffsetDateTime	toOffsetDateTime() */
        // Converts this date-time to an OffsetDateTime.

        /** String	toString() */
        // Outputs this date-time as a String, such as 2007-12-03T10:15:30+01:00[Europe/Paris].

        /** ZonedDateTime	truncatedTo(TemporalUnit unit) */
        // Returns a copy of this ZonedDateTime with the time truncated.

        /** long	until(Temporal endExclusive, TemporalUnit unit) */
        // Calculates the amount of time until another date-time in terms of the specified unit.

        /** ZonedDateTime	with(TemporalAdjuster adjuster) */
        // Returns an adjusted copy of this date-time.

        /** ZonedDateTime	with(TemporalField field, long newValue) */
        // Returns a copy of this date-time with the specified field set to a new value.

        /** ZonedDateTime	withDayOfMonth(int dayOfMonth) */
        // Returns a copy of this ZonedDateTime with the day-of-month altered.

        /** ZonedDateTime	withDayOfYear(int dayOfYear) */
        // Returns a copy of this ZonedDateTime with the day-of-year altered.

        /** ZonedDateTime	withEarlierOffsetAtOverlap() */
        // Returns a copy of this date-time changing the zone offset to the earlier of the two valid offsets at a local time-line overlap.

        /** ZonedDateTime	withFixedOffsetZone() */
        // Returns a copy of this date-time with the zone ID set to the offset.

        /** ZonedDateTime	withHour(int hour) */
        // Returns a copy of this ZonedDateTime with the hour-of-day altered.

        /** ZonedDateTime	withLaterOffsetAtOverlap() */
        // Returns a copy of this date-time changing the zone offset to the later of the two valid offsets at a local time-line overlap.

        /** ZonedDateTime	withMinute(int minute) */
        // Returns a copy of this ZonedDateTime with the minute-of-hour altered.

        /** ZonedDateTime	withMonth(int month) */
        // Returns a copy of this ZonedDateTime with the month-of-year altered.

        /** ZonedDateTime	withNano(int nanoOfSecond) */
        // Returns a copy of this ZonedDateTime with the nano-of-second altered.

        /** ZonedDateTime	withSecond(int second) */
        // Returns a copy of this ZonedDateTime with the second-of-minute altered.

        /** ZonedDateTime	withYear(int year) */
        // Returns a copy of this ZonedDateTime with the year altered.

        /** ZonedDateTime	withZoneSameInstant(ZoneId zone) */
        // Returns a copy of this date-time with a different time-zone, retaining the instant.

        /** ZonedDateTime	withZoneSameLocal(ZoneId zone) */
        // Returns a copy of this date-time with a different time-zone, retaining the local date-time if possible.

    }

    public void ZoneId() {

        /** boolean	equals(Object obj) */
        // Checks if this time-zone ID is equal to another time-zone ID.

        /** static ZoneId	from(TemporalAccessor temporal) */
        // Obtains an instance of ZoneId from a temporal object.

        /** static Set<String>	getAvailableZoneIds() */
        // Gets the set of available zone IDs.

        /** String	getDisplayName(TextStyle style, Locale locale) */
        // Gets the textual representation of the zone, such as 'British Time' or '+02:00'.

        /** abstract String	getId() */
        // Gets the unique time-zone ID.

        /** abstract ZoneRules	getRules() */
        // Gets the time-zone rules for this ID allowing calculations to be performed.

        /** int	hashCode() */
        // A hash code for this time-zone ID.

        /** ZoneId	normalized() */
        // Normalizes the time-zone ID, returning a ZoneOffset where possible.

        /** static ZoneId	of(String zoneId) */
        // Obtains an instance of ZoneId from an ID ensuring that the ID is valid and available for use.

        /** static ZoneId	of(String zoneId, Map<String,String> aliasMap) */
        // Obtains an instance of ZoneId using its ID using a map of aliases to supplement the standard zone IDs.

        /** static ZoneId	ofOffset(String prefix, ZoneOffset offset) */
        // Obtains an instance of ZoneId wrapping an offset.

        /** static ZoneId	systemDefault() */
        // Gets the system default time-zone.

        /** String	toString() */
        // Outputs this zone as a String, using the ID.

    }

    public void ZoneOffset() {

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have the same offset as this object.

        /** int	compareTo(ZoneOffset other) */
        // Compares this offset to another offset in descending order.

        /** boolean	equals(Object obj) */
        // Checks if this offset is equal to another offset.

        /** static ZoneOffset	from(TemporalAccessor temporal) */
        // Obtains an instance of ZoneOffset from a temporal object.

        /** int	get(TemporalField field) */
        // Gets the value of the specified field from this offset as an int.

        /** String	getId() */
        // Gets the normalized zone offset ID.

        /** long	getLong(TemporalField field) */
        // Gets the value of the specified field from this offset as a long.

        /** ZoneRules	getRules() */
        // Gets the associated time-zone rules.

        /** int	getTotalSeconds() */
        // Gets the total zone offset in seconds.

        /** int	hashCode() */
        // A hash code for this offset.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** static ZoneOffset	of(String offsetId) */
        // Obtains an instance of ZoneOffset using the ID.

        /** static ZoneOffset	ofHours(int hours) */
        // Obtains an instance of ZoneOffset using an offset in hours.

        /** static ZoneOffset	ofHoursMinutes(int hours, int minutes) */
        // Obtains an instance of ZoneOffset using an offset in hours and minutes.

        /** static ZoneOffset	ofHoursMinutesSeconds(int hours, int minutes, int seconds) */
        // Obtains an instance of ZoneOffset using an offset in hours, minutes and seconds.

        /** static ZoneOffset	ofTotalSeconds(int totalSeconds) */
        // Obtains an instance of ZoneOffset specifying the total offset in seconds

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this offset using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** String	toString() */
        // Outputs this offset as a String, using the normalized ID.

    }

    public void DatOfWeek() {

        DayOfWeek monday = DayOfWeek.MONDAY;
        DayOfWeek tuesday = DayOfWeek.TUESDAY;
        DayOfWeek wednesday = DayOfWeek.WEDNESDAY;
        DayOfWeek thursday = DayOfWeek.THURSDAY;
        DayOfWeek friday = DayOfWeek.FRIDAY;
        DayOfWeek saturday = DayOfWeek.SATURDAY;
        DayOfWeek sunday = DayOfWeek.SUNDAY;

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have this day-of-week.

        /** static DayOfWeek	from(TemporalAccessor temporal) */
        // Obtains an instance of DayOfWeek from a temporal object.

        /** int	get(TemporalField field) */
        // Gets the value of the specified field from this day-of-week as an int.

        /** String	getDisplayName(TextStyle style, Locale locale) */
        // Gets the textual representation, such as 'Mon' or 'Friday'.

        /** long	getLong(TemporalField field) */
        // Gets the value of the specified field from this day-of-week as a long.

        /** int	getValue() */
        // Gets the day-of-week int value.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** DayOfWeek	minus(long days) */
        // Returns the day-of-week that is the specified number of days before this one.

        /** static DayOfWeek	of(int dayOfWeek) */
        // Obtains an instance of DayOfWeek from an int value.

        /** DayOfWeek	plus(long days) */
        // Returns the day-of-week that is the specified number of days after this one.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this day-of-week using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** static DayOfWeek	valueOf(String name) */
        // Returns the enum constant of this type with the specified name.

        /** static DayOfWeek[]	values() */
        // Returns an array containing the constants of this enum type, in the order they are declared.

    }

    public void Month() {

        Month january = Month.JANUARY;
        Month february = Month.FEBRUARY;
        Month march = Month.MARCH;
        Month april = Month.APRIL;
        Month may = Month.MAY;
        Month june = Month.JUNE;
        Month july = Month.JULY;
        Month august = Month.AUGUST;
        Month september = Month.SEPTEMBER;
        Month october = Month.OCTOBER;
        Month november = Month.NOVEMBER;
        Month december = Month.DECEMBER;

        /** Temporal	adjustInto(Temporal temporal) */
        // Adjusts the specified temporal object to have this month-of-year.

        /** int	firstDayOfYear(boolean leapYear) */
        // Gets the day-of-year corresponding to the first day of this month.

        /** Month	firstMonthOfQuarter() */
        // Gets the month corresponding to the first month of this quarter.

        /** static Month	from(TemporalAccessor temporal) */
        // Obtains an instance of Month from a temporal object.

        /** int	get(TemporalField field) */
        // Gets the value of the specified field from this month-of-year as an int.

        /** String	getDisplayName(TextStyle style, Locale locale) */
        // Gets the textual representation, such as 'Jan' or 'December'.

        /** long	getLong(TemporalField field) */
        // Gets the value of the specified field from this month-of-year as a long.

        /** int	getValue() */
        // Gets the month-of-year int value.

        /** boolean	isSupported(TemporalField field) */
        // Checks if the specified field is supported.

        /** int	length(boolean leapYear) */
        // Gets the length of this month in days.

        /** int	maxLength() */
        // Gets the maximum length of this month in days.

        /** int	minLength() */
        // Gets the minimum length of this month in days.

        /** Month	minus(long months) */
        // Returns the month-of-year that is the specified number of months before this one.

        /** static Month	of(int month) */
        // Obtains an instance of Month from an int value.

        /** Month	plus(long months) */
        // Returns the month-of-year that is the specified number of quarters after this one.

        /** <R> R	query(TemporalQuery<R> query) */
        // Queries this month-of-year using the specified query.

        /** ValueRange	range(TemporalField field) */
        // Gets the range of valid values for the specified field.

        /** static Month	valueOf(String name) */
        // Returns the enum constant of this type with the specified name.

        /** static Month[]	values() */
        // Returns an array containing the constants of this enum type, in the order they are declared.

    }

    public void String() {

        /** CONSTRUCTORS */

        /** String() */
        // Initializes a newly created String object so that it represents an empty character sequence.

        /** String(byte[] bytes) */
        // Constructs a new String by decoding the specified array of bytes using the platform's default charset.

        /** String(byte[] bytes, Charset charset) */
        // Constructs a new String by decoding the specified array of bytes using the specified charset.

        /** String(byte[] bytes, int offset, int length) */
        // Constructs a new String by decoding the specified subarray of bytes using the platform's default charset.

        /** String(byte[] bytes, int offset, int length, Charset charset) */
        // Constructs a new String by decoding the specified subarray of bytes using the specified charset.

        /** String(byte[] bytes, int offset, int length, String charsetName) */
        // Constructs a new String by decoding the specified subarray of bytes using the specified charset.

        /** String(byte[] bytes, String charsetName) */
        // Constructs a new String by decoding the specified array of bytes using the specified charset.

        /** String(char[] value) */
        // Allocates a new String so that it represents the sequence of characters currently contained in the character array argument.

        /** String(char[] value, int offset, int count) */
        // Allocates a new String that contains characters from a subarray of the character array argument.

        /** String(int[] codePoints, int offset, int count) */
        // Allocates a new String that contains characters from a subarray of the Unicode code point array argument.

        /** String(String original) */
        // Initializes a newly created String object so that it represents the same sequence of characters as the argument; in other words, the newly created string is a copy of the argument string.

        /** String(StringBuffer buffer) */
        // Allocates a new string that contains the sequence of characters currently contained in the string buffer argument.

        /** String(StringBuilder builder) */
        // Allocates a new string that contains the sequence of characters currently contained in the string builder argument.


        /** METHODS */

        /** char	charAt(int index) */
        // Returns the char value at the specified index.

        /** int	codePointAt(int index) */
        // Returns the character (Unicode code point) at the specified index.

        /** int	codePointBefore(int index) */
        // Returns the character (Unicode code point) before the specified index.

        /** int	codePointCount(int beginIndex, int endIndex) */
        // Returns the number of Unicode code points in the specified text range of this String.

        /** int	compareTo(String anotherString) */
        // Compares two strings lexicographically.

        /** int	compareToIgnoreCase(String str) */
        // Compares two strings lexicographically, ignoring case differences.

        /** String	concat(String str) */
        // Concatenates the specified string to the end of this string.

        /** boolean	contains(CharSequence s) */
        // Returns true if and only if this string contains the specified sequence of char values.

        /** boolean	contentEquals(CharSequence cs) */
        // Compares this string to the specified CharSequence.

        /** boolean	contentEquals(StringBuffer sb) */
        // Compares this string to the specified StringBuffer.

        /** static String	copyValueOf(char[] data) */
        // Returns a String that represents the character sequence in the array specified.

        /** static String	copyValueOf(char[] data, int offset, int count) */
        // Returns a String that represents the character sequence in the array specified.

        /** boolean	endsWith(String suffix) */
        // Tests if this string ends with the specified suffix.

        /** boolean	equals(Object anObject) */
        // Compares this string to the specified object.

        /** boolean	equalsIgnoreCase(String anotherString) */
        // Compares this String to another String, ignoring case considerations.

        /** static String	format(Locale l, String format, Object... args) */
        // Returns a formatted string using the specified locale, format string, and arguments.

        /** static String	format(String format, Object... args) */
        // Returns a formatted string using the specified format string and arguments.

        /** byte[]	getBytes() */
        // Encodes this String into a sequence of bytes using the platform's default charset, storing the result into a new byte array.

        /** byte[]	getBytes(Charset charset) */
        // Encodes this String into a sequence of bytes using the given charset, storing the result into a new byte array.

        /** byte[]	getBytes(String charsetName) */
        // Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array.

        /** void	getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) */
        // Copies characters from this string into the destination character array.

        /** int	hashCode() */
        // Returns a hash code for this string.

        /** int	indexOf(int ch) */
        // Returns the index within this string of the first occurrence of the specified character.

        /** int	indexOf(int ch, int fromIndex) */
        // Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.

        /** int	indexOf(String str) */
        // Returns the index within this string of the first occurrence of the specified substring.

        /** int	indexOf(String str, int fromIndex) */
        // Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.

        /** String	intern() */
        // Returns a canonical representation for the string object.

        /** boolean	isEmpty() */
        // Returns true if, and only if, length() is 0.

        /** int	lastIndexOf(int ch) */
        // Returns the index within this string of the last occurrence of the specified character.

        /** int	lastIndexOf(int ch, int fromIndex) */
        // Returns the index within this string of the last occurrence of the specified character, searching backward starting at the specified index.

        /** int	lastIndexOf(String str) */
        // Returns the index within this string of the last occurrence of the specified substring.

        /** int	lastIndexOf(String str, int fromIndex) */
        // Returns the index within this string of the last occurrence of the specified substring, searching backward starting at the specified index.

        /** int	length() */
        // Returns the length of this string.

        /** boolean	matches(String regex) */
        // Tells whether or not this string matches the given regular expression.

        /** int	offsetByCodePoints(int index, int codePointOffset) */
        // Returns the index within this String that is offset from the given index by codePointOffset code points.

        /** boolean	regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) */
        // Tests if two string regions are equal.

        /** boolean	regionMatches(int toffset, String other, int ooffset, int len) */
        // Tests if two string regions are equal.

        /** String	replace(char oldChar, char newChar) */
        // Returns a new string resulting from replacing all occurrences of oldChar in this string with newChar.

        /** String	replace(CharSequence target, CharSequence replacement) */
        // Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.

        /** String	replaceAll(String regex, String replacement) */
        // Replaces each substring of this string that matches the given regular expression with the given replacement.

        /** String	replaceFirst(String regex, String replacement) */
        // Replaces the first substring of this string that matches the given regular expression with the given replacement.

        /** String[]	split(String regex) */
        // Splits this string around matches of the given regular expression.

        /** String[]	split(String regex, int limit) */
        // Splits this string around matches of the given regular expression.

        /** boolean	startsWith(String prefix) */
        // Tests if this string starts with the specified prefix.

        /** boolean	startsWith(String prefix, int toffset) */
        // Tests if the substring of this string beginning at the specified index starts with the specified prefix.

        /** CharSequence	subSequence(int beginIndex, int endIndex) */
        // Returns a new character sequence that is a subsequence of this sequence.

        /** String	substring(int beginIndex) */
        // Returns a new string that is a substring of this string.

        /** String	substring(int beginIndex, int endIndex) */
        // Returns a new string that is a substring of this string.

        /** char[]	toCharArray() */
        // Converts this string to a new character array.

        /** String	toLowerCase() */
        // Converts all of the characters in this String to lower case using the rules of the default locale.

        /** String	toLowerCase(Locale locale) */
        // Converts all of the characters in this String to lower case using the rules of the given Locale.

        /** String	toString() */
        // This object (which is already a string!) is itself returned.

        /** String	toUpperCase() */
        // Converts all of the characters in this String to upper case using the rules of the default locale.

        /** String	toUpperCase(Locale locale) */
        // Converts all of the characters in this String to upper case using the rules of the given Locale.

        /** String	trim() */
        // Returns a copy of the string, with leading and trailing whitespace omitted.

        /** static String	valueOf(boolean b) */
        // Returns the string representation of the boolean argument.

        /** static String	valueOf(char c) */
        // Returns the string representation of the char argument.

        /** static String	valueOf(char[] data) */
        // Returns the string representation of the char array argument.

        /** static String	valueOf(char[] data, int offset, int count) */
        // Returns the string representation of a specific subarray of the char array argument.

        /** static String	valueOf(double d) */
        // Returns the string representation of the double argument.

        /** static String	valueOf(float f) */
        // Returns the string representation of the float argument.

        /** static String	valueOf(int i) */
        // Returns the string representation of the int argument.

        /** static String	valueOf(long l) */
        // Returns the string representation of the long argument.

        /** static String	valueOf(Object obj) */
        // Returns the string representation of the Object argument.

    }

    public void StringBuilder() {

        /** CONSTRUCTORS */

        /** StringBuilder() */
        // Constructs a string builder with no characters in it and an initial capacity of 16 characters.

        /** StringBuilder(CharSequence seq) */
        // Constructs a string builder that contains the same characters as the specified CharSequence.

        /** StringBuilder(int capacity) */
        // Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument.

        /** StringBuilder(String str) */
        // Constructs a string builder initialized to the contents of the specified string.


        /** METHODS */

        /** StringBuilder	append(boolean b) */
        // Appends the string representation of the boolean argument to the sequence.

        /** StringBuilder	append(char c) */
        // Appends the string representation of the char argument to this sequence.

        /** StringBuilder	append(char[] str) */
        // Appends the string representation of the char array argument to this sequence.

        /** StringBuilder	append(char[] str, int offset, int len) */
        // Appends the string representation of a subarray of the char array argument to this sequence.

        /** StringBuilder	append(CharSequence s) */
        // Appends the specified character sequence to this Appendable.

        /** StringBuilder	append(CharSequence s, int start, int end) */
        // Appends a subsequence of the specified CharSequence to this sequence.

        /** StringBuilder	append(double d) */
        // Appends the string representation of the double argument to this sequence.

        /** StringBuilder	append(float f) */
        // Appends the string representation of the float argument to this sequence.

        /** StringBuilder	append(int i) */
        // Appends the string representation of the int argument to this sequence.

        /** StringBuilder	append(long lng) */
        // Appends the string representation of the long argument to this sequence.

        /** StringBuilder	append(Object obj) */
        // Appends the string representation of the Object argument.

        /** StringBuilder	append(String str) */
        // Appends the specified string to this character sequence.

        /** StringBuilder	append(StringBuffer sb) */
        // Appends the specified StringBuffer to this sequence.

        /** StringBuilder	appendCodePoint(int codePoint) */
        // Appends the string representation of the codePoint argument to this sequence.

        /** int	capacity() */
        // Returns the current capacity.

        /** char	charAt(int index) */
        // Returns the char value in this sequence at the specified index.

        /** int	codePointAt(int index) */
        // Returns the character (Unicode code point) at the specified index.

        /** int	codePointBefore(int index) */
        // Returns the character (Unicode code point) before the specified index.

        /** int	codePointCount(int beginIndex, int endIndex) */
        // Returns the number of Unicode code points in the specified text range of this sequence.

        /** StringBuilder	delete(int start, int end) */
        // Removes the characters in a substring of this sequence.

        /** StringBuilder	deleteCharAt(int index) */
        // Removes the char at the specified position in this sequence.

        /** void	ensureCapacity(int minimumCapacity) */
        // Ensures that the capacity is at least equal to the specified minimum.

        /** void	getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) */
        // Characters are copied from this sequence into the destination character array dst.

        /** int	indexOf(String str) */
        // Returns the index within this string of the first occurrence of the specified substring.

        /** int	indexOf(String str, int fromIndex) */
        // Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.

        /** StringBuilder	insert(int offset, boolean b) */
        // Inserts the string representation of the boolean argument into this sequence.

        /** StringBuilder	insert(int offset, char c) */
        // Inserts the string representation of the char argument into this sequence.

        /** StringBuilder	insert(int offset, char[] str) */
        // Inserts the string representation of the char array argument into this sequence.

        /** StringBuilder	insert(int index, char[] str, int offset, int len) */
        // Inserts the string representation of a subarray of the str array argument into this sequence.

        /** StringBuilder	insert(int dstOffset, CharSequence s) */
        // Inserts the specified CharSequence into this sequence.

        /** StringBuilder	insert(int dstOffset, CharSequence s, int start, int end) */
        // Inserts a subsequence of the specified CharSequence into this sequence.

        /** StringBuilder	insert(int offset, double d) */
        // Inserts the string representation of the double argument into this sequence.

        /** StringBuilder	insert(int offset, float f) */
        // Inserts the string representation of the float argument into this sequence.

        /** StringBuilder	insert(int offset, int i) */
        // Inserts the string representation of the second int argument into this sequence.

        /** StringBuilder	insert(int offset, long l) */
        // Inserts the string representation of the long argument into this sequence.

        /** StringBuilder	insert(int offset, Object obj) */
        // Inserts the string representation of the Object argument into this character sequence.

        /** StringBuilder	insert(int offset, String str) */
        // Inserts the string into this character sequence.

        /** int	lastIndexOf(String str) */
        // Returns the index within this string of the rightmost occurrence of the specified substring.

        /** int	lastIndexOf(String str, int fromIndex) */
        // Returns the index within this string of the last occurrence of the specified substring.

        /**int	length() */
        // Returns the length (character count).

        /** int	offsetByCodePoints(int index, int codePointOffset) */
        // Returns the index within this sequence that is offset from the given index by codePointOffset code points.

        /** StringBuilder	replace(int start, int end, String str) */
        // Replaces the characters in a substring of this sequence with characters in the specified String.

        /** StringBuilder	reverse() */
        // Causes this character sequence to be replaced by the reverse of the sequence.

        /** void	setCharAt(int index, char ch) */
        // The character at the specified index is set to ch.

        /** void	setLength(int newLength) */
        // Sets the length of the character sequence.

        /** CharSequence	subSequence(int start, int end) */
        // Returns a new character sequence that is a subsequence of this sequence.

        /** String	substring(int start) */
        // Returns a new String that contains a subsequence of characters currently contained in this character sequence.

        /** String	substring(int start, int end) */
        // Returns a new String that contains a subsequence of characters currently contained in this sequence.

        /** String	toString() */
        // Returns a string representing the data in this sequence.

        /** void	trimToSize() */
        // Attempts to reduce storage used for the character sequence.


    }



}

