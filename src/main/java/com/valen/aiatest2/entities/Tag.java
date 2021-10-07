package com.valen.aiatest2.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "flickr_tag")
@Getter
@Setter
public class Tag {
    @Id
    @GenericGenerator(name = "id", strategy = "uuid")
    @GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
    private String id;
    private String tagId;
    private String author;
    private String authorName;
    private String name;

    public Tag(String id, String tagId, String author, String authorName, String name) {
        this.id = id;
        this.tagId = tagId;
        this.author = author;
        this.authorName = authorName;
        this.name = name;
    }

    public Tag() {
    }
}
