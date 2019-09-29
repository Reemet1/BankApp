package com.prometheus.learning.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeEvents {

    public void dateArithmetic() {

        LocalDateTime localDateTime = LocalDateTime.of(2019, 5, 8, 12, 40, 12);

        localDateTime.plus(2, ChronoUnit.DAYS);
        localDateTime.minus(1, ChronoUnit.MILLIS);

        /** Adds 10 hours to localDateTime */
        localDateTime = ChronoUnit.HOURS.addTo(localDateTime, 10);

        ChronoUnit.DAYS.between(localDateTime, localDateTime);

        /** ChronoUnit implements TemporalUnit interface and provides time units
         *  from NANOS to FOREVER */

    }

    public void chronoFields() {

        ChronoUnit[] chronoUnits = new ChronoUnit[] {
                ChronoUnit.FOREVER, ChronoUnit.ERAS, ChronoUnit.MILLENNIA,
                ChronoUnit.CENTURIES, ChronoUnit.DECADES, ChronoUnit.YEARS,
                ChronoUnit.MONTHS, ChronoUnit.WEEKS, ChronoUnit.DAYS, ChronoUnit.HALF_DAYS,
                ChronoUnit.HOURS, ChronoUnit.MINUTES, ChronoUnit.SECONDS,
                ChronoUnit.MILLIS, ChronoUnit.MICROS, ChronoUnit.NANOS};

        chronoUnits = ChronoUnit.values();
        ChronoUnit fromString = ChronoUnit.valueOf("HOURS");

        ChronoField[] chronoFields = {
                ChronoField.ERA, ChronoField.EPOCH_DAY,
                ChronoField.YEAR_OF_ERA, ChronoField.YEAR,
                ChronoField.MONTH_OF_YEAR, ChronoField.PROLEPTIC_MONTH,
                ChronoField.ALIGNED_WEEK_OF_YEAR, ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH,
                ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR, ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH,
                ChronoField.DAY_OF_YEAR, ChronoField.DAY_OF_MONTH, ChronoField.DAY_OF_WEEK,
                ChronoField.HOUR_OF_AMPM, ChronoField.HOUR_OF_DAY,
                ChronoField.MINUTE_OF_DAY, ChronoField.MINUTE_OF_HOUR,
                ChronoField.SECOND_OF_DAY, ChronoField.SECOND_OF_MINUTE,
                ChronoField.MILLI_OF_DAY, ChronoField.MILLI_OF_SECOND,
                ChronoField.MICRO_OF_DAY, ChronoField.MICRO_OF_SECOND,
                ChronoField.NANO_OF_DAY, ChronoField.NANO_OF_SECOND,
                ChronoField.INSTANT_SECONDS, ChronoField.OFFSET_SECONDS
        };

        chronoFields = ChronoField.values();
        ChronoField dayOfYear = ChronoField.valueOf("DAY_OF_YEAR");

    }

}
