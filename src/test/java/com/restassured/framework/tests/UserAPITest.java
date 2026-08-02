package com.restassured.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.framework.base.BaseTest;
import com.restassured.framework.client.APIClient;
import com.restassured.framework.enums.RequestType;
import com.restassured.framework.constants.Endpoints;

import io.restassured.response.Response;

public class UserAPITest extends BaseTest {

    @Test
    public void verifyGetUser() {

    	Response response =
    	        APIClient.get(
    	                Endpoints.GET_USER,
    	                RequestType.DEFAULT);

    	Assert.assertEquals(
    	        response.statusCode(),
    	        200);
    	    	
    	// Assert User Details
        Assert.assertEquals(response.jsonPath().getInt("data.id"), 2,
                "User ID validation failed.");

        Assert.assertEquals(response.jsonPath().getString("data.email"),
                "janet.weaver@reqres.in",
                "Email validation failed.");

        Assert.assertEquals(response.jsonPath().getString("data.first_name"),
                "Janet",
                "First name validation failed.");

        Assert.assertEquals(response.jsonPath().getString("data.last_name"),
                "Weaver",
                "Last name validation failed.");

        // Assert Avatar
        Assert.assertNotNull(response.jsonPath().getString("data.avatar"),
                "Avatar should not be null.");

        Assert.assertTrue(
                response.jsonPath().getString("data.avatar")
                        .contains("https://"),
                "Avatar URL should start with https://");

        // Optional - Response Time
        Assert.assertTrue(response.getTime() < 3000,
                "Response time exceeded 3 seconds.");

    	


    }

}