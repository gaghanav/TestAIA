package com.valen.aiatest2.entities;

import lombok.Getter;
import lombok.Setter;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Flickr {
    private FlickrPhoto photo;

    public Flickr(FlickrPhoto photo) {
        this.photo = photo;
    }

    public Flickr() {
    }
}