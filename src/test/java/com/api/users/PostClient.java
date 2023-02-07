package com.api.users;

//import com.api.RequestWrapper;
import com.api.users.create.CreatePostRequestBody;
//import com.api.users.create.response.RestAssureWrapper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostClient {

    //RestAssureWrapper restAssureWrapper = new RestAssureWrapper();
    public Response postCreate(CreatePostRequestBody body) {
            Response response = given()
                    .header("app-id", "63849396d9cf2f44805f4cd2")
                    .contentType(ContentType.JSON)
                    .body(body)
                    .filter(new AllureRestAssured())
                    .when()
                    //.filter(new AllureRestAssured())
                    .post("https://dummyapi.io/data/v1/post/create");

            response.then()
                    .log().body();
            return response;

        /*RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                .body(body).httpMethod("post").endPoint("post/create").build();
        return this.restAssureWrapper.execute(requestWrapper);
         */
    }
    public Response getPost(String id) {
        /*
        RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                .httpMethod("GET").pathParams(Map.of("id", id)).endPoint("post/"+id).build();
        return this.restAssureWrapper.execute(requestWrapper);
        */
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .filter(new AllureRestAssured())
                .get("https://dummyapi.io/data/v1/post/{id}");
        response.then()
                .log().body();
        return response;

    }
    public Response deletePost(String id) {
        /*
        RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                .httpMethod("Delete").pathParams(Map.of("id", id)).endPoint("post/"+id).build();
        return this.restAssureWrapper.execute(requestWrapper);
        */
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .filter(new AllureRestAssured())
                .delete("https://dummyapi.io/data/v1/post/{id}");
        response.then()
                .log().body();
        return response;
    }

    public Response getDelete(String id) {
        /*
        RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                .httpMethod("get").pathParams(Map.of("id", id)).endPoint("post/"+id).build();
        return this.restAssureWrapper.execute(requestWrapper);
        */
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .filter(new AllureRestAssured())
                .delete("https://dummyapi.io/data/v1/post/{id}");
        response.then()
                .log().body();
        return response;
    }
}
