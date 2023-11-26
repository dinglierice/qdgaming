package com.qdgaming.controller.auth;

import lombok.Getter;

public enum FeatureType {

    /**
     * 公共接口，所有人均可访问。
     */
    PUBLIC("公共接口"),

    /**
     * 用户登录能访问
     */
    USER_LOGIN("读者登录");

    @Getter
    private final String description;

    FeatureType(String description) {
        this.description = description;
    }


    public static String toString(FeatureType status) {
        if (status == null) {
            return null;
        }
        return status.name();
    }

    public static FeatureType toEnum(String s) {
        if (s == null) {
            return null;
        }
        return FeatureType.valueOf(s);
    }
}
