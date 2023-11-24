package com.video.app.backend.Repository;

import com.video.app.backend.models.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepo extends MongoRepository<Video,String> {
}
