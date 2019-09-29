package com.prometheus.learning.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;

public class TimeZones {

    public void timeZones() {

        /** ZoneId instance represents the identity of a time-zone, which is used to
         *  identify the rules to convert between Instant and a LocalDateTime */

        /** ZoneId is created with of factory method that accepts 2 types of String parameters */
        ZoneId timeZone = ZoneId.of("UTC-06:00"); //UTC - Universal Time Coordinated
        timeZone = ZoneId.of("UT-06:00"); //UT - Universal Time
        timeZone = ZoneId.of("GMT-06:00"); //GMT - Greenwich Mean Time

        timeZone = ZoneId.of("America/Chicago"); //Geographical region based

        Set<String> zoneIds = ZoneId.getAvailableZoneIds();

        /** ZoneOffset is a subclass of ZoneId. Instance of this class represents
         *  the amount of time that time-zone differs from UTC */

        //ZoneOffset zoneOffset = ZoneOffset.of("GMT+02:00");
        //zoneOffset.ofHours(10);

        ZoneOffset simple = ZoneOffset.of("+6");
        ZoneOffset normalized = ZoneOffset.of("+06:00");
        ZoneOffset ofHours = ZoneOffset.ofHours(6);

        simple = ZoneOffset.of("+Z"); //+ is required, Z is used instead of 0


    }

    public void offSetTime() {

        /** OffsetTime instance indicates a time with an offset from UTC in the
         *  ISO-8601 calendar system, storing all the fields to a precision of nanoseconds */

        LocalTime localTime = LocalTime.of(15, 30, 10);
        ZoneOffset zoneOffset = ZoneOffset.of("+06:00");

        OffsetTime offsetTime = OffsetTime.of(localTime, zoneOffset);
        offsetTime.plusHours(10).minusMinutes(10);

        ZoneOffset zoneOffset2 = ZoneOffset.of("+07:00");

        /** Moving offsetTime to new timezone */
        offsetTime = offsetTime.withOffsetSameInstant(zoneOffset2);

    }

    public void offsetDateTime() {

        /** OffsetDateTime instance indicates a date-time with an offset from UTC in the
         *  ISO-8601 calendar system, storing all the date and time fields to a precision
         *  of nanoseconds.
         */

        LocalDateTime localDateTime = LocalDateTime.of(2019, 5, 8, 12, 10, 44);
        LocalDate localDate = LocalDate.of(2019, 5, 8);
        LocalTime localTime = LocalTime.of(12,10,44);

        ZoneOffset zoneOffset1 = ZoneOffset.of("+01:00");
        ZoneOffset zoneOffset2 = ZoneOffset.of("+02:00");

        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(localDateTime, zoneOffset1);
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(localDate, localTime, zoneOffset2);
        offsetDateTime1.plusHours(1).isBefore(offsetDateTime2);

    }

    public void zonedDateTime() {

        /** ZonedDateTime instance indicates a date-time with a timezone in the ISO-8601 calendar system,
         *  storing all the date and time field with a precision of nanoseconds.
         *  Used with region-based timezones
         */

        LocalDateTime localDateTime = LocalDateTime.of(2019, 5, 8, 12, 10, 44);

        ZoneId zoneId = ZoneId.of("America/Los_Angeles");

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        zonedDateTime.getOffset();

    }

    public void daylightSavings() {

    }

    public void dateTimeFormatter() {

        /** DateTimeFormatter is used to parse and format date and time objects*/

        /** Custom datetime format */
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("y-M-d 'string'");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        LocalDateTime localDateTime = LocalDateTime.parse("2019-5-8 str1", dateTimeFormatter1);

        ZoneId zoneId = ZoneId.of("UTC-06:00");

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);

        String formattedDateStr1 = zonedDateTime.format(dateTimeFormatter2);
        String formattedDateStr2 = zonedDateTime.format(dateTimeFormatter3);






    }

}
