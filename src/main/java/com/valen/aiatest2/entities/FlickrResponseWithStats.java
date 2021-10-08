package com.valen.aiatest2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class FlickrResponseWithStats {
    private FlickrPhotoResponse photos;
    private String stats;

    public FlickrResponseWithStats(FlickrPhotoResponse photos, String stats) {
        this.photos = photos;
        this.stats = stats;
    }

    public FlickrResponseWithStats() {
    }
}
