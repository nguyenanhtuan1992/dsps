package org.dcps.dsps.utils;

import com.sun.javafx.binding.StringFormatter;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * Convert Date to String with pattern format
     * @param date
     * @param pattern
     * @return string date with pattern format
     */
    public String convertDate(Date date, String pattern) {
        pattern = StringUtils.isBlank(pattern) ? Constant.PATTERN_DATE_DEFAULT : pattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}