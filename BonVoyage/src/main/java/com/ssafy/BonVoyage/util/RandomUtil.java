package com.ssafy.BonVoyage.util;

import java.util.Random;

public class RandomUtil {

    private static final Random rand = new Random();

    public static String generateRandomCode(char leftLimit, char rightLimit, int length) {
        return rand.ints(leftLimit, rightLimit + 1)
                .filter(i -> Character.isAlphabetic(i) || Character.isDigit(i))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }
}
