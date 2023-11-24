package com.video.app.backend.payload;

import com.video.app.backend.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto {
    private String id;
    private String title;
    private String description;
    private MultipartFile videoFile;
    private User user;
}
