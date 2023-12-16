package com.qdgaming.repository.orm.convert;

import com.qdgaming.domain.biz.node.model.NodeModel;
import com.qdgaming.domain.biz.user.model.UserModel;
import com.qdgaming.repository.orm.node.NodeDO;
import com.qdgaming.repository.orm.user.UserDO;

import java.util.Date;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/16 20:48
 */
public class NodeConverter {
    public static NodeModel convertNodeDO2NodeModel(NodeDO nodeDO) {
        if (nodeDO == null) {
            return null;
        }

        return NodeModel.builder()
                .id(nodeDO.getId())
                .createTime(nodeDO.getCreateTime())
                .updateTime(nodeDO.getUpdateTime())
                .nodeName(nodeDO.getNodeName())
                .script(nodeDO.getScript())
                .build();
    }

    public static NodeDO convertNodeModel2NodeDO(NodeModel nodeModel) {
        if (nodeModel == null) {
            return null;
        }

        NodeDO nodeDO = NodeDO.builder()
                .nodeName(nodeModel.getNodeName())
                .script(nodeModel.getScript())
                .build();
        nodeDO.setCreateTime(nodeModel.getCreateTime());
        nodeDO.setCreateTime(nodeModel.getUpdateTime());
        return nodeDO;
    }
}
