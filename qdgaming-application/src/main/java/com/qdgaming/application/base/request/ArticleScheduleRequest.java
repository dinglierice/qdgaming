package com.qdgaming.application.base.request;

import lombok.Builder;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/2 18:55
 */
@Data
@Builder
public class ArticleScheduleRequest {
    private int requestTime;
    private int qps;
    private String appCode;
    private String actionCode;
}
