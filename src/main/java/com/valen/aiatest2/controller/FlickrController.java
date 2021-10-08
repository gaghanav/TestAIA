package com.valen.aiatest2.controller;

import com.valen.aiatest2.entities.FlickrPhotoResponse;
import com.valen.aiatest2.entities.FlickrResponse;
import com.valen.aiatest2.entities.FlickrResponseWithStats;
import com.valen.aiatest2.services.FlickrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flickr")
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
}
