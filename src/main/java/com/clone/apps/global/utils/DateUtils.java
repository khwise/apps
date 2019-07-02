package com.clone.apps.global.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by kh.jin on 2019. 7. 1.
 *
 * Java 8에서 부터 지원하는 LocalDate, LocalDataTime 을 사용한다.
 */
public class DateUtils {

    public static LocalDate from(String strDate, String pattern) {
        return LocalDate.parse(strDate, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime after(Long afterSeconds) {
        return LocalDateTime.now().plusSeconds(afterSeconds);
    }

    public static Date convertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
