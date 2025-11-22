package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:SetmealDishMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Autor: Tong
 * @Create: 22.11.25 - 15:39
 * @Version: v1.0
 *
 */

@Mapper
public interface SetmealDishMapper {
    /**
     * Query set meal IDs by dish ID
     * @param dishId
     * @return
     */
    List<Long> getSetmealDishIdsByDishId(@Param("dishIds") List<Long> dishId);
}
