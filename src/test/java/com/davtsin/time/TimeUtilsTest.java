package com.davtsin.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import static com.davtsin.time.TimeUtils.endOfDay;
import static com.davtsin.time.TimeUtils.parseDateToLocalDateTime;

public class TimeUtilsTest {

    private final int N = 100;
    private String date = "27.04.1987";

    @Test
    public void formatTest() {
        LocalDateTime localDateTime1 = parseDateToLocalDateTime(date);
        LocalDateTime localDateTime2 = parseDateToLocalDateTime(date, endOfDay());
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }

    @Test
    public void precompilledFormatter() {
        for (int i = 0; i < N; i++) {
            parseDateToLocalDateTime(date);
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
            new Thread(() -> parseDateToLocalDateTime(date)).start();
        }
    }

    @Test
    public void multithreadingParseEachThreadHasOwnFormatter() {
        for (int i = 0; i < N; i++) {
            new Thread(() -> TimeUtils.parseEachTimeNewFormatter(date)).start();
        }
    }
}
