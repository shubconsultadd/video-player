package com.video.app.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
@Data
public class Comment {
    @Id
    private String Id;
    private String content;
    @DBRef
    private Video video;
    @DBRef
    private User user;
}
