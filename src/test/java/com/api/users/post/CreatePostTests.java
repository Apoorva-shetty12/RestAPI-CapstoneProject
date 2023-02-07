package com.api.users.post;

import com.api.users.PostService;
import com.api.users.create.CreatePostRequestBody;
import com.api.users.create.response.CreatePostResponse;
import com.api.users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CreatePostTests {
    PostService postService;

    @BeforeClass
    public void beforeClass() {
        postService = new PostService();
    }

    @Test
    public void shouldCreatePost(){

        //1.Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        CreatePostResponse createPostResponse = postService.createPost(requestBody);

        //3.Assert
        createPostResponse.assertPost(requestBody);


    }

}
