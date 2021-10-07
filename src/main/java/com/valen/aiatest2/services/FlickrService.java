package com.valen.aiatest2.services;

import com.valen.aiatest2.entities.Flickr;
import com.valen.aiatest2.entities.Photo;
import com.valen.aiatest2.entities.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlickrService {
    Flickr getFlickrTag(String id);
    Flickr checkTempFlickrTag();
    String clearTempFlickrTag();
    void saveTag();
}
