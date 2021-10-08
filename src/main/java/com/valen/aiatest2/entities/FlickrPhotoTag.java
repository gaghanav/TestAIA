package com.valen.aiatest2.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter @Setter
public class FlickrPhotoTag {

    private String id;
    private Tags tags;

    public FlickrPhotoTag(String id, Tags tags) {
        this.id = id;
        this.tags = tags;
    }

    public FlickrPhotoTag() {
    }
}
