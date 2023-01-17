package com.api.users.post.getPost;

import com.api.users.create.CreatePostRequestBody;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GetPostResponse {


    @Setter
    private int statusCode;

    private Owner owner;
    private String image;
    private String link;
    private String publishDate;
    private String id;
    private String text;
    private String updatedDate;
    private String likes;
    private List<String> tags;
    List<String> list = new ArrayList<>();


    public void assertPost(CreatePostRequestBody requestBody) {
        Assert.assertEquals(image,requestBody.getImage());
        Assert.assertEquals(tags,requestBody.getTags());
        Assert.assertEquals(text,requestBody.getText());
    }



    @Getter
    public static class Owner {
        private String firstName;
        private String lastName;
        private String id;
    }
}
