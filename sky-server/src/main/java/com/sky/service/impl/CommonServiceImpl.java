package com.sky.service.impl;

import com.sky.config.MinioConfig;
import com.sky.service.CommonService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * ClassName:CommonServiceImpl
 * Package: com.sky.service.impl
 * Description:
 *
 * @Autor: Tong
 * @Create: 15.11.25 - 17:03
 * @Version: v1.0
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final MinioClient minioClient;
    private final MinioConfig minioConfig;

    @Override
    public String upload(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

            // 为文件生成唯一名称
            String objectName = UUID.randomUUID() + suffix;

            // 上传文件
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(minioConfig.getBucket())
                            .object(objectName)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );

            // 返回可访问 URL
            return minioConfig.getEndpoint() + "/" + minioConfig.getBucket() + "/" + objectName;

        } catch (Exception e) {
            log.error("File upload error", e);
            throw new RuntimeException("File upload failed");
        }
    }
}

