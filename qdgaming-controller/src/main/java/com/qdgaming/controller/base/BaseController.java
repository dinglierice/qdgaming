package com.qdgaming.controller.base;

import com.qdgaming.controller.base.result.ResultCode;
import com.qdgaming.controller.base.result.WebResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public abstract class BaseController {

    /**
     * @return 成功消息
     */
    protected WebResult<?> success() {
        return new WebResult<>(ResultCode.OK, "成功");
    }

    /**
     * @param message 信息
     * @return 信息结果
     */
    protected WebResult<?> successString(String message) {
        return new WebResult<>(ResultCode.OK, message);
    }

    /**
     * @param code    结果码
     * @param message 消息
     * @return 结果消息
     */
    protected WebResult<?> success(ResultCode code, String message) {
        return new WebResult<>(code, message);
    }

    /**
     * @param object 对象
     * @return 对象信息
     */
    protected WebResult<?> successObject(Object object) {
        WebResult<Object> webResult = new WebResult<>(ResultCode.OK, "成功");
        webResult.setData(object);
        return webResult;

    }

    /**
     * @param object 基础对象
     * @return 对象信息
     */
    protected <T> WebResult<T> success(T object) {
        WebResult<T> webResult = new WebResult<>(ResultCode.OK, "成功");
        webResult.setData(object);
        return webResult;
    }

    /**
     * @param map 键值对
     * @return 键值对结果
     */
    protected WebResult<?> success(Map<String, Object> map) {
        WebResult<Map<String, Object>> webResult = new WebResult<>(ResultCode.OK, "成功");
        webResult.setData(map);
        return webResult;
    }
}
