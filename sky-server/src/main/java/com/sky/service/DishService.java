package com.sky.service;

import com.sky.dto.DishDTO;

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
}
