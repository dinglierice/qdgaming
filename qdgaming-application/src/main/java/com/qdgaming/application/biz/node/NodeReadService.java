package com.qdgaming.application.biz.node;

import com.qdgaming.domain.biz.node.model.NodeModel;
import com.qdgaming.domain.biz.node.service.NodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/17 10:32
 */
@Service
public class NodeReadService {
    @Resource
    NodeService nodeService;

    public List<NodeModel> list(int rows) {
        return nodeService.list(rows);
    }
}
