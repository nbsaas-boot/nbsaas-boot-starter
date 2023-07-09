package com.nbsaas.boot.pay.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static Date parseMonth(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM");
        Date result = null;
        try {
            result = dateFormat.parse(date);
        } catch (Exception e) {

        }
        return result;
    }

    public static Date parseBegin(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date result = null;
        try {
            result = dateFormat.parse(date);
            result = begin(result);
        } catch (Exception e) {

        }
        return result;
    }

    public static Date parseEnd(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date result = null;
        try {
            result = dateFormat.parse(date);
            result = end(result);
        } catch (Exception e) {

        }
        return result;
    }

    public static String format(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String result = new String();
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {

        }
        return result;
    }

    public static String formatChinese(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String result = new String();
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {

        }
        return result;
    }

    public static String format(Date begin, Date end) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        String result = new String();
        try {
            result = dateFormat.format(begin);
            result = result + "-" + timeFormat.format(end);
        } catch (Exception e) {

        }
        return result;
    }

    public static String format1(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String result = new String();
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {

        }
        return result;
    }

    public static String formatDay(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        String result = new String();
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {

        }
        return result;
    }

    public static Date oneYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();

    }

    public static String formatTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日 HH点mm分");
        String result = new String();
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {

        }
        return result;
    }

    public static String formatFull(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String result = new String();
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {

        }
        return result;
    }

    public static String formatSimpleTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String result = new String();
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {

        }
        return result;
    }

    public static String day() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String result = new String();
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {

        }
        return result;

    }
    public static String month() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        String result = new String();
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {

        }
        return result;

    }
    public static Long second() {
        return System.currentTimeMillis() / 1000;
    }

    public static String formatSimple(Date date) {
        StringBuffer buffer = new StringBuffer();
        if (date != null) {
            buffer.append(date.getMonth());
            buffer.append(".");
            buffer.append(date.getDate());
        }
        return buffer.toString();
    }

    public static Date end(Long date) {
        return end(date);
    }

    public static Date end(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date begin(Long date) {
        return begin(new Date(date));
    }

    public static Date begin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date beginMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 1);
        return calendar.getTime();
    }

    public static Date endMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.SECOND, -1);
        return calendar.getTime();
    }
}
