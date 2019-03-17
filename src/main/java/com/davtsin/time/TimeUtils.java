package com.davtsin.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class TimeUtils {

    /*
     * Формат даты для РФ. Время указывается опционально.
     * */
    public static final String RUS_DATE_FORMAT_OPTIONAL_TIME = "dd.MM.yyyy[_HH:mm:ss]";

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


    public static LocalDateTime parseDateToLocalDateTime(String date) {
        return parseDateToLocalDateTime(date, DATE_TIME_FORMATTER_START_OF_DAY);
    }

    /*
     *  Преобразование строки формата "dd.MM.yyyy" или формата "dd.MM.yyyy_HH:mm:ss" к LocalDateTime.
     *  Если задана только дата, то время устанавливается в соответсвии с парматером dateTimeFormatter
     * */
    public static LocalDateTime parseDateToLocalDateTime(String date, DateTimeFormatter dateTimeFormatter) {
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

    public static DateTimeFormatter endOfDay() {
        return DATE_TIME_FORMATTER_END_OF_DAY;
    }
}
