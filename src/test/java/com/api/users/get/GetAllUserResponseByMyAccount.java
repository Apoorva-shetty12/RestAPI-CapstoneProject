package com.api.users.get;

import lombok.Getter;
import lombok.Setter;

@Getter
public class GetAllUserResponseByMyAccount {

    @Setter
    private int statusCode;

    private String total;
    private Data[] data;
    private String limit;
    private String page;

    @Getter
    public static class Data {
        private String firstName;
        private String lastName;
        private String id;
    }
}
