package com.valen.aiatest2.services.impl;

import com.valen.aiatest2.constants.Constant;
import com.valen.aiatest2.entities.*;
import com.valen.aiatest2.services.FlickrService;
import com.valen.aiatest2.services.PhotoService;
import com.valen.aiatest2.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class FlickrServiceImpl implements FlickrService {
    @Autowired
    private WebClient webClient;

    @Autowired
    private TagService tagService;

    @Autowired
    private PhotoService photoService;

    private FlickrResponse tempFlickrResponse = new FlickrResponse();
    private FlickrResponseWithStats tempFlickrPhotoResponse = new FlickrResponseWithStats();

    @Override
    public FlickrResponse getFlickrTag(String id) {
        tempFlickrResponse =  webClient
                .get()
                .uri("/?"+ Constant.GET_PHOTO_TAG_METHOD +"&"+Constant.API_KEY+"&photo_id="+id+Constant.FORMAT_JSON_NO_CALLBACK)
                .retrieve()
                .bodyToMono(FlickrResponse.class)
                .block();
        return tempFlickrResponse;
    }

    @Override
    public FlickrResponse checkTempFlickrTag() {
        return tempFlickrResponse;
    }

    @Override
    public String clearTempFlickrTag() {
        if(tempFlickrResponse.getPhoto()!=null) {
            tempFlickrResponse = new FlickrResponse();
            return String.format(Constant.TEMPCLEARED,Constant.TAG);
        }
        else {
            return String.format(Constant.TEMPEMPTY, Constant.TAG);
        }
    }

    @Override
    public String saveTag() {
        if(tempFlickrResponse.getPhoto()!=null){
            for (FlickrTag t : tempFlickrResponse.getPhoto().getTags().getTag()
            ) {
                Tag tag = new Tag();
                tag.setAuthor(t.getAuthor());
                tag.setAuthorName(t.getAuthorName());
                tag.setName(t.getRaw());
                tag.setTagId(t.getId());
                tagService.saveTag(tag);
            }
            clearTempFlickrTag();
            return String.format(Constant.SAVED, Constant.TAG);
        }
        else {
            return clearTempFlickrTag();
        }
    }

    @Override
    public FlickrResponseWithStats getFlickrPhotoResponse(String text) {
        tempFlickrPhotoResponse = webClient
                .get()
                .uri("/?"+Constant.GET_PHOTO_METHOD+"&"+Constant.API_KEY+"&text="+text+Constant.FORMAT_JSON_NO_CALLBACK)
                .retrieve()
                .bodyToMono(FlickrResponseWithStats.class)
                .block();
        return tempFlickrPhotoResponse;
    }

    @Override
    public FlickrResponseWithStats checkTempFlickrPhotoResponse() {
        return tempFlickrPhotoResponse;
    }

    @Override
    public String clearTempFlickrPhotoResponse() {
        if(tempFlickrPhotoResponse.getPhotos()!=null) {
            tempFlickrPhotoResponse = new FlickrResponseWithStats();
            return String.format(Constant.TEMPCLEARED,Constant.PHOTO);
        }
        else {
            return String.format(Constant.TEMPEMPTY, Constant.PHOTO);
        }
    }

    @Override
    public String savePhoto() {
        if(tempFlickrPhotoResponse.getPhotos()!=null){
            for (FlickrPhoto p: tempFlickrPhotoResponse.getPhotos().getPhotos()
                 ) {
                Photo photo = new Photo();
                photo.setTitle(p.getTitle());
                photo.setOwner(p.getOwner());
                photo.setSecret(p.getSecret());
                photoService.savePhoto(photo);
            }
            return String.format(Constant.SAVED, Constant.PHOTO);
        }
        else {
            return clearTempFlickrTag();
        }
    }

    @Override
    public Page<Tag> getTagByPage(Pageable pageable) {
        return tagService.getTagByPage(pageable);
    }

    @Override
    public Page<Photo> getPhotoByPage(Pageable pageable) {
        return photoService.getPhotoByPage(pageable);
    }
}
