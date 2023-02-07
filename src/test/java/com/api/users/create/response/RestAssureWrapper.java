/*package com.api.users.create.response;

import com.api.RequestWrapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class RestAssureWrapper {

    private String baseURL= "https://dummyapi.io/data/v1/";

    //switch

    public Response execute (RequestWrapper requestWrapper){
        RequestSpecification requestSpecification= given()
                .headers(requestWrapper.getHeader())
                .contentType(ContentType.JSON)
                //pathparam here
                .when();
        Response response = switch (requestWrapper.getHttpMethod().toUpperCase()) {
            case "POST" -> requestSpecification.body(requestWrapper.getBody()).post(baseURL + requestWrapper.getEndPoint());
            case "GET" -> requestSpecification.get(baseURL + requestWrapper.getEndPoint());
            case "DELETE" -> requestSpecification.delete(baseURL + requestWrapper.getEndPoint());
            default -> null;
        };

        return response;

    }


}

 */
