package com.restassured.framework.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restassured.framework.auth.TokenManager;
import com.restassured.framework.config.ConfigReader;
// import com.restassured.framework.reporting.ExtentManager;
import com.restassured.framework.utils.EnvironmentManager;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class FrameworkInitializer {

    private static final Logger logger =
            LogManager.getLogger(FrameworkInitializer.class);
    
    static String env = EnvironmentManager.getEnvironment();


    private static RequestSpecification requestSpecification;

    private FrameworkInitializer() {
        // Prevent object creation
    }

    public static void initialize() {

        logger.info("========================================");
        logger.info("Framework Initialization Started");
        logger.info(
                "Jenkins Environment = {}",
                env
        );
        logger.info("========================================");

        // Read Base URL
        String baseUrl = ConfigReader.getBaseUrl();

        logger.info("Base URL : {}", baseUrl);

        // Configure Rest Assured
        RestAssured.baseURI = baseUrl;

        // Create common Request Specification
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        logger.info("Request Specification Created");

        // Initialize authentication
        TokenManager.initialize();

        // Initialize reporting (later)
        // ExtentManager.initialize();

        logger.info("Framework Ready");
    }

    public static RequestSpecification getRequestSpecification() {

        if (requestSpecification == null) {
            throw new IllegalStateException(
                    "Framework is not initialized. RequestSpecification is null.");
        }

        return requestSpecification;
    }

    public static void shutdown() {

        logger.info("========================================");
        logger.info("Framework Shutdown");
        logger.info("========================================");

        // Flush reports (later)
        // ExtentManager.flush();

        // Reset Rest Assured
        RestAssured.reset();

        // Clear Request Specification
        requestSpecification = null;
    }
}