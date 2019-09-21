package com.clone.apps.global.common.utils;

import java.time.*;

/**
 * Created by kh.jin on 2019. 7. 1.
 */
public class DateUtils {

    public static Long toMilliseconds(LocalDate localDate) {
        return toMilliseconds(LocalDateTime.of(localDate, LocalTime.of(0,0,0)));
    }

    public static Long toMilliseconds(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static LocalDateTime toLocalDateTime(Long milliseconds) {
        return getDefaultZonedDateTime(milliseconds).toLocalDateTime();
    }

    public static LocalDate toLocalDate(Long milliseconds) {
        return getDefaultZonedDateTime(milliseconds).toLocalDate();
    }

    public static ZonedDateTime getDefaultZonedDateTime(Long milliseconds) {
        return getDefaultInstant(milliseconds).atZone(ZoneId.systemDefault());
    }

    public static Instant getDefaultInstant(Long milliseconds) {
        return Instant.ofEpochMilli(milliseconds);
    }
}