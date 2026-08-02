package com.api.utils;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIUtils {

    public static Response post(String endpoint, Object body) {

        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint);
    }
}