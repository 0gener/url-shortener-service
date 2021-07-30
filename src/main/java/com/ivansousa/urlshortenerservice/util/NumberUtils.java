package com.ivansousa.urlshortenerservice.util;

public class NumberUtils {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encodeToBase62(Long num) {
        if (num.equals(0L))
            return BASE62.substring(0, 1);

        StringBuilder builder = new StringBuilder();

        while (num > 0L) {
            Long remainder = num % 62;
            num = num / 62;
            builder.append(BASE62.charAt(remainder.intValue()));
        }

        return builder.reverse().toString();
    }

    public static Long decodeFromBase62(String base62) {
        Long num = 0L;

        for (int i = 0; i < base62.length(); i++) {
            int power = (base62.length() - (i + 1));
            num += BASE62.indexOf(base62.charAt(i)) * ((long) Math.pow(62, power));
        }

        return num;
    }
}
