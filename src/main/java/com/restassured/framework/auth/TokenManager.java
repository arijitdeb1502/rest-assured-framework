package com.restassured.framework.auth;

public final class TokenManager {

    private static String token;

    private TokenManager() {
    }

    public static void initialize() {

        // We will call the authentication API later.
        token = "";

    }

    public static String getToken() {

        return token;

    }

    public static void setToken(String jwtToken) {

        token = jwtToken;

    }



}