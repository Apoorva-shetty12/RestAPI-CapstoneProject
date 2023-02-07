package com.api.users.create.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class DeleteUserResponse {

        @Setter
        private int statusCode;

        private String id;

        public void assertUserDelete(String id) {
            Assert.assertEquals(this.getId(), id);
        }
    }

