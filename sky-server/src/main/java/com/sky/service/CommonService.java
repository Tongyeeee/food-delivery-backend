package com.sky.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName:CommonService
 * Package: com.sky.service
 * Description:
 *
 * @Autor: Tong
 * @Create: 15.11.25 - 17:02
 * @Version: v1.0
 *
 */
public interface CommonService {
    String upload(MultipartFile file);
}
