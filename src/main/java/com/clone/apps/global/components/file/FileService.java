package com.clone.apps.global.components.file;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by kh.jin on 2019. 7. 6.
 */
public interface FileService {

    String upload(MultipartFile mFile);

    Resource download(String fileName);
}
