package com.qdgaming.domain.biz.article.model;

import com.qdgaming.domain.biz.article.enums.Action;
import com.qdgaming.domain.biz.article.enums.App;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/2 12:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleModel {
    private int id;
    private Date createTime;
    private Date updateTime;
    private App app;
    private Action action;
    private Map<String, Object> req;
    private Object result;
}
