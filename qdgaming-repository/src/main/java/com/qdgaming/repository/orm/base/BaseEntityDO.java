package com.qdgaming.repository.orm.base;

import lombok.Data;

import java.util.Date;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/25 9:37
 */
@Data
public class BaseEntityDO {
    public final static String EMPTY_JSON_ARRAY = "[]";
    public final static String EMPTY_JSON_OBJECT = "{}";

    private Long id;

    private Date createTime = new Date();

    private Date updateTime = new Date();

}
