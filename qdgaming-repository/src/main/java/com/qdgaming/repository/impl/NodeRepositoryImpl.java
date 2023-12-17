package com.qdgaming.repository.impl;

import com.qdgaming.domain.biz.node.model.NodeModel;
import com.qdgaming.domain.biz.node.repository.NodeRepository;
import com.qdgaming.repository.mapper.node.NodeDOMapper;
import com.qdgaming.repository.orm.convert.NodeConverter;
import com.qdgaming.repository.orm.node.NodeDO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/16 20:30
 */
@Service
public class NodeRepositoryImpl implements NodeRepository {
    @Resource
    NodeDOMapper nodeDOMapper;

    @Override
    public List<NodeModel> list(int rows) {
        List<NodeDO> nodeDOS = nodeDOMapper.selectHead(rows);
        return nodeDOS.stream().map(NodeConverter::convertNodeDO2NodeModel).collect(Collectors.toList());
    }

    @Override
    public NodeModel findNodeById(Long id) {
        return NodeConverter.convertNodeDO2NodeModel(nodeDOMapper.selectByPrimaryKey(id));
    }

    @Override
    public int removeNodeById(Long id) {
        return nodeDOMapper.deleteByPrimaryKey(id);
    }

    // TODO 事务问题再看看
    @Override
    public NodeModel insert(NodeModel nodeModel) {
        int insert = nodeDOMapper.insert(NodeConverter.convertNodeModel2NodeDO(nodeModel));
        if (insert > 0) {
            NodeDO nodeDO = nodeDOMapper.selectByName(nodeModel.getNodeName());
            return NodeConverter.convertNodeDO2NodeModel(nodeDO);
        }
        return null;
    }

    @Override
    @Transactional
    public int updateNode(NodeModel node) {
        NodeDO nodeDO = NodeConverter.convertNodeModel2NodeDO(node);
        return nodeDOMapper.updateByPrimaryKeySelective(nodeDO);
    }
}
