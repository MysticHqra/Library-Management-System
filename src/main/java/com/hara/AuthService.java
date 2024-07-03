package com.hara;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, String> roles = new HashMap<>();

    static {
        // username:password
        users.put("Hara1", "admin123");
        users.put("Hara2", "user123");

        // username:role
        roles.put("Hara1", "ADMIN");
        roles.put("Hara2", "USER");
    }

    public static boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static String getRole(String username) {
        return roles.get(username);
    }
}
