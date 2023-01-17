package com.api.users.create.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class GetDeletedPostResponse {
    @Setter
    private int statusCode;

    private String error;

    public void assertDeletePost(int expectedStatusCode, String expectedMessage) {
        Assert.assertEquals(statusCode,expectedStatusCode);
        Assert.assertEquals(error,expectedMessage);
    }
}
