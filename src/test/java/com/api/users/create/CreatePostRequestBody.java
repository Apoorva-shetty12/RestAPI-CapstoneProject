package com.api.users.create;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreatePostRequestBody {

    private String owner;
    private String image;
    private String text;
    private List<String> tags;

    List<String> list = new ArrayList<>();

    public CreatePostRequestBody(Builder builder) {
        this.owner = builder.owner;
        this.image = builder.image;
        this.text = builder.text;
        this.tags = builder.tags;
    }


    public static class Builder {
        private String owner;
        private String image;
        private String text;
        private List<String> tags = new ArrayList<>();

        public Builder() {
            this.owner = "63bfb1d354edce3c2cd3deb7";
            this.image = "https://media.gettyimages.com/id/1333977253/photo/male-lion-resting-on-a-rock.jpg?s=612x612&w=gi&k=20&c=x785lj0J9oEVJXKB_I1yVsvRXjA4i7sdAte9W91-ZTA=";
            this.text = "King of the forest";
            this.tags = getList();
        }

        public List<String> getList() {
            tags.add("deer");
            tags.add("buffalo");
            return tags;
        }

        public CreatePostRequestBody build() {
            CreatePostRequestBody createPostRequestBody = new CreatePostRequestBody(this);
            return createPostRequestBody;
        }

        public Builder owner(String owner) {
            this.owner = owner;
            return this;
        }
    }
}

