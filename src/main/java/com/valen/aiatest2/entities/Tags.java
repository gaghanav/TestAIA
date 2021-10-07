package com.valen.aiatest2.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tags {
    private FlickrTag[] tag;

    public Tags(FlickrTag[] tag) {
        this.tag = tag;
    }

    public Tags() {
    }
}
