package com.restassured.framework.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.restassured.framework.base.BaseTest;
import com.restassured.framework.client.APIClient;
import com.restassured.framework.constants.Endpoints;
import com.restassured.framework.enums.RequestType;
import com.restassured.framework.payloads.PayloadBuilder;
import com.restassured.framework.pojo.User;

import io.restassured.response.Response;

public class CreateUserTest extends BaseTest {

    @Test
    public void createUser() {

        // Arrange
        User user = PayloadBuilder.createUser();

        // Act
        Response response = APIClient.post(
                Endpoints.CREATE_USER,
                user,
                RequestType.PUBLIC);

        // Print Response
        response.prettyPrint();

        // Assert
        assertEquals(response.getStatusCode(), 201,
                "Status code validation failed.");

        assertEquals(response.jsonPath().getString("name"),
                user.getName(),
                "User name validation failed.");

        assertEquals(response.jsonPath().getString("job"),
                user.getJob(),
                "Job validation failed.");
    }
}