package com.qdgaming.repository.orm.scene;

import com.qdgaming.repository.orm.base.BaseEntityDO;
import lombok.Builder;

@Builder
public class SceneDO extends BaseEntityDO {
    private String name;

    private String nodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes == null ? null : nodes.trim();
    }
}