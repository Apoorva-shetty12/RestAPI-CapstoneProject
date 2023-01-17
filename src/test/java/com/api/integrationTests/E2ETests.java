package com.api.integrationTests;

import com.api.users.create.CreatePostRequestBody;
import com.api.users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class E2ETests {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }
    @Test
    public void shouldCreatePostAndGetPostById(){

        //1.Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        String id = usersService.createPost(requestBody).getId();

        //3. Assert
        usersService.deletePostByID(id).assertPostDelete(id);
        usersService.getDeletePost(id).assertDeletePost(404,"RESOURCE_NOT_FOUND");


    }
}
