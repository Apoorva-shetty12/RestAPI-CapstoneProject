package com.api.users;

//import com.api.RequestWrapper;
import com.api.users.create.CreatePostRequestBody;
import com.api.users.create.CreateUserRequestBody;
//import com.api.users.create.response.RestAssureWrapper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserClient {
    //RestAssureWrapper restAssureWrapper = new RestAssureWrapper();

    public Response create(CreateUserRequestBody body) {
        /*RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                .body(body).httpMethod("post").endPoint("user/create").build();
        return this.restAssureWrapper.execute(requestWrapper);

         */

        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .filter(new AllureRestAssured())
                .post("https://dummyapi.io/data/v1/user/create");

        response.then()
                .log().body();

        return response;

    }

    public Response getAllUser() {
        /*
        RequestWrapper requestWrapper = RequestWrapper.builder().header(Map.of("app-id", "63849396d9cf2f44805f4cd2"))
                .httpMethod("GET").endPoint("user").build();
        return this.restAssureWrapper.execute(requestWrapper);

         */
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .when()
                .filter(new AllureRestAssured())
                .get("https://dummyapi.io/data/v1/user");
        response.then()
                .log().body();
        return response;

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
                .filter(new AllureRestAssured())
                .get("https://dummyapi.io/data/v1/user");
        response.then()
                .log().body();
        return response;
    }

    public Response deleteUser(String id) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .filter(new AllureRestAssured())
                .delete("https://dummyapi.io/data/v1/user/{id}");

        response
                .then()
                .log().body();

        return response;
    }

    public Response getDeleteUser(String id) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .filter(new AllureRestAssured())
                .delete("https://dummyapi.io/data/v1/user/{id}");
        response.then()
                .log().body();
        return response;
    }


}
