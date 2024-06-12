package com.itheima.anno;

import java.lang.annotation.*;

/**
 * 自定义Log注解
 */
@Target(ElementType.METHOD)        // 标识方法
@Retention(RetentionPolicy.RUNTIME)    // 运行时有效
public @interface Log {
}