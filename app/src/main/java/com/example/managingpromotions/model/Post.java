package com.example.managingpromotions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {

    private int userId;

    private int id;

    private String title;

    @JsonProperty("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
