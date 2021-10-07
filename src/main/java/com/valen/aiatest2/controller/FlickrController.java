package com.valen.aiatest2.controller;

import com.valen.aiatest2.entities.Flickr;
import com.valen.aiatest2.services.FlickrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flickr")
public class FlickrController {

    @Autowired
    FlickrService flickrService;


    @GetMapping("/get/{id}")
    public Flickr getFlickr(@PathVariable String id){
        return flickrService.getFlickrTag(id);
    }

    @GetMapping("/check")
    public Flickr checkTempFlickr(){
        return flickrService.checkTempFlickrTag();
    }

    @DeleteMapping("/clear")
    public String clearTempFlickr(){
        return flickrService.clearTempFlickrTag();
    }

    @PostMapping("/save")
    public void saveTempTag(){
        flickrService.saveTag();
    }
}
