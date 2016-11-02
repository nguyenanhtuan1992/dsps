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

    /**
     * get current Date
     * @return
     */
    public static Date getCurrentDate(){
        return new Date();
    }

    /**
     * compare Date vs Date
     * @param dateInput1
     * @param dateInput2
     * @return return -1 if dateInput1 < dateInput2, 0 if dateInput1 = dateInput2, 1 if dateInput1 > dateInput2
     */
    public static int compareDate(Date dateInput1, Date dateInput2){
        return Long.compare(dateInput1.getTime(), dateInput2.getTime());
    }
}