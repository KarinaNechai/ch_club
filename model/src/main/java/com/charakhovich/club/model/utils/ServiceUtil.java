package com.charakhovich.club.model.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiceUtil {
    private static final String DATE_TIME_PATTERN="yyyy-MM-dd HH:mm";
    private static final String DATE_PATTERN="yyyy-MM-dd";
    public static final Logger LOGGER = LogManager.getLogger(ServiceUtil.class);

    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);
        return md5Hex;
    }

    public static LocalDateTime DateTimeConverter(LocalDateTime locDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        String formattedDateTime = locDateTime.format(formatter);
        locDateTime = LocalDateTime.parse(formattedDateTime, formatter);
        return locDateTime;
    }

    public static LocalDateTime DateConverter(LocalDateTime locDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        String formattedDateTime = locDate.format(formatter);
        locDate = LocalDateTime.parse(formattedDateTime, formatter);
        return locDate;
    }
}