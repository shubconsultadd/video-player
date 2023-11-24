package com.video.app.backend.Service.videoFileService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Service
public interface VideoFIleService {
    String uploadImage(String path, MultipartFile video) throws IOException;

    InputStream getResource(String path, String fileName) throws FileNotFoundException;
}
