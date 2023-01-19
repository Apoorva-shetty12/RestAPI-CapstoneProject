package com.api.users;

import com.api.RequestWrapper;
import com.api.users.create.CreatePostRequestBody;
import com.api.users.create.CreateUserRequestBody;
import com.api.users.create.response.RestAssureWrapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserClient {
    RestAssureWrapper restAssureWrapper = new RestAssureWrapper();
    public Response create(CreateUserRequestBody body) {
        RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                .body(body).httpMethod("post").endPoint("user/create").build();
        return this.restAssureWrapper.execute(requestWrapper);
    }
        /*Response response =  given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");

        response.then()
                .log().body();

        return response;

         */
        public Response postCreate(CreatePostRequestBody body) {
            RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                    .body(body).httpMethod("post").endPoint("post/create").build();
            return this.restAssureWrapper.execute(requestWrapper);

        }


    public Response getPost(String id) {

        /*RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                .httpMethod("GET").pathParams(Map.of("id", id)).endPoint("post/"+id).build();
        return this.restAssureWrapper.execute(requestWrapper);
*/

        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .get("https://dummyapi.io/data/v1/post/{id}");
        response.then()
                .log().body();
        return response;


    }

    public Response getAllUser() {
        RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                .httpMethod("GET").endPoint("user").build();
        return this.restAssureWrapper.execute(requestWrapper);

       /* Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .when()
                .get("https://dummyapi.io/data/v1/user");
        response.then()
                .log().body();
        return response;

        */
    }

    public Response getUserByAccount() {
            /*
        RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                .httpMethod("GET").endPoint("user").build();
        return this.restAssureWrapper.execute(requestWrapper);
        */
        Response response = given()
                     .header("app-id", "63849396d9cf2f44805f4cd2")
                     .param("created", 1)
                .when()
                    .get("https://dummyapi.io/data/v1/user");
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
