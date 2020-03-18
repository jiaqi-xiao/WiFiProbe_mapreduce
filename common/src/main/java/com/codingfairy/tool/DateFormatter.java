package com.codingfairy.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by darxan on 17-5-16.
 */
public class DateFormatter {
    private static final SimpleDateFormat dateFomat =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", new Locale("ENGLISH", "CHINA"));

    public static Date getDate(String time) throws ParseException {
        return dateFomat.parse(time);
    }

    public static String toString(long time) {
        return dateFomat.format(new Date(time));
    }


    public static long getMillis(String time) throws ParseException {
        return dateFomat.parse(time).getTime();
    }

    public static void main(String[] args) throws Exception{
        String time = "Mon May 22 22:00:00 2017";
        System.out.println(DateFormatter.getMillis(time));
    }
}