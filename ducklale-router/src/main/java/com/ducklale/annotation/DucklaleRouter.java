package com.ducklale.annotation;

import com.ducklale.enums.SourceType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DucklaleRouter {
    String idAttribute() default "id";
    Class<?> routerClass() default Object.class;
    SourceType readOrWrite() default SourceType.READ;
    boolean isNeedReflectId() default true;
}
