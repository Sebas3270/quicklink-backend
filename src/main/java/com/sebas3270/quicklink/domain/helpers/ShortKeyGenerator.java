package com.sebas3270.quicklink.domain.helpers;

import java.security.SecureRandom;

public final class ShortKeyGenerator {

    private static final String BASE62 =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final SecureRandom RANDOM = new SecureRandom();

    private static final int DEFAULT_LENGTH = 7; // 62^7 ≈ 3.5T

    private ShortKeyGenerator() {}

    public static String generate() {
        StringBuilder sb = new StringBuilder(DEFAULT_LENGTH);
        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            sb.append(BASE62.charAt(RANDOM.nextInt(62)));
        }
        return sb.toString();
    }
}