package com.api;

import com.api.users.create.CreateUserRequestBody;
import com.api.users.create.response.CreateUserErrorResponse;
import com.api.users.UsersService;
import com.api.users.create.response.CreateUserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NegativeTests {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldNotAllowToCreateUserWithUsedEmail(){

        //1.Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        usersService.createUser(requestBody);

        //2.Act
        CreateUserErrorResponse errorResponse = usersService.createUserExpectingError(requestBody);

        //3.Assert
        errorResponse.assertUser(400);

    }
}
