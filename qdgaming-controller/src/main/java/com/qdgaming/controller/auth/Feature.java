package com.qdgaming.controller.auth;
import java.lang.annotation.*;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/26 20:41
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Feature {

    FeatureType[] value() default {FeatureType.PUBLIC};

}