package com.codingfairy.tool;

/**
 * Created by darxan on 17-5-17.
 */
public class Logger {

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void print(Object object) {
        System.out.print(object);
    }

    public static void debug(Object object) {
        System.out.println(object);
    }

    public static void err(Object object) {
        System.err.println(object);
    }
}
