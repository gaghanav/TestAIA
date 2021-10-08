package com.valen.aiatest2.controller;

import com.valen.aiatest2.entities.*;
import com.valen.aiatest2.services.FlickrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flickr")
@CrossOrigin("*")
public class FlickrController {

    @Autowired
    FlickrService flickrService;


    @GetMapping("/tag/get/{id}")
    public FlickrResponse getFlickrPhotoTag(@PathVariable String id){
        return flickrService.getFlickrTag(id);
    }

    @GetMapping("/tag/check")
    public FlickrResponse checkTempFlickr(){
        return flickrService.checkTempFlickrTag();
    }

    @DeleteMapping("/tag/clear")
    public String clearTempFlickr(){
        return flickrService.clearTempFlickrTag();
    }

    @PostMapping("/tag/save")
    public String saveTempTag(){
       return flickrService.saveTag();
    }

    @GetMapping("/photo/get")
    public FlickrResponseWithStats searchFlickrPhotoByText(@RequestParam(name = "text") String text){
        return flickrService.getFlickrPhotoResponse(text);
    }

    @GetMapping("/photo/check")
    public FlickrResponseWithStats checkTempFlickrPhotoSearch(){
        return flickrService.checkTempFlickrPhotoResponse();
    }

    @DeleteMapping("/photo/clear")
    public String clearTempFlickrPhoto(){
        return flickrService.clearTempFlickrPhotoResponse();
    }

    @PostMapping("/photo/save")
    public String saveTempPhoto(){
        return flickrService.savePhoto();
    }

    @GetMapping("/photos")
    public Page<Photo> getPhotosByPage(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page-1, size);
        return flickrService.getPhotoByPage(pageable);
    }

    @GetMapping("/tags")
    public Page<Tag> getTagsByPage(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page-1, size);
        return flickrService.getTagByPage(pageable);
    }
}
