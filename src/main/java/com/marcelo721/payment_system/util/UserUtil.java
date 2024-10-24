package com.marcelo721.payment_system.util;

import java.security.SecureRandom;

public class UserUtil {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPKRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomString(int length){

        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < length; i++){
            int index = random.nextInt(CHARACTERS.length());
            stringBuilder.append(CHARACTERS.charAt(index));
        }
        return stringBuilder.toString();
    }
}
