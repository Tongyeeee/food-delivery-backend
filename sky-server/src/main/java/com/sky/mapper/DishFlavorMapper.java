package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * ClassName:DishFlavorMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Autor: Tong
 * @Create: 16.11.25 - 16:33
 * @Version: v1.0
 *
 */
@Mapper
public interface DishFlavorMapper {
    /**
     * Batch insert flavor data
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * Delete flavor data by dish ID
     * @param dishId
     */
    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deletByDishId(Long dishId);
}
