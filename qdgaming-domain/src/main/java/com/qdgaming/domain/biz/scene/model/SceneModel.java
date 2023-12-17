package com.qdgaming.domain.biz.scene.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/17 18:31
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SceneModel {
    private Long id;
    private String name;
    private String nodes;
    private Date createTime;
    private Date updateTime;
}
