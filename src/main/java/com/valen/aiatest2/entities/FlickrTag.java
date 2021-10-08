package com.valen.aiatest2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlickrTag {
    private String id;
    private String author;
    @JsonProperty("authorname")
    private String authorName;
    private String raw;
    @JsonProperty("_content")
    private String content;
    @JsonProperty("machine_tag")
    private Boolean machineTag;

    public FlickrTag(String id, String author, String authorName, String raw, String content, Boolean machineTag) {
        this.id = id;
        this.author = author;
        this.authorName = authorName;
        this.raw = raw;
        this.content = content;
        this.machineTag = machineTag;
    }

    public FlickrTag() {
    }
}
