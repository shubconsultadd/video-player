package com.video.app.backend.Service.videoFileService;

import com.video.app.backend.Repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class VideoFIleServiceImpl implements VideoFIleService {
    @Autowired
    private VideoRepo videoRepo;
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public String uploadImage(String path, MultipartFile video) throws IOException {
        String name = video.getOriginalFilename();

        String randomID = UUID.randomUUID().toString();
        String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));

        String filePath = path + File.separator + fileName1;

        File file1 = new File(path);

        if(!file1.exists())
            file1.mkdir();

        Files.copy(video.getInputStream(), Paths.get(filePath));

        return fileName1;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        return new FileInputStream(fullPath);
    }
}
