package com.valen.aiatest2.services.impl;

import com.valen.aiatest2.entities.Photo;
import com.valen.aiatest2.repositories.PhotoRepository;
import com.valen.aiatest2.services.FlickrService;
import com.valen.aiatest2.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    @Override
    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public void deletePhoto(Photo photo) {
        Photo delPhoto =photoRepository.getById(photo.getId());
        photoRepository.delete(delPhoto);
    }

    @Override
    public Photo getPhoto(String id) {
        return photoRepository.getById(id);
    }

    @Override
    public Page<Photo> getPhotoByPage(Pageable pageable) {
        return photoRepository.findAll(pageable);
    }
}
