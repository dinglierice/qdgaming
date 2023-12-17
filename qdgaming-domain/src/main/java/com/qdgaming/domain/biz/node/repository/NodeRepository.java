package com.qdgaming.domain.biz.node.repository;


import com.qdgaming.domain.biz.node.model.NodeModel;

import java.util.List;

public interface NodeRepository {
    List<NodeModel> list(int rows);

    NodeModel findNodeById(Long id);

    int removeNodeById(Long id);

    NodeModel insert(NodeModel nodeModel);

    int updateNode(NodeModel nodeModel);
}
