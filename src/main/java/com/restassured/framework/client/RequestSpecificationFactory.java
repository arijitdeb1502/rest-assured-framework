package com.restassured.framework.client;

import com.restassured.framework.auth.TokenManager;
import com.restassured.framework.config.ConfigReader;
import com.restassured.framework.constants.FrameworkConstants;
import com.restassured.framework.enums.RequestType;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecificationFactory {

    private RequestSpecificationFactory() {
    }

    /**
     * Returns the correct RequestSpecification
     * based on the RequestType.
     */
    public static RequestSpecification getSpecification(
            RequestType requestType) {

        switch (requestType) {

            case AUTHENTICATED:
                return createAuthenticatedSpecification();

            case MULTIPART:
                return createMultipartSpecification();

            case FORM:
                return createFormSpecification();

            case DEFAULT:
            default:
                return createDefaultSpecification();
        }
    }

    /**
     * Creates the common RequestSpecBuilder.
     */
    private static RequestSpecBuilder createBaseBuilder() {

        return new RequestSpecBuilder()

                .setBaseUri(ConfigReader.getBaseUrl())

                .setAccept(ContentType.JSON)

                .addHeader(FrameworkConstants.API_KEY_HEADER,
                        ConfigReader.getApiKey())

                .log(LogDetail.ALL);

    }

    /**
     * Default Request Specification.
     */
    private static RequestSpecification createDefaultSpecification() {

        return createBaseBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    /**
     * JWT Authenticated Request Specification.
     */
    private static RequestSpecification createAuthenticatedSpecification() {

        return createBaseBuilder()
                .setContentType(ContentType.JSON)
                .addHeader(
                        FrameworkConstants.AUTHORIZATION,
                        FrameworkConstants.BEARER + TokenManager.getToken())
                .build();
    }

    /**
     * Multipart Request Specification.
     */
    private static RequestSpecification createMultipartSpecification() {

        return createBaseBuilder()
                .build();
    }

    /**
     * Form URL Encoded Specification.
     */
    private static RequestSpecification createFormSpecification() {

        return createBaseBuilder()
                .setContentType("application/x-www-form-urlencoded")
                .build();
    }

}