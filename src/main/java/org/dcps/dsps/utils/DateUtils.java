package org.dcps.dsps.utils;

import org.apache.commons.lang3.StringUtils;
import org.dcps.dsps.constant.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * Convert Date to String with pattern format
     * @param date
     * @param pattern
     * @return string date with pattern format
     */
    public static String convertDateToString(Date date, String pattern) {
        pattern = StringUtils.isBlank(pattern) ? Constant.PATTERN_DATE_DEFAULT : pattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * Convert Date with pattern format
     * @param dateInput
     * @param pattern
     * @return
     */
    public static Date convertStringToDate(String dateInput, String pattern) {
        pattern = StringUtils.isBlank(pattern) ? Constant.PATTERN_DATE_DEFAULT : pattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}