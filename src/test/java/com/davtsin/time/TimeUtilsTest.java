package com.davtsin.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import static com.davtsin.time.TimeUtils.*;

public class TimeUtilsTest {

    private final int N = 100;
    private String date = "27.04.1987";

    @Test
    public void formatTest() {

        System.out.println(TimeUtils.parseDateToLocalDateTime(date));
        System.out.println(TimeUtils.parseDateToLocalDateTime(date, LocalTime.MAX));


        LocalDateTime localDateTime1 = parseDateOrDateTimeToLocalDateTime(date);
        LocalDateTime localDateTime2 = parseDateOrDateTimeToLocalDateTime(date, endOfDay());
        LocalDateTime localDateTime3 = parseDateOrDateTimeToLocalDateTime(date, timeOfDay(15, 45, 35));
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
    }

    @Test
    public void precompilledFormatter() {
        for (int i = 0; i < N; i++) {
            parseDateOrDateTimeToLocalDateTime(date);
        }
    }

    @Test
    public void eachTimeNewFormatter() {
        for (int i = 0; i < N; i++) {
            TimeUtils.parseEachTimeNewFormatter(date);
        }
    }

    @Test
    public void timeOfFormatterBuilding() {
        for (int i = 0; i < N; i++) {
            new DateTimeFormatterBuilder()
                    .appendPattern("dd.MM.yyyy[HH:mm:ss]")
                    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                    .toFormatter();
        }
    }

    @Test
    public void multithreadingParseWithOneFormatter() {
        for (int i = 0; i < N; i++) {
            new Thread(() -> parseDateOrDateTimeToLocalDateTime(date)).start();
        }
    }

    @Test
    public void multithreadingParseEachThreadHasOwnFormatter() {
        for (int i = 0; i < N; i++) {
            new Thread(() -> TimeUtils.parseEachTimeNewFormatter(date)).start();
        }
    }
}
