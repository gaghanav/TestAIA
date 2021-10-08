package com.valen.aiatest2.services;

import com.valen.aiatest2.entities.FlickrPhotoResponse;
import com.valen.aiatest2.entities.FlickrResponse;
import com.valen.aiatest2.entities.FlickrResponseWithStats;

public interface FlickrService {
    FlickrResponse getFlickrTag(String id);
    FlickrResponse checkTempFlickrTag();
    String clearTempFlickrTag();
    String saveTag();
    FlickrResponseWithStats getFlickrPhotoResponse(String text);
    FlickrResponseWithStats checkTempFlickrPhotoResponse();
    String clearTempFlickrPhotoResponse();
    String savePhoto();
}
