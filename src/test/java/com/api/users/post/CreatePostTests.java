package com.api.users.post;

import com.api.users.create.CreatePostRequestBody;
import com.api.users.create.response.CreatePostResponse;
import com.api.users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CreatePostTests {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreatePost(){

        //1.Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        CreatePostResponse createPostResponse = usersService.createPost(requestBody);

        //3.Assert
        createPostResponse.assertPost(requestBody);


    }

}
