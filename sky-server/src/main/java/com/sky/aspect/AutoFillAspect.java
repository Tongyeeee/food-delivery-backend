package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:AutoFillAspect
 * Package: com.sky.aspect
 * Description: Define a custom aspect to implement automatic filling of common fields.
 *
 * @Autor: Tong
 * @Create: 09.11.25 - 18:14
 * @Version: v1.0
 *
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    @Pointcut("@annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointcut(){}

    @Before("autoFillPointcut() && @annotation(autoFill)")
    public void autoFill(JoinPoint joinPoint, AutoFill autoFill) {
        log.info("Start automatic filling of common fields...");

        OperationType operationType = autoFill.value();

        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }

        Object arg = args[0];

        // ① 如果是 List —— 批量处理
        if (arg instanceof List) {
            List<?> list = (List<?>) arg;
            for (Object entity : list) {
                fillEntity(operationType, entity);
            }
            return;
        }

        // ② 如果是单个对象 —— 直接处理
        fillEntity(operationType, arg);
    }


    /**
     * 给单个实体对象填充字段
     */
    private void fillEntity(OperationType operationType, Object entity) {
        if (entity instanceof DishFlavor) {
            return; // 不对 DishFlavor 填充
        }

        LocalDateTime now = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();

        Class<?> clazz = entity.getClass();

        try {
            if (operationType == OperationType.INSERT) {
                // setCreateTime
                clazz.getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class)
                        .invoke(entity, now);

                // setCreateUser
                clazz.getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class)
                        .invoke(entity, currentId);
            }

            // INSERT 和 UPDATE 都要设置 update 字段
            clazz.getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class)
                    .invoke(entity, now);

            clazz.getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class)
                    .invoke(entity, currentId);

        } catch (Exception e) {
            log.error("AutoFill failed for entity: {}", entity, e);
        }
    }
}

