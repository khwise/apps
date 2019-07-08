package com.clone.apps.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by kh.jin on 2019. 7. 6.
 */
@Service
public class FileServiceImpl implements FileService {

    // private PropertyService propertyService;

    private final Path location;

    @Autowired
    public FileServiceImpl(PropertyService propertyService) {
        this.location = Paths.get(propertyService.getFilePath()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.location);
        } catch(Exception e) {
            //todo : 뭔가 비지니스 에러가 아닌 시스템 에러에 대한 처리가 필요하다.
            throw new RuntimeException();
        }
    }

    @Override
    public String upload(MultipartFile mFile) {
        String fileName = StringUtils.cleanPath(mFile.getOriginalFilename());

        try {

            if(fileName.contains("..")) {
                //throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Path targetLocation = this.location.resolve(fileName);
            Files.copy(mFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException();
            //throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }


    @Override
    public Resource download(String fileName) {
        try {
            Path filePath = this.location.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }

    }
}
