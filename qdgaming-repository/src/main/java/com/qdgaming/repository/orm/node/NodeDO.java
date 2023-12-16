package com.qdgaming.repository.orm.node;

import com.qdgaming.repository.orm.base.BaseEntityDO;
import lombok.Builder;

@Builder
public class NodeDO extends BaseEntityDO {
    private String nodeName;

    private String script;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script == null ? null : script.trim();
    }
}