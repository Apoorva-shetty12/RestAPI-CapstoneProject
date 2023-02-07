package com.api.users;

import com.api.users.create.CreatePostRequestBody;
import com.api.users.create.response.CreatePostResponse;
import com.api.users.create.response.GetDeletedPostResponse;
import com.api.users.post.getPost.DeletePostResponse;
import com.api.users.post.getPost.GetPostResponse;
import io.restassured.response.Response;

public class PostService {
    public static CreatePostResponse createPost(CreatePostRequestBody body) {
        Response response = new PostClient().postCreate(body);
        CreatePostResponse createPostResponse = response.as(CreatePostResponse.class);
        createPostResponse.setStatusCode(response.statusCode());

        return createPostResponse;
    }

    public GetPostResponse getPostById(String id){

        Response response = new PostClient().getPost(id);
        int statusCode = response.statusCode();
        GetPostResponse getPostResponse = response.as(GetPostResponse.class);
        getPostResponse.setStatusCode(statusCode);

        return getPostResponse;
    }

    public DeletePostResponse deletePostByID(String id){

        Response response = new PostClient().deletePost(id);
        int statusCode = response.statusCode();
        DeletePostResponse deletePostResponse = response.as(DeletePostResponse.class);
        deletePostResponse.setStatusCode(statusCode);

        return deletePostResponse;
    }

    public GetDeletedPostResponse getDeletePost(String id){

        Response response = new PostClient().getDelete(id);
        int statusCode = response.statusCode();
        GetDeletedPostResponse getDeletedPostResponse = response.as(GetDeletedPostResponse.class);
        getDeletedPostResponse.setStatusCode(statusCode);

        return getDeletedPostResponse;
    }

}
