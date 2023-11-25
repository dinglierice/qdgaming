package com.qdgaming.controller.base.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebResult<T> {

    private ResultCode code = ResultCode.OK;
    private T data;
    private String msg = "success";

    public WebResult(ResultCode code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public WebResult(ResultCode code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public WebResult(T data) {
        this.data = data;
    }

}
