package com.valen.aiatest2.services;

import com.valen.aiatest2.entities.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhotoService {
    Photo savePhoto(Photo photo);
    void deletePhoto(Photo photo);
    Photo getPhoto(String id);
    Page<Photo> getPhotoByPage(Pageable pageable);
}
