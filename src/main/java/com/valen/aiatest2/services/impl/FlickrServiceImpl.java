package com.valen.aiatest2.services.impl;

import com.valen.aiatest2.constants.Constant;
import com.valen.aiatest2.entities.Flickr;
import com.valen.aiatest2.entities.FlickrTag;
import com.valen.aiatest2.entities.Tag;
import com.valen.aiatest2.services.FlickrService;
import com.valen.aiatest2.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.time.Duration;

@Service
public class FlickrServiceImpl implements FlickrService {
    @Autowired
    private WebClient webClient;

    @Autowired
    private TagService tagService;

    private  Flickr tempFlickr = new Flickr();


    @Override
    public Flickr getFlickrTag(String id) {
        tempFlickr =  webClient
                .get()
                .uri("/?"+ Constant.GET_PHOTO_TAG_METHOD +"&"+Constant.API_KEY+"&photo_id="+id+Constant.FORMAT_JSON_NO_CALLBACK)
                .retrieve()
                .bodyToMono(Flickr.class)
                .block();
        return  tempFlickr;
    }

    @Override
    public Flickr checkTempFlickrTag() {
        return tempFlickr;
    }

    @Override
    public String clearTempFlickrTag() {
        String response = "Temporary Tag Is Empty";
        if(tempFlickr.getPhoto()!=null) {
            tempFlickr = new Flickr();
            response = "Temporary Tag have been cleared";
        }
        return response;
    }

    @Override
    public void saveTag() {
        for (FlickrTag t:tempFlickr.getPhoto().getTags().getTag()
             ) {
            Tag tag = new Tag();
            tag.setAuthor(t.getAuthor());
            tag.setAuthorName(t.getAuthorName());
            tag.setName(t.getRaw());
            tag.setTagId(t.getId());
            tagService.saveTag(tag);
        }
    }
}
