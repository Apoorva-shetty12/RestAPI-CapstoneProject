package com.api.users.create.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class CreateUserErrorResponse {

    @Setter
    private int statusCode;
    private String error;
    @JsonProperty("data")
    private Data data;

    public void assertUser(int expectedStatusCode) {
        Assert.assertEquals(this.getStatusCode(),expectedStatusCode);
        Assert.assertEquals(this.getError(),"BODY_NOT_VALID");
        Assert.assertEquals(this.getData().getEmail(),"Email already used");
    }

    @Getter
    public static class Data {
        private String email;
        private String firstName;
        private String lastName;
    }
}
