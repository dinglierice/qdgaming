package com.qdgaming.utility.util;

import org.apache.commons.codec.digest.Crypt;

import java.util.Objects;

public class CryptUtil {
    private static final String SALT_VALUE = "35";
    public static String bCryptEncode(String rawPassword) {
        return Crypt.crypt(rawPassword, SALT_VALUE);
    }

    public static boolean bCryptMatches(String rawPassword, String encodedPassword) {
        String crypt = Crypt.crypt(rawPassword, SALT_VALUE);
        return Objects.equals(encodedPassword, crypt);
    }
}
