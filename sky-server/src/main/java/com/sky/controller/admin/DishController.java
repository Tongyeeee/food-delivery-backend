package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:DishController
 * Package: com.sky.controller.admin
 * Description: Dish Management
 *
 * @Autor: Tong
 * @Create: 16.11.25 - 15:11
 * @Version: v1.0
 *
 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "Dish-related APIs")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * add ish
     * @param dishDTO
     * @return
     */
    @PostMapping
    @ApiOperation("add dish")
    public Result save(@RequestBody DishDTO dishDTO) {
        log.info("add dish:{}", dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }
}
