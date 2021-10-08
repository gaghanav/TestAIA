package com.valen.aiatest2.entities;

import lombok.Getter;
import lombok.Setter;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class FlickrResponse {
    private FlickrPhotoTag photo;

    public FlickrResponse(FlickrPhotoTag photo) {
        this.photo = photo;
    }

    public FlickrResponse() {
    }
}