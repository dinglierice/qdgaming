package com.qdgaming.domain.biz.node.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/16 20:25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NodeModel {
    /**
     * 节点id
     */
    private Long id;

    /**
     * 节点名
     */
    private String nodeName;

    /**
     * 节点对应的ETL脚本
     */
    private String script;
    private Date createTime;
    private Date updateTime;
}
