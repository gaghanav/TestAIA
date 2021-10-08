package com.valen.aiatest2.services;

import com.valen.aiatest2.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlickrService {
    FlickrResponse getFlickrTag(String id);
    FlickrResponse checkTempFlickrTag();
    String clearTempFlickrTag();
    String saveTag();
    FlickrResponseWithStats getFlickrPhotoResponse(String text);
    FlickrResponseWithStats checkTempFlickrPhotoResponse();
    String clearTempFlickrPhotoResponse();
    String savePhoto();
    Page<Tag> getTagByPage(Pageable pageable);
    Page<Photo> getPhotoByPage(Pageable pageable);
}
