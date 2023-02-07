package com.api.users;

import com.api.users.create.CreatePostRequestBody;
import com.api.users.create.CreateUserRequestBody;
import com.api.users.create.response.*;
import com.api.users.get.GetAllUserResponseByMyAccount;
import com.api.users.get.GetAllUsers;
import com.api.users.post.getPost.DeletePostResponse;
import com.api.users.post.getPost.GetPostResponse;
import io.restassured.response.Response;

public class UsersService {
    public static CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = new UserClient().create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public static CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response = new UserClient().create(body);
        CreateUserErrorResponse createUserErrorResponse = response.as(CreateUserErrorResponse.class);
        createUserErrorResponse.setStatusCode(response.statusCode());
        return createUserErrorResponse;
    }

    public static GetAllUsers getUser() {
        Response response = new UserClient().getAllUser();
        int statusCode = response.statusCode();
        GetAllUsers getAllUsers = response.as(GetAllUsers.class);
        getAllUsers.setStatusCode(statusCode);

        return getAllUsers;

    }

    public static GetAllUserResponseByMyAccount getUsersByAccount(){
        Response response = new UserClient().getUserByAccount();
        int statusCode = response.statusCode();
        GetAllUserResponseByMyAccount getAllUserResponseByMyAccount =  response.as(GetAllUserResponseByMyAccount.class);
        getAllUserResponseByMyAccount.setStatusCode(statusCode);

        return getAllUserResponseByMyAccount;
    }
    public DeleteUserResponse deleteUserByID(String id){

        Response response = new UserClient().deleteUser(id);
        int statusCode = response.statusCode();
        DeleteUserResponse deleteUserResponse = response.as(DeleteUserResponse.class);
        deleteUserResponse.setStatusCode(statusCode);
        return deleteUserResponse;
    }

    public GetDeleteUserResponse getDeletedUser(String id){

        Response response = new UserClient().getDeleteUser(id);
        int statusCode = response.statusCode();
        GetDeleteUserResponse getDeleteUserResponse = response.as(GetDeleteUserResponse.class);
        getDeleteUserResponse.setStatusCode(statusCode);

        return getDeleteUserResponse;
    }
}
