package com.video.app.backend.Repository;

import com.video.app.backend.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
    User findByEmail(String email);
}
