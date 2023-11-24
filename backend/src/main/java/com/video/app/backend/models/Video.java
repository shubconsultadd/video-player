package com.video.app.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Document(collection = "videos")
@Data
public class Video {
    @Id
    private String id;
    private String title;
    private String description;
    @Transient
    private MultipartFile videoFile;
    @DBRef
    private User user;
    @DBRef
    private List<Like> likes;
    @DBRef
    private List<Comment> comments;
}
