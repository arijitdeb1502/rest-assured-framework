package com.restassured.framework.tests;

import org.testng.annotations.Test;

import com.restassured.framework.base.BaseTest;

public class FrameworkTest extends BaseTest {

    @Test
    public void verifyFrameworkInitialization() {

        System.out.println("Framework initialized successfully.");

    }
}