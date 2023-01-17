package com.api;

import com.api.users.get.GetAllUserResponseByMyAccount;
import com.api.users.get.GetAllUsers;
import com.api.users.UsersService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetUserTest {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldGetUsers(){
        GetAllUsers getAllUsers = usersService.getUser();
        Assert.assertEquals(getAllUsers.getStatusCode(),200);
    }

    @Test
    public void shouldGetUsersCreatedByYourAccount(){
        GetAllUserResponseByMyAccount getAllUserResponseByMyAccount = usersService.getUsersByAccount();
        Assert.assertEquals(getAllUserResponseByMyAccount.getStatusCode(),200);
    }

}
