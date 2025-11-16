package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
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
}
