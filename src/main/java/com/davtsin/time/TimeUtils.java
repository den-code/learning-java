package com.davtsin.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class TimeUtils {

    /*
     * Формат даты для РФ. Время указывается опционально.
     * */
    public static final String RUS_DATE_FORMAT_OPTIONAL_TIME = "dd.MM.yyyy[_HH:mm:ss]";

    public static final String RUS_DATE_FORMAT = "dd.MM.yyyy";
    private static final DateTimeFormatter RUS_DATE_FORMATTER =
            DateTimeFormatter.ofPattern(RUS_DATE_FORMAT);

    public static LocalDateTime parseDateToLocalDateTime(String date) {
        return parseDateToLocalDateTime(date, LocalTime.MIN);
    }

    public static LocalDateTime parseDateToLocalDateTime(String date, LocalTime localTime) {
        return LocalDate.parse(date, RUS_DATE_FORMATTER).atTime(localTime);
    }


    private static final DateTimeFormatter DATE_TIME_FORMATTER_START_OF_DAY =
            new DateTimeFormatterBuilder()
                    .appendPattern(RUS_DATE_FORMAT_OPTIONAL_TIME)
                    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                    .toFormatter();

    private static final DateTimeFormatter DATE_TIME_FORMATTER_END_OF_DAY =
            new DateTimeFormatterBuilder()
                    .appendPattern(RUS_DATE_FORMAT_OPTIONAL_TIME)
                    .parseDefaulting(ChronoField.HOUR_OF_DAY, 23)
                    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 59)
                    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 59)
                    .toFormatter();

    public static DateTimeFormatter endOfDay() {
        return DATE_TIME_FORMATTER_END_OF_DAY;
    }

    public static DateTimeFormatter timeOfDay(int hour, int minute, int seconds) {
        return new DateTimeFormatterBuilder()
                .appendPattern(RUS_DATE_FORMAT_OPTIONAL_TIME)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, hour)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, minute)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, seconds)
                .toFormatter();
    }

    /*
     *  Преобразование строки формата "dd.MM.yyyy" или формата "dd.MM.yyyy_HH:mm:ss" к LocalDateTime.
     *  Если задана дата без времени, то время устанавливается на начало дня.
     * */
    public static LocalDateTime parseDateOrDateTimeToLocalDateTime(String date) {
        return parseDateOrDateTimeToLocalDateTime(date, DATE_TIME_FORMATTER_START_OF_DAY);
    }

    /*
     *  Преобразование строки формата "dd.MM.yyyy" или формата "dd.MM.yyyy_HH:mm:ss" к LocalDateTime.
     *  Если задана дата без времени, то время устанавливается в соответсвии с парматером dateTimeFormatter
     * */
    public static LocalDateTime parseDateOrDateTimeToLocalDateTime(String date, DateTimeFormatter dateTimeFormatter) {
        return LocalDateTime.parse(date, dateTimeFormatter);
    }


    public static LocalDateTime parseEachTimeNewFormatter(String date) {
        DateTimeFormatter dateTimeFormatter =
                new DateTimeFormatterBuilder()
                        .appendPattern(RUS_DATE_FORMAT_OPTIONAL_TIME)
                        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                        .toFormatter();

        return LocalDateTime.parse(date, dateTimeFormatter);
    }
}
