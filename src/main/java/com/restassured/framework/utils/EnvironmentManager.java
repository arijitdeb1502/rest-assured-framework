package com.restassured.framework.utils;

public class EnvironmentManager {

    public static String getEnvironment() {

        String env = System.getProperty("env");
        
        System.out.print("#########env:#########"+env);

        if(env == null || env.isEmpty()) {
            env = "DEV";
        }

        return env;
    }
    
}