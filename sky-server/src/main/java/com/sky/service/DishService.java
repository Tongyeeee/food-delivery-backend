package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

/**
 * ClassName:DishService
 * Package: com.sky.service
 * Description:
 *
 * @Autor: Tong
 * @Create: 16.11.25 - 15:21
 * @Version: v1.0
 *
 */
public interface DishService {

    /**
     * Add a new dish and its flavors
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);

    /**
     * Dish pagination query
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * Batch delete dishes
     * @param ids
     */
    void deletBatch(List<Long> ids);
}
