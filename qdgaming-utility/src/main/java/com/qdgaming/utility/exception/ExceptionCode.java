package com.qdgaming.utility.exception;

import lombok.Getter;

public enum ExceptionCode {

    OK("成功"),
    LOGIN("没有登录"),
    NOT_FOUND("没有找到资源"),
    UNAUTHORIZED("没有权限"),
    SERVER("系统异常"),
    UNKNOWN("服务器未知错误"),
    ;

    @Getter
    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

}
