package com.valen.aiatest2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class FlickrPhoto {
    private String id;
    private String owner;
    private String secret;
    private Integer server;
    private Integer farm;
    private String title;
    @JsonProperty("ispublic")
    private Integer isPublic;
    @JsonProperty("isfriend")
    private Integer isFriend;
    @JsonProperty("isfamily")
    private Integer isFamily;

    public FlickrPhoto(String id, String owner, String secret, Integer server, Integer farm, String title, Integer isPublic, Integer isFriend, Integer isFamily) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.isPublic = isPublic;
        this.isFriend = isFriend;
        this.isFamily = isFamily;
    }

    public FlickrPhoto() {
    }
}
