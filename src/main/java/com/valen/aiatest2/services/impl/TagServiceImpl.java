package com.valen.aiatest2.services.impl;

import com.valen.aiatest2.entities.Tag;
import com.valen.aiatest2.repositories.TagRepository;
import com.valen.aiatest2.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTag(String id) {
        return tagRepository.getById(id);
    }

    @Override
    public void deleteTag(Tag tag) {
        Tag delTag = tagRepository.getById(tag.getTagId());
        if(tag.getTagId()!=null){
            tagRepository.delete(delTag);
        }
    }

    @Override
    public Page<Tag> getTagByPage(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }
}
