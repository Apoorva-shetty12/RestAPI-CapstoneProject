package com.api;

import com.api.users.create.CreatePostRequestBody;
import com.api.users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CreateAndDeletePost {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreateAndDeletePost() {

        //1.Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        String id = usersService.createPost(requestBody).getId();

        //3.Assert
        usersService.deletePostByID(id).assertPostDelete(id);

    }
}