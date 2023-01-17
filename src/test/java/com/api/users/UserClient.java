package com.api.users;

import com.api.users.create.CreatePostRequestBody;
import com.api.users.create.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    public static Response create(CreateUserRequestBody body) {
        Response response =  given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");

        response.then()
                .log().body();

        return response;
    }

    public static Response getAllUser() {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .when()
                .get("https://dummyapi.io/data/v1/user");
        response.then()
                .log().body();
        return response;
    }

    public static Response getUserByAccount() {
        Response response = given()
                     .header("app-id", "63849396d9cf2f44805f4cd2")
                     .param("created", 1)
                .when()
                    .get("https://dummyapi.io/data/v1/user");
        response.then()
                .log().body();
        return response;
    }

    public static Response postCreate(CreatePostRequestBody body) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/post/create");

        response.then()
                .log().body();
        return response;
    }

    public static Response getPost(String id) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
             .when()
                .get("https://dummyapi.io/data/v1/post/{id}");
        response.then()
                .log().body();
        return response;
    }

    public static Response deletePost(String id) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .delete("https://dummyapi.io/data/v1/post/{id}");
        response.then()
                .log().body();
        return response;
    }

    public static Response getDelete(String id) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .delete("https://dummyapi.io/data/v1/post/{id}");
        response.then()
                .log().body();
        return response;
    }


}
