package com.restassured.framework.payloads;

import com.restassured.framework.pojo.User;

public class PayloadBuilder {

    public static User createUser() {

        User user = new User();

        user.setName("Arijit");
        user.setJob("QA Automation");

        return user;
    }
}