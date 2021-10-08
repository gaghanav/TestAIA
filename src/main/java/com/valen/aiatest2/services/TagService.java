package com.valen.aiatest2.services;

import com.valen.aiatest2.entities.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {
    Tag saveTag(Tag tag);
    Tag getTag(String id);
    void deleteTag(Tag tag);
    Page<Tag> getTagByPage(Pageable pageable);
}
