package com.valen.aiatest2.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flickr_photo")
@Getter @Setter
public class Photo {
    @Id
    @GenericGenerator(name = "id", strategy = "uuid")
    @GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
    private String id;

    private String title;

//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
//    private Date date;
    private String owner;
    private String secret;

    public Photo(String title, String owner, String secret) {
        this.title = title;
        this.owner = owner;
        this.secret = secret;
    }

    public Photo() {
    }
}
