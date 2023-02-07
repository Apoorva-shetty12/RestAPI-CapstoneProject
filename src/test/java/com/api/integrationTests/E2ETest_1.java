package com.api.integrationTests;

import com.api.users.PostService;
import com.api.users.UsersService;
import com.api.users.create.CreatePostRequestBody;
import com.api.users.create.CreateUserRequestBody;
import com.api.users.create.response.CreatePostResponse;
import com.api.users.create.response.CreateUserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class E2ETest_1 {
    PostService postService;
    UsersService userService;


    @BeforeClass
    public void beforeClass() {
        postService = new PostService();
        userService= new UsersService();
    }
    @Test
    public void shouldCreatePostAndGetPostById(){

        //1.Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();

        //2.Act
        String userId = userService.createUser(requestBody).getId();
        CreatePostRequestBody postRequestBody = new CreatePostRequestBody.Builder().owner(userId).build();
        String id = postService.createPost(postRequestBody).getId();

        //3. Assert
        postService.deletePostByID(id).assertPostDelete(id);
        postService.getDeletePost(id).assertDeletePost(404, "RESOURCE_NOT_FOUND");
        userService.deleteUserByID(userId).assertUserDelete(userId);
        userService.getDeletedUser(userId).assertDeletedUser(404, "RESOURCE_NOT_FOUND");

/* previous implementation
        //1.Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        CreatePostRequestBody createPostRequestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        CreateUserResponse createUserResponse =  userService.createUser(requestBody);
        String id = postService.createPost(createPostRequestBody).getId();

        //3. Assert
        createUserResponse.assertUser(requestBody);
        postService.deletePostByID(id).assertPostDelete(id);
        postService.getDeletePost(id).assertDeletePost(404,"RESOURCE_NOT_FOUND");
*/
    }
}
