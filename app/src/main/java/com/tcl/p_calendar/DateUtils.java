package com.tcl.p_calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by luoyuhang on 2017/6/2 0002.
 * 日期时间工具类
 */

public class DateUtils {
    //一天
    public static final int aDay = 86400;
    private static final String format = "MM-dd-yyyy HH:mm";
    private static final String format1 = "MM-dd-yyyy";
    private static final String format2 = "HH:mm";
    private static final String format3 = "MM-dd HH:mm";
    private static SimpleDateFormat formatter;
    private static Date date;
    private static Locale locale;
    /**
     * 提取时间戳年月日2
     *
     * @param time
     * @return
     */
    private static int[] weekOfDays = {0, 1, 2, 3, 4, 5, 6};

    /**
     * 获取当前日期
     *
     * @return String
     * MM-dd-yyyy
     */
    public static String getCurrentDateStr() {
        formatter = new SimpleDateFormat(format1);
        date = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(date);
        return str;
    }

    /**
     * 获取当前日期时间戳
     *
     * @return
     */
    public static long getCurrentDateLong() {
        return getDateTimestampLong(getCurrentDateStr());
    }

    /**
     * 日期时间转为时间戳
     *
     * @param date_time
     * @return 时间戳
     * long
     */
    public static long getDateTimeTimestampLong(String date_time) {
        long re_time = 0;
        formatter = new SimpleDateFormat(format);
        try {
            date = formatter.parse(date_time);
            re_time = date.getTime() / 1000;
        } catch (ParseException e) {
        }
        return re_time;
    }

    /**
     * 日期转为时间戳
     *
     * @param date_time
     * @return 时间戳
     * long
     */
    public static long getDateTimestampLong(String date_time) {
        long re_time = 0;
        formatter = new SimpleDateFormat(format1);
        try {
            date = formatter.parse(date_time);
            re_time = date.getTime() / 1000;
        } catch (ParseException e) {
        }
        return re_time;
    }

    /**
     * 时间转为时间戳
     *
     * @param time
     * @return 时间戳
     * long
     */
    public static long getTimeTimestampLong(String time) {
        long re_time = 0;
        formatter = new SimpleDateFormat(format2);
        try {
            date = formatter.parse(time);
            re_time = date.getTime() / 1000;
        } catch (ParseException e) {
        }
        return re_time;
    }

    /**
     * 时间戳转为日期
     *
     * @param lcc_time
     * @return
     */
    public static String getDateStr(Long lcc_time) {
        if (lcc_time == null) {
            return "";
        }
        String re_StrTime = null;
        formatter = new SimpleDateFormat(format1);
        re_StrTime = formatter.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /**
     * 时间戳转为日期
     *
     * @param lcc_time
     * @return
     */
    public static String getDateStr3(Long lcc_time) {
        if (lcc_time == null) {
            return "";
        }
        String re_StrTime = null;
        formatter = new SimpleDateFormat(format3);
        re_StrTime = formatter.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /**
     * 时间戳转为时间(更随系统语言格式化--时间)
     *
     * @param lcc_time
     * @return
     */
    public static String getTimeStrFormat(Long lcc_time) {
        if (lcc_time == null) {
            return "";
        }
        locale = Locale.getDefault();
        if (locale == null) {
            locale = new Locale("en");
        }
        DateFormat shortDateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
        String re_StrTime = shortDateFormat.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /**
     * 时间戳转为日期(更随系统语言格式化--日期)
     *
     * @param lcc_time
     * @return
     */
    public static String getDateStrFormat(Long lcc_time) {
        if (lcc_time == null) {
            return "";
        }
        locale = Locale.getDefault();
        if (locale == null) {
            locale = new Locale("en");
        }
        DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String re_StrTime = shortDateFormat.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /**
     * 时间戳转为日期时间(更随系统语言格式化--日期+时间)
     *
     * @param lcc_time
     * @return
     */
    public static String getDateTimeStrFormat(Long lcc_time) {
        if (lcc_time == null) {
            return "";
        }
        locale = Locale.getDefault();
        if (locale == null) {
            locale = new Locale("en");
        }
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, locale);
        String re_StrTime = shortDateFormat.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /**
     * 时间戳转为Date
     *
     * @param lcc_time
     * @return
     */
    public static Date getDate(Long lcc_time) {
        formatter = new SimpleDateFormat(format1);
        String d = formatter.format(lcc_time * 1000);
        Date date = null;
        try {
            date = formatter.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取年
     * Calendar calendar = Calendar.getInstance()
     *
     * @return
     */
    public static int getYear(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp * 1000);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月
     *
     * @return
     */
    public static int getMonth(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp * 1000);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日
     *
     * @return
     */

    public static int getDay(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp * 1000);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取小时
     *
     * @return
     */

    public static int getHour(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp * 1000);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取分钟
     *
     * @return
     */
    public static int getMinute(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp * 1000);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 提取时间戳星期
     *
     * @param time
     * @return
     */
    public static int getDateWeek(long time) {
        Date d = new Date(time * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekOfDays[w];
    }
}
