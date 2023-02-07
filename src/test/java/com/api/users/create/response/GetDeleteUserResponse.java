package com.api.users.create.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class GetDeleteUserResponse {
    @Setter
    private int statusCode;

    @Setter
    private String error;

    public void assertDeletedUser(int expectedStatusCode, String expectedMessage) {
        //Assert.assertEquals(this.getError(),error);
        Assert.assertEquals(statusCode,expectedStatusCode);
        Assert.assertEquals(this.error,expectedMessage);

    }
}
