package com.prometheus.learning.utils;

import java.time.*;
import java.time.temporal.ChronoField;

public class DateTime {


    /**
     * Most of the classes in Date-Time API are immutable, allowing to offload
     * concurrency handling. BlockChain classes of java.time package include
     * LocalDate, LocalTime, LocalDateTime, Instant, Period, Duration.
     *
     * BlockChain methods are with the following prefixes
     *
     *  of*    - creates an instance of the class using input values
     *  from   - converts the input value to the instance of the class
     *  with*  - returns a copy of the object with the specified field modified
     *  plus*  - returns a copy of the object with the specified amount added
     *  minus* - returns a copy of the object with the specified amount subtracted
     *  at*    - combines the object with another to form an instance of a more complex class
     *  parse  - parse the input String to create an instance of the class
     *  get*   - retrieves the value of the specified field of the object
     *  is*    - queries the state of the object
     */

    public void localDate() {

        /** LocalDate instance represents a date without a time-zone in the ISO-8601 calendar system*/

        /** Returns a specified LocalDate object */
        LocalDate date1 = LocalDate.of(2019, 5, 8);
        date1 = LocalDate.parse("2019.5.8");

        date1.getDayOfWeek(); date1.getDayOfMonth(); date1.getDayOfYear();
        date1.getYear(); date1.getMonthValue();

        date1.isLeapYear();
        date1.isAfter(date1);
        date1.isBefore(date1);
        date1.isEqual(date1);

        date1.get(ChronoField.DAY_OF_YEAR);

        /** Returns a new DateTime object with modifier year, month or day*/
        date1.withYear(2019).withMonth(5).withDayOfMonth(8);

        /** Adds or substracts a specified amount of days, weeks, months or years from date1 */
        date1.plusDays(1).plusWeeks(2).plusMonths(3).plusYears(4);
        date1.minusDays(1).minusWeeks(2).minusMonths(3).minusYears(4);

    }

    public void localTime() {

        /** LocalTime instance represents a time without a time-zone in the ISO-8601 calendar system */
        LocalTime time1 = LocalTime.of(20,11,56);
        time1 = LocalTime.parse("20:11:56");

        time1.withNano(10).withSecond(10).withMinute(10).withHour(10);
        time1.with(ChronoField.MINUTE_OF_HOUR, 10);

        time1.isAfter(time1);
        time1.isBefore(time1);

        time1.get(ChronoField.SECOND_OF_MINUTE);


    }

    public void localDateTime() {

        /** LocalDateTime instance represents a date-time without a time-zone in the ISO-8601 calendar system */
        LocalDateTime dateTime = LocalDateTime.of(2019, 5, 9, 18, 29, 40);

        LocalDate localDate = LocalDate.of(2019, 5, 9);
        LocalTime localTime = LocalTime.of(18, 30, 11);

        /** Combinding LocalDateTime from LocalDate and LocalTime */
        dateTime = localDate.atTime(localTime);

        localDate = dateTime.toLocalDate();
        localTime = dateTime.toLocalTime();

        localDate = LocalDate.from(dateTime);
        localTime = LocalTime.from(dateTime);

        dateTime.plusMonths(2).minusHours(1);

    }

    public void instant() {

        /** Instant object represents an instantaneous point on the timeline, must be below 1 second */
        Instant now = Instant.now();
        Instant instant = Instant.ofEpochSecond(100,848378593458L);

        now.isAfter(instant);
        now.isBefore(instant);
        now.plusNanos(100L).plusMillis(100).plusSeconds(10);

    }

    public void period() {

        /** Period instance represents a date-based amount of time in the ISO-8601 calendar system */

        Period period = Period.of(1,2,3);
        period.plusYears(1).plusMonths(1).plusDays(1);

        LocalDate localDate = LocalDate.of(2019, Month.MAY, 8);
        localDate.plus(period);

    }

    public void duration() {

        /** Duration instance indicates a time-based amount of time in the ISO-8601 calendar system*/

        Duration duration = Duration.ofDays(3).ofMinutes(15);

        LocalTime time1 = LocalTime.of(2,10,15);
        LocalTime time2 = LocalTime.of(1, 30, 13);

        duration = Duration.between(time1, time2);

    }

}
