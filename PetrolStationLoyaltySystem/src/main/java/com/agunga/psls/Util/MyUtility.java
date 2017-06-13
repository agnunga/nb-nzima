package com.agunga.psls.Util;

/**
 * Created by agunga on 1/17/17. This Class contains 2 copy methods
 */
public class MyUtility {

    public static long parseLong(String s) {
        long n = 0;
        try {
            n = Long.parseLong(s);
        } catch (NumberFormatException e) {
        }
        return n;
    }

    public static double parseDouble(String s) {
        double n = 0.0;
        try {
            n = Double.parseDouble(s);
        } catch (NumberFormatException e) {
        }
        return n;
    }
}
