package com.api;

import com.api.users.PostService;
import com.api.users.create.CreatePostRequestBody;
import com.api.users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAndGetPost {

    PostService postService;

    @BeforeClass
    public void beforeClass() {
        postService = new PostService();
    }
    @Test
    public void shouldCreatePostAndGetPostById(){

        //1.Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        String id = postService.createPost(requestBody).getId();

        //3.Assert
        postService.getPostById(id).assertPost(requestBody);

    }
}
