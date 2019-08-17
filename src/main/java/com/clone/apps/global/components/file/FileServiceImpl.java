package com.clone.apps.global.components.file;

import com.clone.apps.global.components.PropertyService;
import com.clone.apps.global.errors.AppsException;
import com.clone.apps.global.errors.BusinessException;
import com.clone.apps.global.errors.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    private final Path location;

    @Autowired
    public FileServiceImpl(PropertyService propertyService) {
        this.location = Paths.get(propertyService.getFilePath()).toAbsolutePath().normalize();
        log.info("location: {}", location);
        try {
            Files.createDirectories(this.location);
        } catch(Exception e) {
            log.error(e.toString());
            throw new AppsException(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }

    @Override
    public String upload(MultipartFile mFile) {
        String fileName = StringUtils.cleanPath(mFile.getOriginalFilename());
        try {

            if(fileName.contains("..")) {
                throw new AppsException(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
            }

            Path targetLocation = this.location.resolve(fileName);
            Files.copy(mFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;

        } catch (IOException ex) {
            log.error("File I/O Error");
            throw new AppsException(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }

    @Override
    public Resource download(String fileName) {
        try {
            Path filePath = this.location.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if(!resource.exists()) {
                log.debug("File Not Found.");
                throw new BusinessException(ErrorCode.NOT_FOUND.getCode(), String.format(ErrorCode.NOT_FOUND.getMessage(), "File"));
            }

            return resource;
        } catch (MalformedURLException e) {
            log.error("MalformedURLException.");
            throw new AppsException(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
}