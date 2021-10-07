package com.valen.aiatest2.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter @Setter
public class FlickrPhoto {

    private String id;
    private Tags tags;

    public FlickrPhoto(String id, Tags tags) {
        this.id = id;
        this.tags = tags;
    }

    public FlickrPhoto() {
    }
}
