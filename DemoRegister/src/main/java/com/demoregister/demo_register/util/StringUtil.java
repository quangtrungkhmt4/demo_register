package com.demoregister.demo_register.util;

import java.util.UUID;

public class StringUtil {
    public static String randomString(){
        return UUID.randomUUID().toString();
    }

    public static boolean validateString(String... args) {
        for (String arg : args) {
            if (arg == null || arg.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
