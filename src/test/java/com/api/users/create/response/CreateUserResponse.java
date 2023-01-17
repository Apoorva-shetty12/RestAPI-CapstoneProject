package com.api.users.create.response;

import com.api.users.create.CreateUserRequestBody;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class CreateUserResponse {
    @Setter
    private int statusCode;

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String registerDate;
    private String updatedDate;

    public void assertUser(CreateUserRequestBody requestBody) {
        Assert.assertEquals(this.getStatusCode(),200);
        Assert.assertNotNull(this.getId());
        Assert.assertEquals(this.getEmail(),requestBody.getEmail());
        Assert.assertEquals(this.getFirstName(),requestBody.getFirstName());
        Assert.assertEquals(this.getLastName(),requestBody.getLastName());
    }
}

