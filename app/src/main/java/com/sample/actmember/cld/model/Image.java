package com.sample.actmember.cld.model;

public class Image {
    String path;
    String name;

    public Image(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}
