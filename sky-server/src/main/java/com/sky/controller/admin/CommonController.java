package com.sky.controller.admin;

/**
 * ClassName:CommonController
 * Package: com.sky.controller.admin
 * Description:
 *
 * @Autor: Tong
 * @Create: 15.11.25 - 16:54
 * @Version: v1.0
 *
 */

import com.sky.result.Result;
import com.sky.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Common Interface
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "Common APIs")
@Slf4j
@RequiredArgsConstructor
public class CommonController {

    private final CommonService commonService;

    /**
     * file upload
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("file upload")
    public Result<String> upload(MultipartFile file) {
        log.info("file upload:{}", file);

        String url = commonService.upload(file);
        return Result.success(url);
    }
}
