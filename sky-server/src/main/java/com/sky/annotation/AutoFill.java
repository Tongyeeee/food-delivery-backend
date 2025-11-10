package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * ClassName:AutoFill
 * Package: com.sky.annotation
 * Description: 自定义注解，用于标识某个方法需要进行功能字段自动填充处理
 *
 * @Autor: Tong
 * @Create: 09.11.25 - 18:03
 * @Version: v1.0
 *
 */
@Target(ElementType.METHOD)
public @interface AutoFill {
    OperationType value();
}
