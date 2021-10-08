package com.valen.aiatest2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlickrPhotoResponse {
    private String page;
    private String pages;
    @JsonProperty("perpage")
    private Integer perPage;
    private Integer total;
    @JsonProperty("photo")
    private FlickrPhoto[] photos;

    public FlickrPhotoResponse(String page, String pages, Integer perPage, Integer total, FlickrPhoto[] photos) {
        this.page = page;
        this.pages = pages;
        this.perPage = perPage;
        this.total = total;
        this.photos = photos;
    }

    public FlickrPhotoResponse() {
    }
}
