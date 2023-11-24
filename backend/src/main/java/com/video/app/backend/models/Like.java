package com.video.app.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "likes")
public class Like {
    @Id
    private String Id;
    @DBRef
    private Video video;
    @DBRef
    private User user;
}
