package com.restassured.framework.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.restassured.framework.core.FrameworkInitializer;

public abstract class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        FrameworkInitializer.initialize();

    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {

        FrameworkInitializer.shutdown();

    }

}