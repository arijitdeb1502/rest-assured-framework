package com.restassured.framework.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.restassured.framework.core.FrameworkInitializer;
import com.restassured.framework.enums.RequestType;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public final class APIClient {

    private static final Logger logger =
            LogManager.getLogger(APIClient.class);

    private APIClient() {
    }
    
    private static RequestSpecification prepareRequest(
            RequestType requestType) {

        return RestAssured
                .given()
                .spec(
                    RequestSpecificationFactory
                            .getSpecification(requestType));

    }

    /**
     * Executes HTTP GET request.
     */
    public static Response get(
            String endpoint,
            RequestType requestType) {

        logger.info("GET : {}", endpoint);

        return prepareRequest(requestType)

                .when()

                .get(endpoint)

                .then()

                .extract()

                .response();

    }

    /**
     * Executes HTTP POST request.
     */
    public static Response post(
            String endpoint,
            Object body,
            RequestType requestType) {

        logger.info("POST : {}", endpoint);

        return prepareRequest(requestType)

                .body(body)

                .when()

                .post(endpoint)

                .then()

                .extract()

                .response();
    }
    
    
    public static Response put(
            String endpoint,
            Object body,
            RequestType requestType) {

        logger.info("PUT : {}", endpoint);

        return prepareRequest(requestType)

                .body(body)

                .when()

                .put(endpoint)

                .then()

                .extract()

                .response();

    }
    
    
    public static Response patch(
            String endpoint,
            Object body,
            RequestType requestType) {

        logger.info("PATCH : {}", endpoint);

        return prepareRequest(requestType)

                .body(body)

                .when()

                .patch(endpoint)

                .then()

                .extract()

                .response();

    }
    
    public static Response delete(
            String endpoint,
            RequestType requestType) {

        logger.info("DELETE : {}", endpoint);

        return prepareRequest(requestType)

                .when()

                .delete(endpoint)

                .then()

                .extract()

                .response();

    }

}